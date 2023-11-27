
val map = Map(1 -> "a", 2 -> "b")


map.get(1): Option[String]
map.get(1).isInstanceOf[Some[String]]
map.get(1).isInstanceOf[Option[String]]
map.get(1).isInstanceOf[Any]
map.get(1).isInstanceOf[None.type]

map.get(2)
map.get(3)
map.get(4)

{
  trait Option[T]
  case object None extends Option[Nothing]
  case class Some[T](x: T) extends Option[T]
}

1: Int
Some(1): Some[Int]