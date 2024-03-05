package com.kafkaexample.service;

import com.kafkaexample.entity.KafkaMessage;
import com.kafkaexample.repository.KafkaMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private final KafkaMessageRepository kafkaMessageRepository;

    @Autowired
    public KafkaListeners(KafkaMessageRepository kafkaMessageRepository) {
        this.kafkaMessageRepository = kafkaMessageRepository;
    }

    @KafkaListener(
            topics = "kafka",
            groupId = "groupId"
    )
    void listener(String data) {

        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setMessage(data);
        kafkaMessageRepository.save(kafkaMessage);
    }
}
