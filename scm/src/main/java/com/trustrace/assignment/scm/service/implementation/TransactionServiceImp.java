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
		if(transactionRepo.existsById(a.get_id()))
		{
			return "Transaction id allready exists";
		}
		transactionRepo.save(a);
		return "Transcation saved Successfully id: ";
	}
	
	public String updateTransaction(Transaction a) {
		if(!transactionRepo.existsById(a.get_id()))
		{
			return "Transaction id doesn't exists";
		}
		transactionRepo.save(a);
		return "Transaction updated successfully";
	}
	
	public String deleteTransaction(String id) {
		if(!transactionRepo.existsById(id))
		{
			return "Transaction id doesn't exists";
		}
		transactionRepo.deleteById(id);
		return "Transaction deleted successfully";
	}
	
	@Override
	public List<Transaction> getAllTransaction() {
		return transactionRepo.findAll();
	}
	
}
