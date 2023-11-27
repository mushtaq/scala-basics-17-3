
val map = Map(1 -> "a", 2 -> "b")

map(1)
map.apply(2)
//map(3)

map.get(1)
map.get(2)
map.get(3)


sealed trait Option[T]
case class Some[T](value: T) extends Option[T]
case object None extends Option[Nothing]

