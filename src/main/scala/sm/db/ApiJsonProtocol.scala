package sm.db

import java.sql.Date

import sm.db.Tables._
import spray.json._

/**
* Created by nilesh on 16/12/2014.
*/
object ApiJsonProtocol extends DefaultJsonProtocol {

  implicit val authorFormat = jsonFormat2(author)
  implicit val citationFormat = jsonFormat2(citation)
  implicit val documentauthorFormat = jsonFormat2(documentauthor)
  implicit val documentfolderFormat = jsonFormat6(documentfolder)
  implicit val documentitemFormat = jsonFormat9(documentitem)
  implicit val matchfolderFormat = jsonFormat10(matchfolder)
  implicit val matchitemFormat = jsonFormat5(matchitem)
  implicit val tokenFormat = jsonFormat3(token)
  implicit val userFormat = jsonFormat2(user)
  implicit object DateJsonFormat extends RootJsonFormat[Date] {
    override def write(obj: Date) = JsNumber(obj.getTime)

    override def read(json: JsValue): Date = json match {
      case JsNumber(n) => Date.valueOf(n.toLong.toString)
      case _ => throw new DeserializationException("Error info you want here ...")
    }
  }
}
