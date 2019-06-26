package com.revature.repository;


import java.util.List;

import com.revature.model.CustomerAccount;

public interface CustomerAccountDAO {
	
	default CustomerAccount getCustomerAccount1(int cust_id) {
		// TODO Auto-generated method stub
		return null;
	}
	


	 default CustomerAccount getCustomerAccount(int account_id) {
		// TODO Auto-generated method stub
		return null;
	}

	 default Object getCustomerAccounts() {
		// TODO Auto-generated method stub
		return null;
	}


}
