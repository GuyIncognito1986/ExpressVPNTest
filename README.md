**Prereqs:**

Java 8+ (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

SBT (https://www.scala-sbt.org/)

Make sure port 1869 is not used by anything/blocked by firewall and you can bind to localhost
as this fires up wiremock in process to stub out the get point for the request
(Can be changed in TestConfiguration trait) 

**To compile (assuming sbt is in path):**

sbt compile

**To test:**

sbt test

**Answers to questions**

1 (How would you test that the ExpressVPN app for any OS of your choice does not send network traffic outside of the VPN tunnel?):

A: Create a completely isolated environment (either by making sure the host os has nothing talking to the outside or by running within docker/vm/locking down the process to a virtual interface), then using either tcpdump/wireshark/raw pcap on windows to capture all the data flowing on that interface, once without expressVPN running (to make sure there really is nothing talking to the outside world on the host) and once over a period of time (5min/30min etc) with expressVPN running.
Then analysing the dump and making sure every packet is sent over the tunnel (correct source/destination and ports).

2 (How would you improve the expressVPN app?):

A: By allowing a free 30 day trial without having to use a card/paypal first.






