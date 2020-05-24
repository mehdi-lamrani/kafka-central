package com.sylace.org.kafka.client;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class HelloProducer {

    public static void run(String topicName) throws InterruptedException {

        // create instance for properties to access producer configs
        Properties props = new Properties();

        //@TODO : ASSIGN LOCALHOST ADDRESS AND KAFKA BROKER PORT
        //props.put("bootstrap.servers", " X  X  X  X  X  X  X  X ");

        //Set acknowledgements for producer requests.
        props.put("acks", "all");

        //If the request fails, the producer can automatically retry,
        props.put("retries", 0);

        //Specify buffer size in config
        props.put("batch.size", 16384);

        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);

        //@TODO : ASSIGN SERIALIZERS
        props.put("key.serializer", " X  X  X  X  X  X  X  X ");
        props.put("value.serializer", " X  X  X  X  X  X  X  X ");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        do {
            //@TODO : IMPLEMENT
            // Run a perpetual nested loop where you send batches of ProducerRecords, Calling producer.send()
            // Send strings as keys and values
            // Use Thread.sleep between each batch to space them;
            // You can improve the dirty "while true" by handling Ctrl-C Interruption Exception and hooking a Handler
        } while(true);

        //producer.close();
    }
}

