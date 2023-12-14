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
		if(orderDetailsRepo.existsById(a.get_id()))
		{
			return "Order id allready exists";
		}
		orderDetailsRepo.save(a);
		return "Order saved Successfully id: "+a.get_id();
	}
	
	public String updateOrder(OrderDetails a) {
		if(!orderDetailsRepo.existsById(a.get_id()))
		{
			return "Order id doesn't exists";
		}
		orderDetailsRepo.save(a);
		return "Order updated successfully";
	}
	
	public String deleteOrder(String id) {
		if(!orderDetailsRepo.existsById(id))
		{
			return "Order id doesn't exists";
		}
		orderDetailsRepo.deleteById(id);
		return "Order deleted successfully";
	}
	
	@Override
	public List<OrderDetails> getAllOrder() {
		return orderDetailsRepo.findAll();
	}
	
}
