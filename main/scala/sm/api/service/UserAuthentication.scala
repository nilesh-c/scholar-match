package sm.api.service

import spray.routing.authentication.{Authentication, ContextAuthenticator}
import spray.routing.AuthenticationFailedRejection
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Either

/**
 * Created by nilesh on 9/12/14.
 */
trait UserAuthentication {
  case class User(userName: String, token: String) {}

  def authenticateUser: ContextAuthenticator[User] = {
    ctx =>
    {
      //get username and password from the url
      val usr = ctx.request.uri.query.get("usr").get
      val pwd = ctx.request.uri.query.get("pwd").get

      doAuth(usr, pwd)
    }
  }

  private def doAuth(userName: String, password: String): Future[Authentication[User]] = {
    //here you can call database or a web service to authenticate the user
    Future {

      Either.cond(password == "test" && userName == "test",
        User(userName = userName, token = java.util.UUID.randomUUID.toString),
        AuthenticationFailedRejection(AuthenticationFailedRejection.CredentialsRejected, List()))
    }
  }
}
