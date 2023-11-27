case class Person(val name: String, val age: Int)

val data = Set(
  new Person("a", 10),
  new Person("b", 20)
)

val person = new Person("a", 10)


data.contains(person)