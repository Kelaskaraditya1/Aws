package com.starkIndustries.awsApplication.s3Bucket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.starkIndustries.awsApplication.s3Bucket.service.S3Service;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class S3Controller {

    @Autowired
    public S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
        @RequestParam("file") MultipartFile multipartFile
    ){

        if(multipartFile==null || multipartFile.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("upload proper file");

        log.info("file name:{}",multipartFile.getOriginalFilename());
        var response = this.s3Service.uploadFile(multipartFile);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }

    @PostMapping("/download/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName){

        if(fileName==null || fileName.isEmpty() || fileName.isBlank())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter proper file name");

        log.info("file name:{}",fileName);
        var response = this.s3Service.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }
    
}
