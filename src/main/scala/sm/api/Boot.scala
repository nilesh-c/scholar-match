package sm.api

import akka.actor.{ActorSystem, Props}
import akka.event.Logging
import akka.io.IO
import sm.api.service.ApiActor
import spray.can.Http

/**
 * Created by nilesh on 3/12/14.
 */
object Boot {
  def main(args: Array[String]) {
    implicit val system = ActorSystem("api-service")
    val log = Logging(system, getClass)

    // create and start our service actor
    val service = system.actorOf(Props[ApiActor], "api")

    // start a new HTTP server on port 8080 with our service actor as the handler
    IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)
  }
}
