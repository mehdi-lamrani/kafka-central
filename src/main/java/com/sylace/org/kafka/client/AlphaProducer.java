package com.sylace.org.kafka.client;
//ALPHA KEY : 2DFF1F482N03K1BJ

import com.sylace.org.alpha.client.AlphaConnect;
import com.sylace.org.alpha.client.OhlcDTO;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;
import java.util.Properties;

public class AlphaProducer {

    public static void run(String topicName) throws Exception {

        Properties props = PropertyFactory.getProducerProps();

        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        do {
            System.out.println("TOPIC:"+topicName);
            List<OhlcDTO> listOHLC = AlphaConnect.getOHLC();
            for (OhlcDTO ohlc : listOHLC)
                producer.send(new ProducerRecord<String, String>(topicName,
                        ohlc.timestamp, ohlc.close));
            System.out.println("Message sent successfully to topic " + topicName);
            //Sleep 1 Minute
            Thread.sleep(60000);
        }while(true);

        //producer.close();
    }
}