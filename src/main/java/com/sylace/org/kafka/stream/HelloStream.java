package com.sylace.org.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueStore;


import java.util.Arrays;
import java.util.Properties;

public class HelloStream {

    public static void run() throws Exception {
    Properties props = new Properties();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
    props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

    StreamsBuilder builder = new StreamsBuilder();


        // @TODO : IMPLEMENT

        //  1 - Define a KStream, representing textlines, that is returned from a builder.stream()
        //  from the TOPIC  TEXT-STREAM-INPUT

        //  2 - Define a KTable that is the result of a transformation of the Kstream
        //  You can use lambda, or plain old java
        //      a. flatMapValues to lover case
        //      b. groupBy word
        //      c. Materialize the count : count > Materialized as <String, Long, KeyValueStore<Bytes, byte[]>>as("counts-store")

        //  3 - Output your Defined KTable to an output stream
        //  yourKTable.toStream().to("TEXT-STREAM-OUTPUT", Produced.with(Serdes.String(), Serdes.Long()));

    KafkaStreams streams = new KafkaStreams(builder.build(), props);
    streams.start();
    }

}
