package com.starkIndustries.awsApplication.rds.models;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @Entity
// @Table(name = "Users")
public class Users {

    // @Id
    public String userId;
    public String name;
    public String contact;
    public String email;
    public String username;
        
}
