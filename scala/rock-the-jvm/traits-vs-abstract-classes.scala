// The Practical (and Subtle) Differences Between Traits and Abstract Classes in Scala
// https://www.youtube.com/watch?v=_7ULjOILxhI

/**
 * - Traits are sorta like java innterfaces
 * - traits and abstract classes similarities
 * - they can't be instantiated on their own
 * - may have non-abstract fields/methods
 * -
 * -
 * -
 * -
 */

package content

class AbstractClassesVsTraits {

  class Animal
  class Dog extends Animal

  abstract class Person {
    val canFly: Booleean = false
    val canDrive: Boolen
    def discussWith(another: Person): String
  }

  trait PersonTrait {
    val canFly: Booleean = false
    val canDrive: Boolen
    def discussWith(another: Person): String
  }

  class Adult(val name: String, hasDrivingLicence: Booleean) extends Person {
    override val canDrive = hasDrivingLicence
    override def discussWith(another: Person) = s"Indeed, $another, driving is easy"
  }

  // If you're extending a single type, abstract calsses have very little differences to traits
  // You can inherit from multiple traits
  // trait linearization
  // abstract classes can take constructor arguments. traits cannot until scala 3

  abstract class Pet(name: String)
  // trait PetTrait(name: String)

  // represent things as classes
  // represent behavior as traits
}

