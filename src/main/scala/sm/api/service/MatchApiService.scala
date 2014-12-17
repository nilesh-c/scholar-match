package sm.api.service

import spray.routing.HttpService

/**
 * Created by nilesh on 7/12/14.
 */
trait MatchApiService extends HttpService {
  def matchRoute(userId: String) =
    path(Segment / "matches") {
      user =>
        get {
          complete("")
        }
    } ~
      path(Segment / "matches") {
        user =>
          get {
            complete("")
          }
      } ~
      path(Segment / "matches" / Segment) {
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
      path(Segment / "matches" / Segment / "profiles" / Segment / "with" / Segment) {
        (user, folder, profileFolder1, profileFolder2) =>
          post {
            complete("")
          } ~
            put {
              complete("")
            }
      } ~
      path(Segment / "matches" / Segment / "items") {
        (user, folder) =>
          get {
            complete("")
          }
      } ~
      path(Segment / "matches" / Segment / "items" / Segment) {
        (user, folder, item) =>
          get {
            complete("")
          } ~
            head {
              complete("")
            }
      } ~
      path(Segment / "matches" / Segment / "recalculate") {
        (user, folder) =>
          post {
            complete("")
          }
      }
}