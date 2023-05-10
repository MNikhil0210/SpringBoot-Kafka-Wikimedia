# SpringBoot-Kafka-Wikimedia
Spring Boot and Kafka integration using micro-services to read and store real-time stream data into PostgreSQL DB.

## Running micro-services
### Wikimedia Producer service
To start the producer service, Go to `kafka-producer-wikimedia` module and start the spring service from SpringBootProducerApplication.java.
This producer service will collect real-time stream data from the given source [URL](https://stream.wikimedia.org/v2/stream/recentchange) and publish the message to kafka topic.

### Wikimedia Consumer service
To start the consumer service, Go to `kafka-consumer-wikimedia` module and start the spring service from SpringBootConsumerApplication.java.
This consumer service will collect stream data from kafka topic which is been produced by producer service and manipulates the data and stores it into the DB.
