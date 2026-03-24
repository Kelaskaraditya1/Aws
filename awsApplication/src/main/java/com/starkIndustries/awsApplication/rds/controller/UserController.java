package com.starkIndustries.awsApplication.rds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starkIndustries.awsApplication.rds.dto.UserRequest;
import com.starkIndustries.awsApplication.rds.models.Users;
import com.starkIndustries.awsApplication.rds.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    // @Autowired
    // public UserService userService;

    // @PostMapping("/insert")
    // public ResponseEntity<?> insertUser(@RequestBody UserRequest userRequest){

    //     if(userRequest==null)
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter proper request body");

    //     Users users = this.userService.insertUser(userRequest);
    //     return ResponseEntity.status(HttpStatus.OK).body(users);

    // }

    // @GetMapping("/{userId}")
    // public ResponseEntity<?> getUser(@PathVariable("userId") String userId){

    //     if(userId==null || userId.isEmpty() || userId.isBlank())
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter proper user-Id");

    //     return ResponseEntity.status(HttpStatus.OK).body(this.userService.getUser(userId));

    // }
    
}
