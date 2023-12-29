package com.trustrace.assignment.scm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="login")
public class Login 
{
    @Id
    public String _id;

    @Field("username")
    public String username;
    
    @Field("password")
    public String password;
}
