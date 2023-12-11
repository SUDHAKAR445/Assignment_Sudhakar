package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.RawMaterial;
import com.trustrace.assignment.scm.repository.RawMaterialRepository;
import com.trustrace.assignment.scm.service.RawMaterialService;

@Service
public class RawMaterialServiceImp implements RawMaterialService{
    @Autowired
	RawMaterialRepository rawMaterialRepo;
	
	
	public RawMaterial getById(String id){
		return rawMaterialRepo.findById(id).get();
	}
	
	public String saveRawMaterial(RawMaterial a) {
		rawMaterialRepo.save(a);
		return "Transaction saved Successfully id: ";
	}
	
	public void updateRawMaterial(RawMaterial a) {
		rawMaterialRepo.save(a);
	}
	
	public void deleteRawMaterial(String id) {
		rawMaterialRepo.deleteById(id);
	}
	
	@Override
	public List<RawMaterial> getAllRawMaterial() {
		return rawMaterialRepo.findAll();
	}
	
}
