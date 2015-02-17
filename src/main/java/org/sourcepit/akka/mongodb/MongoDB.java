/*
 * Copyright 2015 Bernd Vogt and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sourcepit.akka.mongodb;

import akka.actor.AbstractExtensionId;
import akka.actor.ActorSystem;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import akka.actor.ExtensionId;
import akka.actor.ExtensionIdProvider;

/**
 * @author Bernd Vogt <bernd.vogt@sourcepit.org>
 */
public final class MongoDB implements Extension {

   /**
    * Internal extension id and extension id provider implementation.
    */
   private static final class MongoDBExtensionId extends AbstractExtensionId<MongoDB> implements ExtensionIdProvider {
      @Override
      public MongoDB createExtension(ExtendedActorSystem arg0) {
         return new MongoDB();
      }

      @Override
      public ExtensionId<? extends Extension> lookup() {
         return this;
      }
   }

   public static final ExtensionId<MongoDB> ID = new MongoDBExtensionId();

   public static MongoDB get(ActorSystem system) {
      return ID.get(system);
   }

   private MongoDB() {
   }


}
