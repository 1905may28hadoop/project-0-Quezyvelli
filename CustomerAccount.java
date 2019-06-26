package com.revature.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerAccount {

	private  int account_id;
	private String account_type;
	private int account_balance;
	private int cust_id;
	/**
	 * @param account_id
	 * @param account_type
	 * @param account_balance
	 * @param cust_id
	 */
	public CustomerAccount(int account_id, String account_type, int account_balance, int cust_id) {
		super();
		this.account_id = account_id;
		this.account_type = account_type;
		this.account_balance = account_balance;
		this.cust_id = cust_id;
	}
	public CustomerAccount(ResultSet resultSet) throws SQLException {
		this( resultSet.getInt("account_id"),
				resultSet.getString("account_type"),
				resultSet.getInt("account_balance"),
				resultSet.getInt("cust_id")
				);
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public int getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	@Override
	public String toString() {
		return "\n"+"BankCustomer ID: " + cust_id +"\n"+
				"Account ID: " + account_id +"\n"+ 
				"Type of Account: " + account_type 
				+ "Balance: $"+ account_balance+"\n";
	}
	
	
}
