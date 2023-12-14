package com.trustrace.assignment.scm.service;

import java.util.List;

import com.trustrace.assignment.scm.model.Production;

public interface ProductionService {
    List<Production> getAllProduction();
	
	Production getById(String _id);
	
	String saveProduction(Production a);
	
	String updateProduction(Production a);
	
	String deleteProduction(String id);
}
