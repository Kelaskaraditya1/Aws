package com.starkIndustries.awsApplication.rds.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    public String name;
    public String contact;
    public String email;
    public String username;

    
}
