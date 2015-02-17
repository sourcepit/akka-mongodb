package foo

import akka.actor.Extension
import akka.actor.ExtensionIdProvider
import akka.actor.ExtensionId
import akka.actor.ExtendedActorSystem
import akka.actor.ActorSystem

class MongoDBExtension extends Extension {
}

object MongoDB2 extends ExtensionId[MongoDBExtension] with ExtensionIdProvider {
  def createExtension(system: ExtendedActorSystem): MongoDBExtension = new MongoDBExtension
  def lookup() = MongoDB2
  def apply()(system: ActorSystem): MongoDBExtension = super.apply(system)
  override def get(system: ActorSystem): MongoDBExtension = super.get(system)
}