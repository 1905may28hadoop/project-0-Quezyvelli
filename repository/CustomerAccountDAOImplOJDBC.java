package com.revature.repository;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.revature.exception.CloseStreams;
import com.revature.model.CustomerAccount;
import com.revature.controller.ConnectionUtil;

public class CustomerAccountDAOImplOJDBC implements CustomerAccountDAO{
	static int money;
		public
		CustomerAccount getCustomerAccount1(int account_id) {
			
			PreparedStatement statement = null;
			ResultSet resultSet =  null;
			CustomerAccount CustomerAccounts = null;
			
			try(Connection conn = ConnectionUtil.getConnection()) {
				
				//SQL injection:
				//String dangerousInput = typename + ";DROP TABLE pet_types;";
				//String sqlStatement = "SELECT * FROM pet_types WHERE typename = " + dangerousInput;
				try {
				statement = conn.prepareStatement("SELECT * FROM customer_account WHERE account_id = ?");
				statement.setInt(1,account_id);
				statement.execute();
				resultSet = statement.getResultSet();
				resultSet.next(); // goes to the first result
				CustomerAccounts = new CustomerAccount( resultSet.getInt("account_id"),
						resultSet.getString("account_type"),
						resultSet.getInt("account_balance"),
						resultSet.getInt("cust_id")
						);
				money = resultSet.getInt("account_balance");
				 }catch(SQLException e) {
					 System.err.println("Wrong Customer Login");
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				CloseStreams.close(statement);
				CloseStreams.close(resultSet);
			}
			return CustomerAccounts;
		}

		public CustomerAccount getCustomerAccount(int cust_id) {
			// TODO Auto-generated method stub
			return null;
		}

		public int getCustomerAccount2(int account_id) {
			
			PreparedStatement statement = null;
			ResultSet resultSet =  null;
			CustomerAccount CustomerAccounts = null;
			
			try(Connection conn = ConnectionUtil.getConnection()) {
				
				//SQL injection:
				//String dangerousInput = typename + ";DROP TABLE pet_types;";
				//String sqlStatement = "SELECT * FROM pet_types WHERE typename = " + dangerousInput;
				try {
				statement = conn.prepareStatement("SELECT * FROM customer_account WHERE account_id = ?");
				statement.setInt(1,account_id);
				statement.execute();
				resultSet = statement.getResultSet();
				resultSet.next(); // goes to the first result
				CustomerAccounts = new CustomerAccount( resultSet.getInt("account_id"),
						resultSet.getString("account_type"),
						resultSet.getInt("account_balance"),
						resultSet.getInt("cust_id")
						);
				money = CustomerAccounts.getAccount_balance();
			 }catch(SQLException e) {
				 System.err.println("Wrong Customer Login");
			 }
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				CloseStreams.close(statement);
				CloseStreams.close(resultSet);
			}
			return money;
		}
		
}
