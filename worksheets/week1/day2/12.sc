
val list: List[String] = List("a", "b", "c")
val set: Set[Int] = Set(1, 2, 3)
val map: Map[Int, String] = Map(1 -> "a", 2 -> "b", 3 -> "c")

list(1)
list.apply(1)
list(2)
list.apply(2)

val f1: Int => String = list
val f2: Int => Boolean = set
val f3: Int => String = map


val arr = Array(1, 2, 3)

arr(0)
arr.apply(0)
arr(1)
arr.apply(1)