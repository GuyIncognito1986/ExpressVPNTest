package framework

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.core.WireMockConfiguration

trait MockHttpServer extends TestConfiguration {
  private[this] val wiremockConfig = new WireMockConfiguration().bindAddress(host).port(port)
  private[this] val wiremockServer = new WireMockServer(wiremockConfig)
  wiremockServer.start()

  def stub404OnHomepage = {
    wiremockServer.resetAll()
    wiremockServer.stubFor(WireMock.get("/")
      .willReturn(WireMock.aResponse()
      .withStatus(404)))
  }

  def shutdownMockHttpServer = {
    wiremockServer.stop()
    wiremockServer.shutdownServer()
  }
}
