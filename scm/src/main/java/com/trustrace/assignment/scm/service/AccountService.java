package com.trustrace.assignment.scm.service;

import java.util.List;

import com.trustrace.assignment.scm.model.Account;


public interface AccountService 
{
//	String saveProduct(Account account);
//	
//	List<Account> getAllAccount();
//	
//	Account getAccountById(Long accountId);
//	
//	String deleteAccountById(Long accountId);
	
	List<Account> getAllAccount();
	
	Account getById(String _id);
	
	String saveAccount(Account a);
	
	void updateAccount(Account a);
	
	void deleteAccount(String id);

    void updateAccountName(String id, String newName);
	
	//void accountNameChange(String oldName, String newName);
}
