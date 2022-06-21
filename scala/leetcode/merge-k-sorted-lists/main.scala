// https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Instructions on how to run the file

 * Run everything
 * $ scalac main.scala && DEBUG=true scala main.scala
 */

import scala.collection.mutable._
import scala.util.Random
import scala.util.Properties

object Logger {
  val debug = Properties.envOrElse("DEBUG", "false") == "true"

  def info(message: String): Unit = println(s"INFO: $message")
  def debug(message: String): Unit =  if(debug) println(s"DEBUG: $message")
}

object Main {
  def createArrayDeques(total: Int): Array[ArrayDeque[Int]] = {
    Logger.debug(s"createArrayDeques.total: $total")
    val array = Array.fill[Int](total)(0)
    Logger.debug(s"createArrayDeques.array.length: ${array.length}")
    array.map(_ => new ArrayDeque[Int]())
  }

  def populatePriorityQueue(limit: Int, lists: Array[ArrayDeque[Int]]): PriorityQueue[ArrayDeque[Int]] = {
    Logger.debug(s"populatePriorityQueue.limit: $limit")
    Logger.debug(s"populatePriorityQueue.lists.length: ${lists.length}")
    // This ordering by is still somewhat confusing
    val pq = PriorityQueue.empty[ArrayDeque[Int]](Ordering.by(ad => -ad.head))

    for( n <- 1 to limit ) {
      val listIndex = Random.between(0, lists.length - 1)
      lists(listIndex).append(n)
    }

    lists.foreach(list => {
      if(list.length > 0) {
        pq.enqueue(list)
      }
    })

    pq
  }

  def publishPriorityQueue(queue: PriorityQueue[ArrayDeque[Int]], action: Int => Unit): Unit = {
    Logger.debug("publishPriorityQueue starting")
    while(!queue.isEmpty) {
      val next = queue.dequeue()

      Logger.debug(s"publishPriorityQueue.next.head: ${next.head}")
      action(next.removeHead())

      if(next.size > 0) {
        queue.enqueue(next)
      }
    }

    Logger.debug("publishPriorityQueue done")
  }

  def main(args: Array[String]) = {
    val lists = createArrayDeques(10)
    val pq = populatePriorityQueue(1000, lists)
    Logger.info(pq.toString)

    var list = new ListBuffer[Int]()
    publishPriorityQueue(pq, (n: Int) => list.addOne(n))

    Logger.info(s"list: $list.toList")
  }
}

