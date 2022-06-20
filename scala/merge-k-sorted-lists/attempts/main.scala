// Use apply functional programming style from
// https://www.manning.com/books/functional-programming-in-scala
// to solve the problem:
// https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Instructions on how to run the file
 * $ scala main.scala
 */

// trait: https://docs.scala-lang.org/tour/traits.html
sealed trait LinkedList[+A] {
  import LinkedList.{Cons, Empty, cons, empty}
  def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
    case Cons(h,t) => f(h(), t().foldRight(z)(f))
    case _ => z
  }

  def map[C](f: A => C): LinkedList[C] = foldRight[LinkedList[C]](empty)((head, rest) => cons(f(head), rest))

  def toList[A](): List[A] = foldRight[List[A]](List[A]())((head, rest) => head +: rest)
}

// nothing: https://www.scala-lang.org/api/2.13.5/scala/Nothing.html
case object Empty extends LinkedList[Nothing]

// Cons: https://en.wikipedia.org/wiki/Cons#:~:text=In%20computer%20programming%2C%20cons%20(%2F,%2C%20or%20(cons)%20pairs.
// Loosely related to the object-oriented notion of a constructor
case class Cons[+A](h: () => A, t: () => LinkedList[A]) extends LinkedList[A]

// companion object: https://docs.scala-lang.org/overviews/scala-book/companion-objects.html
object LinkedList {
  def cons[A](hd: => A, tl: => LinkedList[A]): LinkedList[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: LinkedList[A] = Empty

  def apply[A](as: A*): LinkedList[A] =
    if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
}

 object Main {
   def main(args: Array[String]) = {
     val ll = LinkedList(1,2,3,4,5)
     println(ll.toList())
   }
 }

