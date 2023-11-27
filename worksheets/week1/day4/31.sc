
case class Person(name: String, age: Int)

// object Person {
//   def apply(name: String, age: Int) = new Person(name, age)
//   def unapply(p: Person): Option[(String, Int)] = Some((p.name, p.age))
//}

val p = Person("ashish", 23)  // apply
val Person(nm, ag) = p        // unapply

s"Hello $nm"
ag + 9

p match {
  case Person(n, a) => s"Hello $n of age $a"
}

val t = (1, "abc")
val (x, y) = t

(1, "abc") match {
  case (a, b) => a + 10
}


//val p = Person.apply("ashish", 23)

p
