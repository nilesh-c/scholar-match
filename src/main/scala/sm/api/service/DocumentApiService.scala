package sm.api.service

import akka.actor.Props
import sm.api.process.Documents
import spray.routing.{RequestContext, HttpService}

/**
* Created by nilesh on 7/12/14.
*/
trait DocumentApiService extends HttpService {
  def documentActor(implicit requestContext: RequestContext) = actorRefFactory.actorOf(Props(new Documents(requestContext)))

  def documentRoute(userId: String) =
    path(Segment / "documents") {
      /** List all document folders */
      user =>
        (get & parameter("items" ? 0)) {
          items =>
            implicit requestContext =>
              documentActor ! Documents.ListFolders(user, if (items == 0) false else true)
        }
    } ~
      path(Segment / "documents" / Segment) {
        /** CRUD operations for document folders */
        (user, folder) =>
          get {
            /** Show folder */
            implicit requestContext =>
              documentActor ! Documents.ShowFolder(user, folder)
          } ~
            head {
              /** Check if folder exists */
              implicit requestContext =>
                documentActor ! Documents.ExistsFolder(user, folder)
            } ~
            post {
              /** Create folder */
              implicit requestContext =>
                requestContext.complete("dfsdf")
            } ~
            put {
              /** Update folder */
              implicit requestContext =>
                requestContext.complete("sdf")
            } ~
            delete {
              /** Remove folder */
              implicit requestContext =>
                documentActor ! Documents.DeleteFolder(user, folder)
            }
      } ~
      path(Segment / "documents" / Segment / "items") {
        /** CRUD operations for all items inside a document folder */
        (user, folder) =>
          get {
            /** List items in a folder */
            complete("")
          } ~
            post {
              /** Create new items in a folder */
              complete("")
            } ~
            put {
              /** Update existing items in a folder */
              complete("")
            } ~
            delete {
              /** Remove all items in a folder */
              complete("")
            }
      } ~
      path(Segment / "documents" / Segment / "items" / Segment) {
        /** CRUD operations for a document items */
        (user, folder, item) =>
          get {
            /** Show an item */
            complete("")
          } ~
            head {
              /** Check if an item exists */
              complete("")
            } ~
            post {
              /** Create a new item */
              complete("")
            } ~
            put {
              /** Update an existing item */
              complete("")
            } ~
            delete {
              /** Delete an item */
              complete("")
            }
      }

}