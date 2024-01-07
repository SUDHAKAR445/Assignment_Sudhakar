package com.userlogin.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_login")
public class UserLogin {

    @Id
    private Integer _id;

    @Field("user_name")
    private String userName;

    @Field("email")
    private String email;

    @Field("role")
    private String role;

    @Field("password")
    private String password;

}
