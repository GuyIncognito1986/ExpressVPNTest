package framework

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.stream.ActorMaterializer
import scala.concurrent.Await
import scala.concurrent.duration._

trait Client {
  protected[this] implicit val system = ActorSystem("TestSystem")
  protected[this] implicit val materializer = ActorMaterializer()
  protected[this] implicit val executionContext = system.dispatcher

  def asyncFireRequest(req: HttpRequest) ={
    Http().singleRequest(req)
  }

  def syncFireRequest(req: HttpRequest): HttpResponse ={
    Await.result(asyncFireRequest(req), 5 seconds)
  }

  def shutdownHttpClientSystem = {
    materializer.shutdown()
    Await.ready(system.terminate(), 2 seconds)
  }
}
