package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.dao.DaoService;
import com.trustrace.assignment.scm.model.Account;
import com.trustrace.assignment.scm.service.AccountService;
import com.trustrace.assignment.scm.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService{

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	DaoService dao;
	
//	public List<Account> getAllData(){
//		List<Account> list = new ArrayList<>();
//		list = accountRepo.findAll();
//		return list;
//	}
	
	public Account getById(String id){
		return accountRepo.findById(id).get();
	}
	
	public String saveAccount(Account a) {
		accountRepo.save(a);
		return "Account saved Successfully id: "+ a.get_id();
	}
	
	public void updateAccount(Account a) {
		accountRepo.save(a);
	}
	
	public void deleteAccount(String id) {
		accountRepo.deleteById(id);
	}
	
	public List<Account> getAllAccount() {
		return accountRepo.findAll();
	}

	public void updateAccountName(String id,String newName) {
		dao.updateAccountName(id, newName);
	}
//	public void accountNameChange(String oldName, String newName) {
//		dao.accountNameChange(oldName, newName);
//	}
//	@Override
//	public String saveProduct(Account account) {
//		accountRepo.save(account);
//		return "Account saved Successfully id: "+account.get_id();
//	}
//
	
//
//	@Override
//	public Account getAccountById(Long accountId) {
//		return accountRepo.findById(accountId).get();
//	}
//
//	@Override
//	public String deleteAccountById(Long accountId) {
//		
//		boolean delete=false;
//		if(accountRepo.existsById(accountId))
//		{
//			accountRepo.deleteById(accountId);
//			delete=true;
//		}
//		return "Deleted successfully"+delete;
//	}

}
