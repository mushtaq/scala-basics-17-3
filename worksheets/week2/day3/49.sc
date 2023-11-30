
trait Option[+T]
case class Some[T](value: T) extends Option[T]
case object None extends Option[Nothing]

val x: Option[String] = if(true) Some("abc") else None
val y: Option[Int] = if(true) Some(10) else None
        
