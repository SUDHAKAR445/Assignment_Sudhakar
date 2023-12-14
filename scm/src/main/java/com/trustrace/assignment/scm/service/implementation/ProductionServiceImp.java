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
		if(productionRepo.existsById(a.get_id()))
		{
			return "Production id allready exists";
		}
		productionRepo.save(a);
		return "Production saved Successfully id: "+a.get_id();
	}
	
	public String updateProduction(Production a) {
		if(!productionRepo.existsById(a.get_id()))
		{
			return "Production id doesn't exists";
		}
		productionRepo.save(a);
		return "Production updated successfully";
	}
	
	public String deleteProduction(String id) {
		if(!productionRepo.existsById(id))
		{
			return "Production id doesn't exists";
		}
		productionRepo.deleteById(id);
		return "Production deleted successfully";
	}
	
	public List<Production> getAllProduction() {
		return productionRepo.findAll();
	}
}
