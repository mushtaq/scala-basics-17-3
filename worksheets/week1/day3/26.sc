
// ADTs
// Algebraic Data Types

sealed trait List[T]
case class Cons[T](head: T, tail: List[T]) extends List[T]
case object Nil extends List[Nothing]