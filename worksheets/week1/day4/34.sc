import play.api.libs.json._
import data.Data

{
  def transformKVs(kvMap: Map[String, JsValue]): Map[String, JsValue] = {
    kvMap.map { case (k, v) =>
      if (k == "m" || k == "n") (k, v) else (k, transform(v))
    }
  }

  def transform(json: JsValue): JsValue = {
    json match {
      case JsNull          => JsString("I am null")
      case JsNumber(x)     => JsNumber(x * x)
      case JsBoolean(x)    => JsBoolean(!x)
      case JsString(x)     => JsString(if (x.startsWith("urn:")) x.stripPrefix("urn:") else x)
      case JsArray(xs)     => JsArray(xs.map(transform))
      case JsObject(kvMap) => JsObject(transformKVs(kvMap.toMap))
      case _               => json
    }
  }

  Json.prettyPrint(transform(Data.json))
}
