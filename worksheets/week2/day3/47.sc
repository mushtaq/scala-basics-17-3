
class Animal(val legs: Int)
class Tiger extends Animal(4)
class Human extends Animal(2)


val tiger = new Tiger
val human  = new Human
val animal: Animal = tiger

val tigers: List[Tiger] = List(new Tiger)
val animals: List[Animal] = tigers

val dd: Animal = if true then new Animal(1) else new Tiger
//animals(0) = human // not possible

tigers.foreach(t => println(t.legs))
animals.foreach(t => println(t.legs))
/////////////////

val tigers2: Array[Tiger] = Array(new Tiger)
val animals2: Array[Animal] = tigers2 // not ok

animals2(0): Animal
animals2(0) = human

// contra-variance
// all sink types: Writer[-T], Sink[-T], Subscriber[-T]
// val w: Writer[Animal] = ???
// w.write(new Tiger)