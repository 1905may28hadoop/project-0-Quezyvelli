package com.revature.repository;

import java.util.List;

import com.revature.model.BankCustomers;

public interface BankCustomerDAO {

	
	default BankCustomers getBankCustomer(int cust_id) {
		// TODO Auto-generated method stub
		return null;
	}
	


	 default BankCustomers getBankCustomer1(int account_id) {
		// TODO Auto-generated method stub
		return null;
	}
}
