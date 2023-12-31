package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.dao.DaoService;
import com.trustrace.assignment.scm.exception.MyNotFoundException;
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
	
	// public Account getById(String id){
	// 	Account _id = accountRepo.findByBrandid(id);
	// 	return accountRepo.findById(_id.get_id()).get();

	// }
	 public Account getById(String accountId) {
        // Use repository to fetch account by ID
		Account _id = accountRepo.findByBrandid(accountId);
        return accountRepo.findById(_id.get_id())
                .orElseThrow(() -> new MyNotFoundException("Account not found for ID: " + accountId));
    }
	
	public String saveAccount(Account a) {
		Account id = accountRepo.findByBrandid(a.getBrandid());
		if(id==null)
		{
			accountRepo.save(a);
			return "Account saved successfully : "+a.get_id();
	    }
		else
		{
			return "Account already exists";
		}
	}
	
	public String updateAccount(Account a) {
		Account id = accountRepo.findByBrandid(a.getBrandid());
		if(id!=null)
		{
			accountRepo.save(a);
			return "Account updated successfully : "+id.get_id();
	    }
		else
		{
			return "Account doesn't exists";
		}
	}
	
	public String deleteAccount(String id) {
		Account _id = accountRepo.findByBrandid(id);
		if(_id!=null)
		{
			accountRepo.deleteById(_id.get_id());
			return "Account deleted successfully : "+_id.get_id();
	    }
		else
		{
			return "Account doesn't exists";
		}
	}
	
	public List<Account> getAllAccount() {
		return accountRepo.findAll();
	}

	public String updateAccountName(String id,String newName) 
	{
		Account _id = accountRepo.findByBrandid(id);
		//return "Account name changed successfully : "+_id.get_id();
		if(_id!=null)
		{
			dao.updateAccountName(_id.get_id(), newName);
			return "Account name changed successfully : "+_id.get_id();
	    }
		else
		{
			return "Account doesn't exists";
		}
	}
	// public void accountNameChange(String oldName, String newName) {
	// 	dao.accountNameChange(oldName, newName);
	// }

	
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
