import play.api.libs.json._
import data.Data

def transform(json: JsValue): JsValue = {
  // number -> square it
  if (json.isInstanceOf[JsNumber]) {
    val x = json.asInstanceOf[JsNumber].value
    JsNumber(x * x)
  }
  else if (json.isInstanceOf[JsArray]) {
    val xs = json.asInstanceOf[JsArray].value
    JsArray(xs.map(transform))
  }
  else if (json.isInstanceOf[JsObject]) {
    val xs = json.asInstanceOf[JsObject].value
    JsObject(xs.mapValues(transform).toMap)
  }
  else {
    json
  }
  // null -> make it string "I am null"
  // boolean -> flip it
  // string -> make it "Hello $string"
  // string but starts with urn: -> make it "string"
  // if the key is m or n -> keep the value as is
}

def transform2(json: JsValue): JsValue = {
  // number -> square it
  json match {
    case number: JsNumber =>
      val x = number.value
      JsNumber(x * x)
    case array: JsArray =>
      val xs = array.value
      JsArray(xs.map(transform))
    case jsObject: JsObject =>
      val xs = jsObject.value
      JsObject(xs.view.mapValues(transform).toMap)
    case _ =>
      json
  }
}

def transform2(json: JsValue): JsValue = {
  // number -> square it
  json match {
    case JsNumber(x)  => JsNumber(x * x)
    case JsArray(xs)  => JsArray(xs.map(transform))
    case JsObject(xs) => JsObject(xs.view.mapValues(transform).toMap)
    case _            => json
  }
}

val x: Option[Int] = Some(10)

x match {
  case Some(value) => ???
  case None => ???
}

def transform2(json: JsValue): JsValue = json match {
  case JsNull => ???
  case boolean: JsBoolean => ???
  case JsNumber(value) => ???
  case JsString(value) => ???
  case JsArray(value) => ???
  case JsObject(underlying) => ???
}

Json.prettyPrint(transform(Data.json))
