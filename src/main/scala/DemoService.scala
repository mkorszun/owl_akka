import akka.actor.{ActorLogging, Actor}
import akka.util.Timeout
import scala.concurrent.duration._
import spray.can.Http
import spray.http._
import HttpMethods._
import MediaTypes._

class DemoService extends Actor with ActorLogging {

  implicit val timeout: Timeout = 1.second // for the actor 'asks'

  // ExecutionContext for the futures and scheduler

  def receive = {
    // when a new connection comes in we register ourselves as the connection handler
    case _: Http.Connected => sender ! Http.Register(self)

    case HttpRequest(GET, Uri.Path("/"), _, _, _) =>
      sender ! index

    case HttpRequest(GET, Uri.Path("/ping"), _, _, _) =>
      sender ! HttpResponse(entity = "PONG!")
  }

  lazy val index = HttpResponse(
    entity = HttpEntity(`text/html`,
      <html>
        <body>
          <h1>Stop bulshiting and learn scala+akka</h1>
        </body>
      </html>.toString()
    )
  )
}