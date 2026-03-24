package com.starkIndustries.awsApplication.exception;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{

    private HttpStatus httpStatus;
    private String message;
    private Long timeStamp = System.currentTimeMillis();

    

    public CustomException(HttpStatus httpStatus, String message){
        super(message);
        this.message=message;
        this.httpStatus=httpStatus;
    }
    
}
