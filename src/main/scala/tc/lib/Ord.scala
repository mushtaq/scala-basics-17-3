package tc.lib

trait Ord[T]:
  def compare(a: T, b: T): Boolean
  extension (x: T)
    def <=(other: T) = compare(x, other)

object Ord:
  given Ord[Int] with
    def compare(a: Int, b: Int): Boolean = a <= b

  given Ord[String] with
    def compare(a: String, b: String): Boolean = a <= b

  given optOrd[T: Ord]: Ord[Option[T]] with
    def compare(a: Option[T], b: Option[T]): Boolean = (a, b) match
      case (Some(x), Some(y)) => x <= y
      case (None, _)          => true
      case (_, None)          => false

  given pairOrd[T1: Ord, T2: Ord]: Ord[(T1, T2)] with
    def compare(a: (T1, T2), b: (T1, T2)): Boolean =
      if (a._1 == b._1) a._2 <= b._2 else a._1 <= b._1
