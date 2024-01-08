package com.nt;

public class Deposit implements Transaction 
{
	@Override
	public void process(int amt) throws WithDraw 
	{
		System.out.println("Amount Deposited : "+amt);
		b.bal = b.bal+amt;
		System.out.println("Balance Amount : "+b.getBalance());
		System.out.println("Transaction Completed");
		
	}
	
}
