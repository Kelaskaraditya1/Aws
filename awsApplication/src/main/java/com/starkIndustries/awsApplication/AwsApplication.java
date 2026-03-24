package com.starkIndustries.awsApplication;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AwsApplication {

	@Value("${spring.profiles.active}")
	String activeProfile;

	public static void main(String[] args) {
		SpringApplication.run(AwsApplication.class, args);
	}

	@GetMapping("/api/v1/health")
	public ResponseEntity<?> greetings(){

		Map<String,Object> response = new LinkedHashMap<>();

		response.put("status","up");
		response.put("health","healthy");
		response.put("active-profile",activeProfile );

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
