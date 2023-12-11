package com.trustrace.assignment.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustrace.assignment.scm.model.RawMaterial;
import com.trustrace.assignment.scm.service.RawMaterialService;

@RestController
//base url
@RequestMapping("/rawmaterial/")
public class RawMaterialController {
    @Autowired
	RawMaterialService rawMaterialService;
	
	@GetMapping("/getallrawmaterial")
	public ResponseEntity<List<RawMaterial>> readAllRawMaterial()
	{
		return new ResponseEntity<List<RawMaterial>>(rawMaterialService.getAllRawMaterial(),HttpStatus.OK);
	}
	
	@GetMapping("/select/rawMaterialbyid/{id}")
	public RawMaterial getById(@PathVariable("id") String id){
		return rawMaterialService.getById(id);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createRawMaterial(@RequestBody RawMaterial a)
	{
		return new ResponseEntity<String>(rawMaterialService.saveRawMaterial(a),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody RawMaterial a) {
		rawMaterialService.updateRawMaterial(a);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/delete/agencybyid/{id}")
	public String delete(@PathVariable("id") String id) {
		rawMaterialService.deleteRawMaterial(id);
		return "Deleted Successfully";
	}
	
}
