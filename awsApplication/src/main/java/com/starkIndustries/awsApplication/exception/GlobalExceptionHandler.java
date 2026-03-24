package com.starkIndustries.awsApplication.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.starkIndustries.awsApplication.keys.Keys;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<Map<String,Object>> globalExceptionHandler(CustomException customException){
        
        Map<String,Object> response = new LinkedHashMap<>();

        response.put(Keys.STATUS_CODE,customException.getHttpStatus().name());
        response.put(Keys.STATUS,customException.getHttpStatus().value());
        response.put(Keys.MESSAGE,customException.getMessage());

        return ResponseEntity.status(customException.getHttpStatus()).body(response);
    }
    
}
