package com.banking.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.SpecialOneToOneType;

import com.banking.config.HibernateUtil;
import com.banking.dao.BankDao;
import com.banking.entity.Account;
import com.banking.entity.Bank;
import com.banking.entity.Customer;


public class BankDaoImpl implements BankDao
{

	Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction t = session.beginTransaction();
    
    //   CREATED Scanner CLASS OBJECT scannerobj 
    Scanner scannerobj = new Scanner(System.in);
    Bank bankObj = new Bank();
    Customer customerobj = new Customer();
    Account accountObj = new Account();
	@Override
	public boolean bankLogIn() 
    {
    	System.out.println("<------------------BANK LOG IN------------------>");
    	String bbc,bpw;
    	System.out.println("PLEASE ENTER BANK BRANCH CODE-------->");
    	bbc = scannerobj.next();
    	
    	System.out.println("PLEASE ENTER BANK PASSWORD-------->");
    	bpw = scannerobj.next();
    	
    	
		return ((bbc != bankObj.getBankBranchCode()) && (bpw != bankObj.getBankPassword()));
			
    	
	}
	@Override
	public void changeBankPassword() 
	{
		
		System.out.println("<------------------BANK LOG IN PASSWORD CHANGE------------------>");
		System.out.println("YOU CAN ONLY CHANGE PASSWORD ONLY IF YOU REMEMBER LAST PASSWORD\nPLEASE ENTER YOUR OND PASSWORD-------->");
		String op;
		op = scannerobj.next();
		while (op == bankObj.getBankPassword()) 
		{
			
			String newp,confp;
			System.out.println("PLEASE ENTER NEW PASSWORD-------->");
			newp = scannerobj.next();
			
			System.out.println("PLEASE RE-ENTER NEW PASSWORD-------->");
			confp = scannerobj.next();
			
			if (newp == confp) 
			{
				
				bankObj.setBankPassword(newp);
				session.update(bankObj);
				t.commit();
				
				System.out.println("PASSWORD CHANGED SUCCESSFULLY...");
				
			} else 
			{
				
				System.out.println("PASSWORDS DID NOT MATCH, TRY AGAIN...");

			}
			
		}
		
	}
	@Override
	public void createAccount() 
	{
		
		//   CREATED Bank CLASS OBJECT bankObj 
		//Bank bankObj = new Bank();
		
		//   SETTING DETAILS OF Bank CLASS USING SETTER 
		bankObj.setBankId(1997);
		bankObj.setBankName("DAKU BANK");
		bankObj.setBankBranchName("SAORA BRANCH");
		bankObj.setBankBranchCode("SAORA0602");
		bankObj.setBankPassword("SAORADBPASS");
		bankObj.setBankIfcNo("DAB4475");
		bankObj.setBankManagerName("ALOKE MANDI");
		bankObj.setBankAddress("SAORA,HOOGHLY");
		bankObj.setBankEmail("saorabranch@dakubank.com");
		bankObj.setBankHelplinetNo(72452811);
		
		
		
		String cfn,cln,ipn,cit,ca,cdob,ce;
		long ccn;
	
		System.out.println("<------------------PLEASE ENTER CUSTOMER DETAILS------------------>");
		System.out.println("PLEASE ENTER CUSTOMER'S FIRST NAME-------->");
		cfn = scannerobj.next();
		
		System.out.println("PLEASE ENTER CUSTOMER'S LAST NAME-------->");
		cln = scannerobj.next();
		
		System.out.println("PLEASE ENTER CUSTOMER'S ID PROOF NO-------->");
		ipn = scannerobj.next();
		
		System.out.println("PLEASE ENTER CUSTOMER'S ID TYPE-------->");
		cit = scannerobj.next();
		
		System.out.println("PLEASE ENTER CUSTOMER'S ADDRESS-------->");
		ca = scannerobj.next();
		
		System.out.println("PLEASE ENTER CUSTOMER'S DATE OF BIRTH-------->");
	    cdob = scannerobj.next();
	    
		System.out.println("PLEASE ENTER CUSTOMER'S EMAIL ID-------->");
		ce = scannerobj.next();
		
		System.out.println("PLEASE ENTER CUSTOMER'S CONTACT NUMBER-------->");
		ccn = scannerobj.nextLong();
		
		customerobj.setCustomerFirstName(cfn);
		customerobj.setCustomerLastName(cln);
		customerobj.setCustomerIdProofNo(ipn);
		customerobj.setCustomerIdType(cit);
		customerobj.setCustomerAddress(ca);
		customerobj.setCustomerDob(cdob);
		customerobj.setCustomerEmwail(ce);
		customerobj.setCustomerContactNo(ccn);
		
		
		List<Customer> customerListObj = new ArrayList<>();
		customerListObj.add(customerobj);
		bankObj.setCustomers(customerListObj);
		
		//Account accountObj = new Account();
		
		long an;
		String ap,at;
		boolean iaa;
		double ab,wb,db;
		
		System.out.println("<------------------PLEASE ENTER ACCOUNT DETAILS------------------>");
		System.out.println("PLEASE ENTER ACCOUNT NUMBER-------->");
		an = scannerobj.nextLong();
		
		System.out.println("PLEASE ENTER ACCOUNT PASSWORD-------->");
		ap = scannerobj.next();
				
		System.out.println("PLEASE ENTER ACCOUNT TYPE-------->");
		at = scannerobj.next();
		
		System.out.println("PLEASE ENTER ACCOUNT STATUS-------->");
		iaa = scannerobj.nextBoolean();
		
		System.out.println("PLEASE ENTER ACCOUNT BALANCE-------->");
		ab = scannerobj.nextDouble();
		
		System.out.println("PLEASE ENTER THE AMOUNT TO WIDRAW-------->");
		wb = scannerobj.nextDouble();
		
		System.out.println("PLEASE ENTER THE AMOUNT TO DEPOSITE-------->");
		db = scannerobj.nextDouble();
		
		accountObj.setAccountNo(an);
		accountObj.setAccountPassword(ap);
		accountObj.setAccountType(at);
		accountObj.isAccountActivStatus();
		accountObj.setAccountBalance(ab);
		
		List<Account> accountListObj = new ArrayList<>();
		accountListObj.add(accountObj);
		customerobj.setAccounts(accountListObj);
		
		session.save(bankObj);
		t.commit();

	}
	@Override
	public void updateCudtomertDetails() 
	{
		
		System.out.println("<------------------UPDATE CUSTOMER DETAILS------------------>");
		
		
	}
	@Override
	public void fetchAllCusttomerDetails() 
	{
		
		System.out.println("<------------------CUSTOMER FULL DETAILS------------------>");
		
		
	}
	@Override
	public void deleteCustomerDetails() 
	{
		
		System.out.println("<------------------DELETE CUSTOMER------------------>");
		System.out.println("ENTER ID-------->");
		int idc = scannerobj.nextInt();
		customerobj = session.get(Customer.class, idc);
		session.delete(customerobj);
		t.commit();
		System.out.println("DELETED SUCCESSFULLY...");
		
	}
	@Override
	public boolean customerLogIn() 
	{
		
		System.out.println("<------------------BANK LOG IN------------------>");
		long acn;
		String apw;
		System.out.println("PLEASE ENTER ACCOUT NUMBER-------->");
		acn = scannerobj.nextLong();
		
		System.out.println("PLEASE ENTER ACCOUT NUMBER-------->");
		apw = scannerobj.next();
		
		return ((acn != accountObj.getAccountNo()) && (apw != accountObj.getAccountPassword()));
	
	}
	@Override
	public void changeCustomerPassword() 
	{
		
		System.out.println("<------------------CUSTOMER LOG IN PASSWORD CHANGE------------------>");
		System.out.println("YOU CAN ONLY CHANGE PASSWORD ONLY IF YOU REMEMBER LAST PASSWORD\nPLEASE ENTER YOUR OND PASSWORD-------->");
		String op;
		op1 = scannerobj.next();
		
		while (op1 == accountObj.getAccountPassword()) 
		{
			
			String newp1,confp1;
			System.out.println("PLEASE ENTER NEW PASSWORD-------->");
			newp1 = scannerobj.next();
			
			System.out.println("PLEASE RE-ENTER NEW PASSWORD-------->");
			confp1 = scannerobj.next();
			
			if (newp1 == confp1) 
			{
				
				accountObj.setAccountPassword(newp1);
				session.update(accountObj);
				t.commit();
				
				System.out.println("PASSWORD CHANGED SUCCESSFULLY...");
				
			} else 
			{
				
				System.out.println("PASSWORDS DID NOT MATCH, TRY AGAIN...");

			}
			
		}
		
	}
	@Override
	public void widrawMoney() 
	{
		
		System.out.println("<------------------WIDRAW MONEY------------------>");
		double wm,apty;
		System.out.println("PLEASE ENTER THE AMMOUNT-------->");
		wm = scannerobj.nextDouble();
		accountObj.setWidrawnAmmount(wm);
		
		if (accountObj.isAccountActivStatus() == false) 
		{
			
			System.out.println("YOU SHOULD HAVE A ACTIVE ACCOUNT TO CONTINUE.. \nFOR HELP CONTACT YOUE NEAREST BEANCH.....");
		
		}
		else 
		{
			
			if (accountObj.getWidrawnAmmount() > accountObj.getAccountBalance()) 
			{
				
				System.out.println("WR ARE REALLY SORRY..., YOU DON'T HAVE SUFICIENT BALANCE IN YOUR ACCOUBT");
				
			} else 
			{
				
				apty = accountObj.getAccountBalance() - accountObj.getWidrawnAmmount();
				accountObj.setAccountBalance(apty);
				session.update(accountObj);
				t.commit();
				
				System.out.println("SUCCCESSFULLY DEBITED-------->");

			}
			
		}
		
	}
	@Override
	public void depositMoney() 
	{
		
		System.out.println("<------------------DEPOSITE MONEY------------------>");
		double dm,apty2;
		System.out.println("PLEASE ENTER THE AMMOUNT-------->");
		dm = scannerobj.nextDouble();
		
		accountObj.setDepositedAmount(dm);
		
		while (accountObj.isAccountActivStatus() != false) 
		{
			
			apty2 = accountObj.getAccountBalance() + accountObj.getDepositedAmount();
			accountObj.setAccountBalance(apty2);
			
			session.update(accountObj);
			t.commit();
			
			System.out.println("SUCCESSFULLY CREDITED....");
			
		}
		
		
	}
	@Override
	public void checkAccount() 
	{
		
		System.out.println("<------------------ACCOUNT INFO------------------>");
		
	}
	
	
		

}
