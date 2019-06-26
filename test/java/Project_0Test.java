import static org.junit.Assert.*;
	
	import org.apache.log4j.Logger;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;

import com.revature.repository.BankCustomerDAOImplOJDBC;
	
	public class Project_0Test {
	
		private static Logger log = Logger.getLogger(Project_0Test.class);
		private static  BankCustomerDAOImplOJDBC bankCustomerDAO = new BankCustomerDAOImplOJDBC();
	
		//inside our test classes, we write methods.  We annotate those methods
		//based on when we want them to run and how we want them to run
	
		//in addition to Tests, we can write methods that assist setting up/
		// tearing down the infrastructure required for our tests.  In this case,
		// it's not necessary.
	
		@Test
		public void poorMan() {
			log.debug("test: withdraw can not be more then what is in account");
			// here we want to actually test our method
			// the assert will tell JUnit (and us) if it fails or passes
			assertFalse(BankCustomerDAOImplOJDBC.amount1 >  BankCustomerDAOImplOJDBC.BALANCE);
		}
		@Test
		public void richrMan() {
			log.debug("test: withdraw can be valid if money is in account");
			// here we want to actually test our method
			// the assert will tell JUnit (and us) if it fails or passes
			assertFalse(BankCustomerDAOImplOJDBC.amount1 <  BankCustomerDAOImplOJDBC.BALANCE);
		}
	
		@Test
		public void correctDeposit() {
			log.debug("test: if money is placed into a customers account the balance will increase by however much was placed.");
			assertEqual(  BankCustomerDAOImplOJDBC.BALANCE + 100, bankCustomerDAO.deposit(100));
		}
		

		private void assertEqual(int i, int deposit) {
			// TODO Auto-generated method stub
			
		}
	
	
	
	}