/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.acme;

import java.util.UUID;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.s3.AWS2S3Constants;

/**
 * Camel route definitions.
 */
public class Routes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:tick?period=3s")
            .setBody().constant("Do not laugh at Chuck Norris!")
            .log("${body}")
            ;
    }

/*
Step 1: random joke in JSON format
            .to("http:api.chucknorris.io/jokes/random?category=dev")
            .log("Joke from api.chucknorris.io: ${body}")
Step 2: parse JSON, extract the text of the joke
            .unmarshal().json()
            .setBody().simple("${body[value]}")
Step 3: forward to kafka
            .to("kafka:cnorris")

Step 4: Add a new route consuming messages from kafka
        from("kafka:cnorris")
            .log("Joke from kafka: ${body}")
            ;
Step 5: Store the messages in AWS S3
            .setHeader(AWS2S3Constants.KEY, () -> UUID.randomUUID())
            .to("aws2-s3:{{aws-s3.bucket-name}}")
*/
}
