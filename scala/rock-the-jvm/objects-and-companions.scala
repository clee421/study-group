// Objects and Companions in Scala
// https://www.youtube.com/watch?v=OI3F_fuFYjg

package blog

object ObjectsAndCompanions {

  // scala has a blend of object orientation and functional programming
  class Person (firstName: Stirng, lastName: String) {
    // fields and methods
  }

  // OO design patterns
  // - singleton -> one instance of a type is present

  // scala singleton
  object MySingleton

  object ClusterSingleton {
    value MAX_NODES = 20
    def getNumberOfNodes(): Int = { 14 }
  }

  val maxNodes = ClusterSingleton.MAX_NODES

  // class + object with the same name in the same file
  // class + object = companion

  class Kid(name: String, age: Int) {
    def greet(): String = s"My name is $name and I'm $age years old"
    def chat(): String = s"Do I like veggies? $Kid.LIKES_VEGETABLES"
  }

  // Companion objects are for static fields and methods
  object Kid {
    private val LIKES_VEGETABLES: Boolean = false
    // preconcetion

    // not allowed
    // val likesVeggies = Kid.LIKES_VEGETABLES
  }

  def playGame(kid: Kid) = println("playing a game with a kid")
  val bobbie = new Kid("Bobbie", 9)
  playGame(bobbie)
  // can't do this
  // playGame(Kid)

  def main(args: Array[String]): Unit = {

  }
}