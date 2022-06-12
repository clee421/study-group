// Use apply functional programming style from
// https://www.manning.com/books/functional-programming-in-scala
// to solve the problem:
// https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Instructions on how to run the file
 * $ scalac main-2.scala
 * scala main-2.scala
 */

sealed trait NodeInterface[+A] {
  def value: A
  def next: NodeInterface[A]
}

object NodeNil extends NodeInterface[Nothing] {
    def value = throw new NoSuchElementException("head of empty list")
    def next = throw new UnsupportedOperationException("tail of empty list")
}

case class NodeCons[+A] (value: A, next: NodeInterface[A]) extends NodeInterface[A] {
  override def toString = s"head: $value, next: $next"
}

class PriorityQueue[Int] {
  private var _queue = new Array[Int]()

  def push(value: Int) = {
    this._queue = this._queue :+ value
  }

  def pop() = {

  }

  def parent(index: Int): Int = {
    (index - 1) / 2
  }

  def leftChild(index: Int): Int = {
    (2 * index) + 1
  }

  def rightChild(index: Int): Int = {
    (2 * index) + 2
  }

  def shiftUp(index: Int) = {
    var currentIndex = index
    while (index > 0 && this._queue(this.parent(currentIndex)) > this._queue(currentIndex)) {
      val parentIndex = this.parent(currentIndex)
      val temp = this._queue(parentIndex)
      this._queue(parentIndex) = this._queue(currentIndex)
      this._queue(currentIndex) = temp

      currentIndex = parentIndex
    }
  }

  def shiftDown(index: Int) = {

  }
}

 object Main {
   def main(args: Array[String]) = {
      val node1 = NodeCons(1, NodeNil)
      val node2 = NodeCons(2, node1)
      val node3 = NodeCons(3, node2)
      println(node1)
      println(node2)
      println(node3)
   }
 }

