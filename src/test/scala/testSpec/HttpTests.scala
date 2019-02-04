package testSpec

import akka.http.scaladsl.model.StatusCodes
import framework.{Client, MockHttpServer, SimpleRequestBuilder, SimpleUrlBuilder}
import org.specs2.Specification
import org.specs2.specification.AfterAll

import scala.concurrent.Await
import scala.concurrent.duration._

class HttpTests extends Specification with AfterAll with Client with SimpleRequestBuilder with SimpleUrlBuilder with MockHttpServer {
  def is =
    s2"""
        Hitting the homepage on localhost after wiremock has been started should have the following response:
          status must be 404 $statusCheck
          body must be empty $bodyCheck
          headers must contain exactly the server and wiremock matched stub id headers $headerCheck
      """

  stub404OnHomepage

  val resp = syncFireRequest(getRequest(homepage))
  val body = Await.result(resp.entity.httpEntity.toStrict(300 milliseconds).map(b => b.data), 300 milliseconds)

  def statusCheck = resp.status must_== StatusCodes.NotFound
  def bodyCheck = body.length must_== 0
  def headerCheck = {
    resp.headers.length must_== 2
    resp.headers.exists(h => h.name() == "Matched-Stub-Id")
    resp.headers.exists(h => h.name() == "Server")
  }

  def afterAll() = {
    shutdownHttpClientSystem
    shutdownMockHttpServer
  }
}
