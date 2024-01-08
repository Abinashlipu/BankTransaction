package com.nt;

@SuppressWarnings("serial")
public class WithDraw extends Exception implements Transaction 
{
	public WithDraw(String msg)
	{
		super(msg);
	}
	@Override
	public void process(int amt) throws WithDraw 
	{
		try
		{
			if(amt>b.bal)
			{
				WithDraw ob = new WithDraw("Insufficient Fund");
				throw ob;
			}
			
			System.out.println("Amount WithDrawn : "+amt);
			b.bal = b.bal-amt;
			System.out.println("Balance Amount : "+ b.getBalance());
			System.out.println("Transaction Completed");
		}
		catch(WithDraw ob)
		{
			throw ob;
		}
	}
	
}
