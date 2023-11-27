import play.api.libs.json._
import data.Data

{
  def transformKVs(kvMap: Map[String, JsValue]): Map[String, JsValue] = kvMap.map {
    case (k @ ("m" | "n"), v) => (k, v)
    case (k, v)               => (k, transform(v))
  }

  def transform(json: JsValue): JsValue = json match {
    case JsNull               => JsString("I am null")
    case JsNumber(x)          => JsNumber(x * x)
    case JsBoolean(x)         => JsBoolean(!x)
//    case JsString("urn" :: x) => JsString(x)
    case JsString(s"urn:$x")  => JsString(x)
    case JsArray(xs)          => JsArray(xs.map(transform))
    case JsObject(kvMap)      => JsObject(transformKVs(kvMap.toMap))
    case _                    => json
  }

  object :: {
    def unapply(string: String): Option[(String, String)] = string.split(":") match {
      case Array(part1, part2) => Some((part1, part2))
      case _                   => None
    }
  }

  Json.prettyPrint(transform(Data.json))
}
