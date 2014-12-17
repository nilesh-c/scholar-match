package sm.api

import akka.actor.{Props, ActorSystem}
import akka.event.Logging
import akka.io.IO
import spray.can.Http
import sm.api.service.ApiActor

/**
 * Created by nilesh on 3/12/14.
 */
class Boot extends App {
  implicit val system = ActorSystem("api-service")
  val log = Logging(system, getClass)

  // create and start our service actor
  val service = system.actorOf(Props[ApiActor], "api")

  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)
}
