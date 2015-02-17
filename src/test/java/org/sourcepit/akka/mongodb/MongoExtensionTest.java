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

import static org.junit.Assert.*;

import org.junit.Test;

import akka.actor.ActorSystem;

public class MongoExtensionTest {

   @Test
   public void testGetExtension() {
      ActorSystem system;
      system = ActorSystem.create();
      MongoDB ext1 = MongoDB.get(system);
      assertNotNull(ext1);

      system = ActorSystem.create();
      MongoDB ext2 = MongoDB.get(system);
      assertNotNull(ext2);
      assertNotSame(ext1, ext2);
      MongoDB ext3 = system.extension(MongoDB.ID);
      assertNotNull(ext3);
      assertSame(ext2, ext3);

   }

}
