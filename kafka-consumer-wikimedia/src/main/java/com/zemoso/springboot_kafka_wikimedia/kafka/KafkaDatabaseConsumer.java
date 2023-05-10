package com.zemoso.springboot_kafka_wikimedia.kafka;

import com.zemoso.springboot_kafka_wikimedia.entity.WikimediaData;
import com.zemoso.springboot_kafka_wikimedia.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaRepository wikimediaRepository;

    public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(topics = "Wikimedia_recent_change", groupId = "myKafkaGroup")
    public void consume(String eventMessage) {
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setEventData(eventMessage);

        wikimediaRepository.save(wikimediaData);
        LOGGER.info(String.format("Message received:- %s", eventMessage));
    }
}
