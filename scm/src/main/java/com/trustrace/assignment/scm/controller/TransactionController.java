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

import com.trustrace.assignment.scm.model.Transaction;
import com.trustrace.assignment.scm.service.TransactionService;

@RestController
//base url
@RequestMapping("/transaction/")
public class TransactionController {
     @Autowired
	TransactionService transactionService;
	
	@GetMapping("/getalltransaction")
	public ResponseEntity<List<Transaction>> readAllTransaction()
	{
		return new ResponseEntity<List<Transaction>>(transactionService.getAllTransaction(),HttpStatus.OK);
	}
	
	@GetMapping("/select/transactionbyid/{id}")
	public Transaction getById(@PathVariable("id") String id){
		return transactionService.getById(id);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createTransaction(@RequestBody Transaction a)
	{
		return new ResponseEntity<String>(transactionService.saveTransaction(a),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Transaction a) {
		transactionService.updateTransaction(a);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/delete/agencybyid/{id}")
	public String delete(@PathVariable("id") String id) {
		transactionService.deleteTransaction(id);
		return "Deleted Successfully";
	}
	
}
