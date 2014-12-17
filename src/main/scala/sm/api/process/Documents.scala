package sm.api.process

import akka.actor.Actor
import akka.event.Logging
import sm.db.DB
import sm.db.Tables.documentfolder
import spray.http.{StatusCode, StatusCodes}
import spray.routing.RequestContext

import scala.concurrent._
import scala.slick.driver.JdbcDriver.backend.Database
import Database.dynamicSession
import sm.db.ApiJsonProtocol._
import spray.json._
import scala.slick.jdbc.{StaticQuery => Q, Invoker}

/**
* Created by nilesh on 16/12/2014.
*/
object Documents {

  case class ListFolders(userid: String, items: Boolean)
  case class ShowFolder(userid: String, folderName: String)
  case class ExistsFolder(userid: String, folderName: String)
  case class DeleteFolder(userid: String, folderName: String)


}

class Documents(rc: RequestContext) extends Actor with DB {

  import sm.api.process.Documents._

  implicit val system = context.system

  import system.dispatcher

  val log = Logging(system, getClass)

  def receive = {
    case ListFolders(userid, items) =>
      val listFolders = Q.query[String, documentfolder]("SELECT * FROM DocumentFolder WHERE UserId = ?")
      database withDynSession {
        val results = listFolders(userid).mapResult(_.toJson).list
        rc.complete(results.toJson.prettyPrint + "\n")
      }
      context.stop(self)

    case ShowFolder(userid, folderName) =>
      val showFolder = Q.query[(String, String), documentfolder]("SELECT * FROM DocumentFolder WHERE UserId = ? AND Name = ?")
      database withDynSession {
        val result = showFolder(userid, folderName).mapResult(_.toJson).list
        if(result.nonEmpty){
          rc.complete(StatusCode.int2StatusCode(200), result.toJson.prettyPrint + "\n")
        } else {
          rc.complete(StatusCode.int2StatusCode(404), s"""Folder "$folderName" does not exist""")
        }
      }
      context.stop(self)

    case ExistsFolder(userid, folderName) =>
      val showFolder = Q.query[(String, String), Int]("SELECT * FROM DocumentFolder WHERE UserId = ? AND Name = ?")
      database withDynSession {
        showFolder(userid, folderName).firstOption match {
          case Some(1) =>
            rc.complete(StatusCode.int2StatusCode(200))
          case _ =>
            rc.complete(StatusCode.int2StatusCode(404))
        }
      }
      context.stop(self)

    case DeleteFolder(userid, folderName) =>
      val showFolder = Q.query[(String, String), documentfolder]("SELECT * FROM DocumentFolder WHERE UserId = ? AND Name = ?")
      val deleteFolder = Q.update[Int]("DELETE FROM DocumentFolder WHERE Id = ?")
      database withDynSession {
        val result = showFolder(userid, folderName).list
        if(result.nonEmpty) {
          deleteFolder(result.head.id.get).execute
          rc.complete(StatusCode.int2StatusCode(200), result.toJson.prettyPrint + "\n")
        } else {
          rc.complete(StatusCode.int2StatusCode(200), result.mkString(""))
        }
      }
      context.stop(self)

  }
}
