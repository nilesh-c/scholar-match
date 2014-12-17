package sm.api.service

import spray.routing.HttpService

/**
 * Created by nilesh on 7/12/14.
 */
trait ProfileApiService extends HttpService {
  def profileRoute(userId: String) =
    path(Segment / "profiles") {
      user =>
        get {
          complete("")
        }
    } ~
      path(Segment / "profiles" / Segment) {
        (user, folder) =>
          get {
            complete("")
          } ~
            head {
              complete("")
            } ~
            post {
              complete("")
            } ~
            put {
              complete("")
            } ~
            delete {
              complete("")
            }
      } ~
      path(Segment / "profiles" / Segment / "items") {
        (user, folder) =>
          get {
            complete("")
          }
      } ~
      path(Segment / "profiles" / Segment / "items" / Segment) {
        (user, folder, item) =>
          get {
            complete("")
          } ~
            head {
              complete("")
            }
      } ~
      path(Segment / "profiles" / Segment / "recalculate") {
        (user, folder) =>
          post {
            complete("")
          }
      }
}