package br.wals.messaging;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class SimpleConsumer {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Inform arguments of \"topic\" and \"group\"");
            return;
        }

        String topicName = args[0];
        String group = args[1];

        try (Consumer<String, String> consumer = new KafkaConsumer<String, String>(getConfiguration(group))) {
            consumer.subscribe(Collections.singletonList(topicName));
            System.out.println("Subscribed to the topic " + topicName);

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                if (!records.isEmpty()) {
                    for (ConsumerRecord record : records) {
                        System.out.printf("\nOffset: %d, key: %s, value: %s", record.offset(), record.key(), record.value());
                    }
                }
            }
        }

    }

    private static Properties getConfiguration(String group) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }
}
