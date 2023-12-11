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

import com.trustrace.assignment.scm.model.Production;
import com.trustrace.assignment.scm.service.ProductionService;

@RestController
//base url
@RequestMapping("/production/")
public class ProductionController {
     @Autowired
	ProductionService productionService;
	
	@GetMapping("/getallproduction")
	public ResponseEntity<List<Production>> readAllProduction()
	{
		return new ResponseEntity<List<Production>>(productionService.getAllProduction(),HttpStatus.OK);
	}
	
	@GetMapping("/select/productionbyid/{id}")
	public Production getById(@PathVariable("id") String id){
		return productionService.getById(id);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createProduction(@RequestBody Production a)
	{
		return new ResponseEntity<String>(productionService.saveProduction(a),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Production a) {
		productionService.updateProduction(a);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/delete/productionbyid/{id}")
	public String delete(@PathVariable("id") String id) {
		productionService.deleteProduction(id);
		return "Deleted Successfully";
	}
	
}
