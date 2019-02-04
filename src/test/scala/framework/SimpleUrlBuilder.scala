package framework

trait SimpleUrlBuilder extends TestConfiguration {
  val homepage = s"http://${host}:${port}"
}
