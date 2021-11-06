# Apache Kafka - Example

### Requirements

- Linux
- JDK 11
- Maven
- Docker

### Run
Open new terminal for each command and change to project directory

1. Run docker compose file:
```shell
docker-compose up
```

2. Run producer

```shell
sh producer.sh
```

3. Run consumer 1

```shell
sh consumer.sh 1
```

4. Run consumer 2

```shell
sh consumer.sh 2
```

### Others Informations

- Docker compose file: use version 2.1 or up for correct file interpretation
- Others configurations for producer/consumer in Confluent
- More detailed informations in TutorialsPoint

### References
[Digital Innovation One](https://digitalinnovation.one/)

[Bruno E. Grossi](https://github.com/begrossi/dio-kafka-example)

[TutorialsPoint](https://www.tutorialspoint.com/apache_kafka/apache_kafka_simple_producer_example.htm)

[Bitnami](https://github.com/bitnami/bitnami-docker-kafka/issues/68)

[Confluent - Producer Configurations](https://docs.confluent.io/platform/current/installation/configuration/producer-configs.html)

[Confluent - Consumer Configurations](https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html)



