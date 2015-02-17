package foo

import akka.actor.Extension
import akka.actor.ExtensionIdProvider
import akka.actor.ExtensionId
import akka.actor.ExtendedActorSystem

class MongoDBExtension extends Extension {
}

object MongoDB2 extends ExtensionId[MongoDBExtension] with ExtensionIdProvider {
  def createExtension(system: ExtendedActorSystem) = new MongoDBExtension
  def lookup() = MongoDB2
}