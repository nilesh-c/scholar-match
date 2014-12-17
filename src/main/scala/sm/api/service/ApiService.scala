package sm.api.service

import sm.api.auth.TokenAuthentication

import scala.concurrent.ExecutionContext.Implicits.global


/**
 * Created by nilesh on 16/12/2014.
 */
trait ApiService extends DocumentApiService with ProfileApiService with MatchApiService with TokenAuthentication {
  val apiRoute =
    pathPrefix("api") {
      authenticate(authenticateToken) {
        user =>
          documentRoute(user) ~ profileRoute(user) ~ matchRoute(user)
      }
    }
}
