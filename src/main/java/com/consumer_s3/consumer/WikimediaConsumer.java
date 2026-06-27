package com.consumer_s3.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WikimediaConsumer {

  @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
  public void consumerMessage(String message) {

    log.info(String.format("Wikimedia consumer receive message: %s", message));
  }
}
