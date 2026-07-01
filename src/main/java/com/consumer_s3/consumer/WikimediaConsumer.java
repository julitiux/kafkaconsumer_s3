package com.consumer_s3.consumer;

import com.consumer_s3.service.S3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service
public class WikimediaConsumer {

  private final S3Service s3Service;

  public WikimediaConsumer(S3Service s3Service) {
    this.s3Service = s3Service;
  }

  @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
  public void consumerMessage(String message) {

    log.info(format("Wikimedia consumer receive message: %s", message));

    String filename =
      "events/" +
        System.currentTimeMillis() +
        ".json";

    s3Service.updload(filename, message);
  }
}
