package com.sylace.org.kafka.client;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class AlphaConsumer {

    public static void run(String topicName){


        Properties props = PropertyFactory.getConsumerProps();
        props.put("group.id", "GROUP-"+topicName);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        //Kafka Consumer subscribes list of topics here.
        consumer.subscribe(Arrays.asList(topicName));
        //print the topic name
        System.out.println("Subscribed to topic " + topicName);

        //REMINDER : The console consumer has the default option of looking at the latest offset for all partitions
        while (true) {
            System.out.println("Polling...");
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));
            System.out.println("Records No : " + records.count());
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Iterating...");
                // print the offset,key and value for the consumer records.
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
            }
        }
    }
}