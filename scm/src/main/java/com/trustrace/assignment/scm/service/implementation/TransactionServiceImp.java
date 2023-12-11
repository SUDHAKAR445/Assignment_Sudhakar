package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.Transaction;
import com.trustrace.assignment.scm.repository.TransactionRepository;
import com.trustrace.assignment.scm.service.TransactionService;

@Service
public class TransactionServiceImp implements TransactionService
{
    @Autowired
	TransactionRepository transactionRepo;
	
	
	public Transaction getById(String id){
		return transactionRepo.findById(id).get();
	}
	
	public String saveTransaction(Transaction a) {
		transactionRepo.save(a);
		return "Transcation saved Successfully id: ";
	}
	
	public void updateTransaction(Transaction a) {
		transactionRepo.save(a);
	}
	
	public void deleteTransaction(String id) {
		transactionRepo.deleteById(id);
	}
	
	@Override
	public List<Transaction> getAllTransaction() {
		return transactionRepo.findAll();
	}
	
}
