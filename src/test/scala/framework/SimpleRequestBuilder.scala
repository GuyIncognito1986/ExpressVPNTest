package framework

import akka.http.scaladsl.model.{HttpHeader, HttpMethods, HttpRequest, Uri}
import scala.collection.immutable
trait SimpleRequestBuilder {

  def getRequest(absoluteUrlWithQueryString: String, headers: Option[immutable.Seq[HttpHeader]] = None): HttpRequest ={
    HttpRequest(HttpMethods.GET, Uri.apply(absoluteUrlWithQueryString, Uri.ParsingMode.Relaxed), headers.getOrElse(Nil))
  }

}
