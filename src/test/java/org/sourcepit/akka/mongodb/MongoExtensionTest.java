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

import java.lang.reflect.Method;

import org.junit.Test;

import foo.Bar;
import foo.MongoDB2;
import foo.MongoDB2$;
import foo.MongoDBExtension;
import akka.actor.ActorSystem;
import akka.actor.ExtensionId;

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
   
   @Test
   public void testGetExtension2() {
      ActorSystem system;
      system = ActorSystem.create();
      MongoDBExtension ext1 = MongoDB2.get(system);
      assertNotNull(ext1);

      system = ActorSystem.create();
      MongoDBExtension ext2 = MongoDB2.get(system);
      assertNotNull(ext2);
      assertNotSame(ext1, ext2);
      ExtensionId<MongoDBExtension> lookup = MongoDB2.lookup();
      MongoDBExtension ext3 = system.extension(lookup);
      assertNotNull(ext3);
      assertSame(ext2, ext3);
   }

   @Test
   public void testGetScalaExtension() throws Exception {
      Object meths = new Bar("jui").getClass().getSuperclass();
      System.out.println(meths);


   }

}
