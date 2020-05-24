package com.sylace.org.kafka.client;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class AlphaConsumer {

    public static void run(String topicName){

        //@TODO-IMPLEMENT
        //define getConsumerProps in PropertyFactory
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
            // @TODO-IMPLEMENT

            // use consumer.poll to retrieve records

            //print count
            // System.out.println("Records No : " + records.count());

            // @TODO-IMPLEMENT

            // iterate over records
            // for each consumer record, print :
            // record.offset(), record.key(), and record.value()

            //for (ConsumerRecord<String, String> record : records) {
                //
            //}
        }
    }
}