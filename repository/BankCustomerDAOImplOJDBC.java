package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.exception.CloseStreams;
import com.revature.model.BankCustomers;
import com.revature.model.CustomerAccount;
import com.revature.controller.ConnectionUtil;

public class BankCustomerDAOImplOJDBC implements BankCustomerDAO{
	
public static int BALANCE;
public static int amount1;


	public BankCustomers getBankCustomer1(int account_id) {
		
		PreparedStatement statement = null;
		ResultSet resultSet =  null;
		BankCustomers BankCustomer = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			try {
			statement = conn.prepareStatement("SELECT * FROM bank_customers WHERE account_id = ?");
			statement.setInt(1,account_id);
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next(); // goes to the first result
			BankCustomer = new BankCustomers(resultSet.getInt("cust_id"),
					resultSet.getString("cust_name"),
					resultSet.getString("birth_date"),
					resultSet.getString("mobile_no"), 
					resultSet.getInt("account_id"));}
			catch(SQLException e) {
				 System.err.println("Wrong Customer Login");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}
		return BankCustomer;
	}

	public BankCustomers getBankCustomer(int cust_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void AppWindow(int userLogin) throws SQLException  {
		// TODO Auto-generated method stub
		CustomerAccountDAOImplOJDBC customerAccountDAO = new CustomerAccountDAOImplOJDBC();
		BALANCE = customerAccountDAO.getCustomerAccount2(userLogin);
			char option = '\0';
			Scanner scanner = new Scanner(System.in);
			
			
			System.out.println(customerAccountDAO.getCustomerAccount1(userLogin));
			System.out.println("\n");
			System.out.println("A. Total Balance");
			System.out.println("B. Make a Deposit");
			System.out.println("C. Make a Withdraw");
			System.out.println("D. Exit");
			
			do {
				System.out.println("========= Revature ============");
				System.out.println("Enter a number for command");
				System.out.println("========= Revature ============");
				option = scanner.next().charAt(0);
				System.out.println("\n");
				
				switch(option) {
				case 'A':
					System.out.println("========= Revature ============");
					System.out.println("Balance = $" + BALANCE);
					System.out.println("========= Revature ============");
					System.out.println("\n");
					break;
					
				case 'B':
					System.out.println("========= Revature ============");
					System.out.println("Waiting on Deposit:");
					System.out.println("========= Revature ============");
					int amount = scanner.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;
					
				case 'C':
					System.out.println("========= Revature ============");
					System.out.println("Waiting on Withdraw:");
					System.out.println("========= Revature ============");
					int amount1 = scanner.nextInt();
					withdraw(amount1); 
					System.out.println("\n");
					break;
					
				default:
					System.out.println("========= Revature ============");
					System.out.println("NOT A MONEY TRANCATION");
					System.out.println("========= Revature ============");
				}
			}while( option != 'D');
			System.out.println("========= Revature ============");
			System.out.println("Thank You. Trancation Menu Closed");
			System.out.println("========= Revature ============");
	
	if(option == 'D') {
		PreparedStatement  statement = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			statement = conn.prepareStatement("UPDATE customer_account SET account_balance = ? WHERE account_id = ?");
			statement.setInt(1, BALANCE);
			statement.setInt(2,userLogin);
			statement.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		CloseStreams.close(statement);
	}
	
	}
	}

	public int withdraw( int amount1) {
		this.amount1 = amount1;
		// TODO Auto-generated method stub
		try{
			if(amount1 !=0 && BALANCE >= amount1) {
			BALANCE = BALANCE - amount1;}
		}catch(Exception e) {
			System.err.println("YOUR MONEY IS LIMITED");
		}
		return BALANCE;
	}

	public int deposit(int amount) {
		// TODO Auto-generated method stub
		if(amount > 0) {
			BALANCE = BALANCE + amount;
		}
		return BALANCE;
	}
}
