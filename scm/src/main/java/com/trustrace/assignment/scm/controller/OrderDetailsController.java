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

import com.trustrace.assignment.scm.model.OrderDetails;
import com.trustrace.assignment.scm.service.OrderDetailsService;

@RestController
//base url
@RequestMapping("/orderdetails")
public class OrderDetailsController {
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@GetMapping("/getallorder")
	public ResponseEntity<List<OrderDetails>> readAllOrder()
	{
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.getAllOrder(),HttpStatus.OK);
	}
	
	@GetMapping("/select/orderbyid/{id}")
	public OrderDetails getById(@PathVariable("id") String id){
		return orderDetailsService.getById(id);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createAccount(@RequestBody OrderDetails a)
	{
		return new ResponseEntity<String>(orderDetailsService.saveOrder(a),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody OrderDetails a) {
		orderDetailsService.updateOrder(a);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/delete/orderbyid/{id}")
	public String delete(@PathVariable("id") String id) {
		orderDetailsService.deleteOrder(id);
		return "Deleted Successfully";
	}
	
}
