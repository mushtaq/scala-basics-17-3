
sealed trait Json
case object JsNull extends Json
case class JsNumber(x: Double) extends Json
case class JsString(x: String) extends Json
case class JsBoolean(x: Boolean) extends Json
case class JsArray(xs: List[Json]) extends Json
case class JsObject(xs: Map[String, Json]) extends Json
