case class Person(name: String, age: Int)

object Person {
  def apply(name: String, age: Int) = new Person(name, age)
}

val p0 = new Person("ashish", 23)
val p = Person("ashish", 23)
val p2 = Person.apply("ashish", 23)

// case class: toString, getters, hashcode, equality
// case class companion: apply