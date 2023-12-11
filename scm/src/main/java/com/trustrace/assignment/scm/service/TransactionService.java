package com.trustrace.assignment.scm.service;

import java.util.List;

import com.trustrace.assignment.scm.model.Transaction;

public interface TransactionService {
    List<Transaction> getAllTransaction();
	
	Transaction getById(String _id);
	
	String saveTransaction(Transaction a);
	
	void updateTransaction(Transaction a);
	
	void deleteTransaction(String id);
}
