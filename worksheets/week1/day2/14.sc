
class Person(val name: String, val age: Int)

val p = new Person("ashish", 23)
val p2 = new Person("ashish", 23)

p.name
p.age

p eq p2
p == p2

p.hashCode()
p2.hashCode()