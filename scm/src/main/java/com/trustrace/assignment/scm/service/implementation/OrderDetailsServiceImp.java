package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.OrderDetails;
import com.trustrace.assignment.scm.repository.OrderDetailsRepository;
import com.trustrace.assignment.scm.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImp implements OrderDetailsService{
	@Autowired
	OrderDetailsRepository orderDetailsRepo;
	
	
	public OrderDetails getById(String id){
		return orderDetailsRepo.findById(id).get();
	}
	
	public String saveOrder(OrderDetails a) {
		orderDetailsRepo.save(a);
		return "Order saved Successfully id: "+a.get_id();
	}
	
	public void updateOrder(OrderDetails a) {
		orderDetailsRepo.save(a);
	}
	
	public void deleteOrder(String id) {
		orderDetailsRepo.deleteById(id);
	}
	
	@Override
	public List<OrderDetails> getAllOrder() {
		return orderDetailsRepo.findAll();
	}
	
}
