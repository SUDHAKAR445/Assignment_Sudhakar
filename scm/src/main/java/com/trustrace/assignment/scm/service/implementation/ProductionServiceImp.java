package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.Production;
import com.trustrace.assignment.scm.repository.ProductionRepository;
import com.trustrace.assignment.scm.service.ProductionService;

@Service
public class ProductionServiceImp implements ProductionService {
    @Autowired
	ProductionRepository productionRepo;
	
	
	public Production getById(String id){
		return productionRepo.findById(id).get();
	}
	
	public String saveProduction(Production a) {
		productionRepo.save(a);
		return "Production saved Successfully id: "+a.get_id();
	}
	
	public void updateProduction(Production a) {
		productionRepo.save(a);
	}
	
	public void deleteProduction(String id) {
		productionRepo.deleteById(id);
	}
	
	public List<Production> getAllProduction() {
		return productionRepo.findAll();
	}
}
