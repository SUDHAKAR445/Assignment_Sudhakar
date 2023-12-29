package com.trustrace.assignment.scm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trustrace.assignment.scm.model.Login;
@Repository
public interface LoginRepository extends MongoRepository<Login, String>{

}