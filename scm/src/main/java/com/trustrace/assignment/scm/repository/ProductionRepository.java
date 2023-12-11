package com.trustrace.assignment.scm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.trustrace.assignment.scm.model.Production;

public interface ProductionRepository extends MongoRepository<Production,String>{

}
