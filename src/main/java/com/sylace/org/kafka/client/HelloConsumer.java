package com.sylace.org.kafka.client;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class HelloConsumer {

    public static void run(String topicName){


        Properties props = new Properties();

        //@TODO : ASSIGN LOCALHOST ADDRESS AND KAFKA BROKER PORT
        props.put("bootstrap.servers", " X  X  X  X  X  X  X  X ");

        props.put("group.id", "GROUP-"+topicName);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");

        //@TODO : ASSIGN DE-SERIALIZERS
        props.put("key.deserializer", " X  X  X  X  X  X  X  X ");
        props.put("value.deserializer", " X  X  X  X  X  X  X  X ");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        //Kafka Consumer subscribes list of topics here.
        consumer.subscribe(Arrays.asList(topicName));
        //print the topic name
        System.out.println("Subscribed to topic " + topicName);

        //REMINDER : The console consumer has the default option of looking at the latest offset for all partitions
        while (true) {
            //@TODO : IMPLEMENT
            // SAME LOGIC AS PRECEDENT EXERCISE : Polling from Consumer and displaying records
        }
    }
}