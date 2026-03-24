package com.starkIndustries.awsApplication.s3Bucket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.starkIndustries.awsApplication.exception.CustomException;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@Slf4j
public class S3Service {

    @Autowired
    public S3Client s3Client;

    @Value("${aws.s3.bucket-name}")
    public String bucketName;

    
    public Object uploadFile(MultipartFile multipartFile){

        if(multipartFile.getOriginalFilename()==null || multipartFile.getOriginalFilename().isEmpty() || multipartFile.getOriginalFilename().isBlank()){
            log.error("file name is null or empty");
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"file name is null or empty");
        }

        try{
            log.info("file uploaded sucessfully");
            return this.s3Client.putObject(
                PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(multipartFile.getOriginalFilename())
                    .build(),
                RequestBody.fromBytes(multipartFile.getBytes())
        );
        }catch(Exception e){
            log.error("failed to upload file");
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public byte[] downloadFile(String fileName){

        ResponseBytes<GetObjectResponse>  fileBytes = this.s3Client.getObjectAsBytes(
            GetObjectRequest.builder()
            .bucket(bucketName)
            .key(fileName)
            .build()
        );

        return fileBytes.asByteArray();

    }
    
}
