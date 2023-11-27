import play.api.libs.json._
import data.Data

{
  def transformKVs(kvMap: Map[String, JsValue]): Map[String, JsValue] = kvMap.map {
    case (k @ ("m" | "n"), v) => (k, v)
    case (k, v)               => (k, transform(v))
  }

  def transform(json: JsValue): JsValue = json match {
    case JsNull                              => JsString("I am null")
    case JsNumber(x)                         => JsNumber(x * x)
    case JsBoolean(x)                        => JsBoolean(!x)
    case JsString(x) if x.startsWith("urn:") => JsString(x.stripPrefix("urn:"))
    case JsArray(xs)                         => JsArray(xs.map(transform))
    case JsObject(kvMap)                     => JsObject(transformKVs(kvMap.toMap))
    case _                                   => json
  }

  Json.prettyPrint(transform(Data.json))
}
