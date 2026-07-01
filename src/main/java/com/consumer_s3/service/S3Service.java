package com.consumer_s3.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

  private final S3Client s3Client;

  public S3Service(S3Client s3Client) {
    this.s3Client = s3Client;
  }

  public void updload(String key, String content) {

    PutObjectRequest request =
      PutObjectRequest.builder()
        .bucket("bucket3")
        .key(key)
        .build();

    s3Client.putObject(request, RequestBody.fromString(content));
  }
}
