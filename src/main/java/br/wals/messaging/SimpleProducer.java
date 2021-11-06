package br.wals.messaging;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class SimpleProducer {

    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.out.println("Enter topic name as first argument");
            return;
        }

        String topicName = args[0];

        try (Producer<String, String> producer = new KafkaProducer<String, String>(getConfiguration())) {
            for (int i = 0; i < 100; i++) {
                System.out.printf("\nSend message %d to topic %s", i, topicName);
                producer.send(new ProducerRecord<>(topicName, "Event " + i, "Value " + i));
                Thread.sleep(1000);
            }
            System.out.println("Events send with sucess");
        }
    }

    private static Properties getConfiguration() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }
}
