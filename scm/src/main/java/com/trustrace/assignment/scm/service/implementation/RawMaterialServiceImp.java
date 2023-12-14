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
		if(rawMaterialRepo.existsById(a.get_id()))
		{
			return "RawMaterial id allready exists";
		}
		rawMaterialRepo.save(a);
		return "RawMaterial saved Successfully id: ";
	}
	
	public String updateRawMaterial(RawMaterial a) {
		if(!rawMaterialRepo.existsById(a.get_id()))
		{
			return "Rawmaterial id doesn't exists";
		}
		rawMaterialRepo.save(a);
		return "RawMaterial updated successfully";
	}
	
	public String deleteRawMaterial(String id) {
		if(!rawMaterialRepo.existsById(id))
		{
			return "RawMaterial id doesn't exists";
		}
		rawMaterialRepo.deleteById(id);
		return "RawMaterial deleted successfully";
	}
	
	@Override
	public List<RawMaterial> getAllRawMaterial() {
		return rawMaterialRepo.findAll();
	}
	
}
