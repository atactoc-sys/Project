package com.banking.dao;

public interface BankDao 
{
	
	public boolean bankLogIn();  //  method to identify bank
	public void changeBankPassword();  //   to change bank login password
	public void createAccount();  //   to create bank account
	public void updateCudtomertDetails();  //   to update customer details 
	public void fetchAllCusttomerDetails();  //   to see all customer's details
	public void deleteCustomerDetails();  //   to delete customer details
	public boolean customerLogIn();  //   method to identify customer
	public void changeCustomerPassword();  //   to change customer login password
	public void widrawMoney();  //   to widraw money
	public void depositMoney();  //   to deposit money
	
}
