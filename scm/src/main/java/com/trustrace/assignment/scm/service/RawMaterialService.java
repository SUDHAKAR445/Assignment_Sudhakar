package com.trustrace.assignment.scm.service;

import java.util.List;

import com.trustrace.assignment.scm.model.RawMaterial;

public interface RawMaterialService 
{
    List<RawMaterial> getAllRawMaterial();
	
	RawMaterial getById(String _id);
	
	String saveRawMaterial(RawMaterial a);
	
	void updateRawMaterial(RawMaterial a);
	
	void deleteRawMaterial(String id);
}
