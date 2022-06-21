trait Monoid[A] {
  def op(a1: A, a2: A): A
  def zero: A
}

object Monoid {
  val stringMonoid = new Monoid[String] {
    def op(a1: String, a2: String) = a1 + a2
    val zero = ""
  }

  def listMonoid[A] = new Monoid[List[A]] {
    def op(a1: List[A], a2: List[A]) = a1 ++ a2
    val zero = Nil
  }

  /**
   * 10.1
   */

  val intAddition = new Monoid[Int] {
    def op(a1: Int, a2: Int) = a1 + a2
    val zero = 0
  }

  val intMultiplication = new Monoid[Int] {
    def op(a1: Int, a2: Int) = a1 * a2
    val zero = 1
  }

  val booleanOr = new Monoid[Boolean] {
    def op(a1: Boolean, a2: Boolean) = a1 || a2
    val zero = false
  }

  val booleanAnd = new Monoid[Boolean] {
    def op(a1: Boolean, a2: Boolean) = a1 && a2
    val zero = true
  }


  /**
   * 10.2
   */

  // orElse
  // https://www.scala-lang.org/api/2.12.1/scala/Option.html#orElse[B%3E:A](alternative:=%3EOption[B]):Option[B]
  def optionMonoid[A] = new Monoid[Option[A]] {
    def op(a1: Option[A], a2: Option[A]) = a1 orElse a2
    def zero = None
  }

  /**
   * 10.3
   */

  // andThen
  // https://www.scala-lang.org/api/current/scala/Function1.html#andThen[A](g:R=%3EA):T1=%3EA
  def endoMonoid[A]: Monoid[A => A] = new Monoid[A => A] {
    def op(a1: A => A, a2: A => A) =  a1 andThen a2
    // https://www.scala-lang.org/api/current/scala/Predef$.html#identity[A](x:A):A
    def zero = identity
  }
}