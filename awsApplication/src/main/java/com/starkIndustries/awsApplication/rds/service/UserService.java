package com.starkIndustries.awsApplication.rds.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.starkIndustries.awsApplication.exception.CustomException;
import com.starkIndustries.awsApplication.rds.dto.UserRequest;
import com.starkIndustries.awsApplication.rds.models.Users;
import com.starkIndustries.awsApplication.rds.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    // @Autowired
    // public UserRepository userRepository;

    // public Users insertUser(UserRequest userRequest){
    //     Users users = Users.builder()
    //         .userId(UUID.randomUUID().toString())
    //         .name(userRequest.name)
    //         .email(userRequest.email)
    //         .contact(userRequest.contact)
    //         .username(userRequest.username)
    //         .build();
    //     // return this.userRepository.save(users); 

    //     return null;
    // }

    // public Users getUser(String userId){
    // //     if(this.userRepository.existsById(userId))
    // //         return this.userRepository.findById(userId).get();
    // //     else{
    // //         log.error("No user with this user-Id");
    // //         throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"No user with this user-Id");
    // //     }

    // return null;
    // }

    
    
}
