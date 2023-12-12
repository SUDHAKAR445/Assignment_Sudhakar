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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustrace.assignment.scm.model.Account;
import com.trustrace.assignment.scm.service.AccountService;

@RestController
//base url
@RequestMapping("/account")
public class AccountController 
{
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "hello";
	}
	
	
	@GetMapping("/getallaccount")
	public ResponseEntity<List<Account>> readAllAccount()
	{
		return new ResponseEntity<List<Account>>(accountService.getAllAccount(),HttpStatus.OK);
	}
	
	@GetMapping("/select/accountbyid/{id}")
	public Account getById(@PathVariable("id") String id){
		return accountService.getById(id);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createAccount(@RequestBody Account account)
	{
		return new ResponseEntity<String>(accountService.saveAccount(account),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Account a) {
		accountService.updateAccount(a);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/delete/accountbyid/{id}")
	public String delete(@PathVariable("id") String id) {
		accountService.deleteAccount(id);
		return "Deleted Successfully";
	}

	@PutMapping("/update/account-name")
	public String updateName(@RequestParam String id, @RequestParam String newName) {
		accountService.updateAccountName(id,newName);
		return "Updated Name Successfully";
	}
	
//	@PutMapping("/update/account-name")
//	public String updateName(String oldName , String newName) {
//		accountService.accountNameChange(oldName,newName);
//		return "Updated Successfully";
//	}
//	@Autowired
//	AccountService accountService;
//	
//	@PostMapping("/save")
//	public ResponseEntity<String> createAccount(@RequestBody Account account)
//	{
//		return new ResponseEntity<String>(accountService.saveProduct(account),HttpStatus.OK);
//	}
//	
//	@GetMapping("/getallaccount")
//	public ResponseEntity<List<Account>> readAllAccount()
//	{
//		return new ResponseEntity<List<Account>>(accountService.getAllAccount(),HttpStatus.OK);
//	}
//	
	
}
