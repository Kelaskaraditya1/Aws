package com.starkIndustries.awsApplication.s3Bucket.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3ClientConfiguration {

    @Value("${aws.s3.region}")
    public String region;

    @Bean("S3Client")
    @Profile("development")
    public S3Client getS3Client(
            @Value("${aws.s3.access-key}")String accessKey,
            @Value("${aws.s3.secret-key}")String secretKey
    ){

        return S3Client.builder()
            .region(Region.of(region))
            .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey,secretKey)))
            .build();
    }

    @Bean("S3Client")
    @Profile("production")
    public S3Client getProductionS3Client(){

        return S3Client.builder()
            .region(Region.of(region))
            .credentialsProvider(DefaultCredentialsProvider.create())
            .build();
    }

    
}
