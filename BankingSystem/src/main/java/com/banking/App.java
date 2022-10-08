/*
 SAIKAT MANDI
 */

package com.banking;

import java.io.BufferedReader;
import java.util.Scanner;

import com.banking.dao.BankDao;
import com.banking.daoimpl.BankDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
        
    	BankDao bankDaoObj = new BankDaoImpl();
    	Scanner scannerObj1 = new Scanner(System.in);
    	
    	System.out.println("----------------------------------------------------------");
    	System.out.println("PRESS 1 TO LOGIN AS BANK\nPRESS 2 TO LOGIN AS CUSTOMER");
    	System.out.println("----------------------------------------------------------");
    	
    	char w;
		do 
		{
			
			int t = scannerObj1.nextInt();
			
			switch (t) 
			{
			
			case 1: 
			{
				
				bankDaoObj.createAccount();
				
			}
			break;
			
			case 2:
			{
				
				bankDaoObj.changeBankPassword();
				
			}
			break;
			
			case 3:
			{
				
				bankDaoObj.bankLogIn();
				
			}
			break;
			
			case 4:
			{
				
				bankDaoObj.deleteCustomerDetails();
				
			}
			break;
			
			case 5:
			{
				
				bankDaoObj.updateCudtomertDetails();
				
			}
			break;
			
			case 6:
			{
				
				bankDaoObj.fetchAllCusttomerDetails();
				
			}
			break;
			
			case 7:
			{
				
				bankDaoObj.widrawMoney();
				
			}
			break;
			
			case 8:
			{
				
				bankDaoObj.depositMoney();
				
			}
			break;
			
			default:
			{
				
				System.out.println("SORRY... YOU ENTERED A INVALID INPUT-------->");
				
			}
			break;
			
			}
			
			
			System.out.println("DO YOU WANT TO CONTINUE UPDATE ( Y / N ) -------->");
			
			z = scannerobj.next().charAt(0);
			
			
		} while (z == 'Y' || z == 'y');
    	
    }
    
}
