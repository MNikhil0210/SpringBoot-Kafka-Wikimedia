package com.zemoso.springboot_kafka_wikimedia.repository;

import com.zemoso.springboot_kafka_wikimedia.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {
}
