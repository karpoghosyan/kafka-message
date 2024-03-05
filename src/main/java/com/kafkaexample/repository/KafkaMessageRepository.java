package com.kafkaexample.repository;

import com.kafkaexample.entity.KafkaMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaMessageRepository extends JpaRepository<KafkaMessage,Long> {
}
