
class Person(name: String, age: Int) {
  def hello = s"${Person.Salutation} $name of age $age"
}

object Person {
  private val Salutation = "Hello"
}


val p = new Person("ashish", 23)

p.hello

//Person.Salutation