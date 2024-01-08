package com.mt;

import java.util.*;
import com.nt.*;

@SuppressWarnings("serial")
public class BankMainClass extends Exception 
{
	public BankMainClass(String msg)
	{
		super(msg);
	}
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		try
		{
			int count = 0;
			xyz:while(true)
			{
				try
				{
					System.out.println("Enter the PinNo.");
					int pinNo = s.nextInt();
					if(!(pinNo>=1111 && pinNo<=9999))
					{
						BankMainClass bmc = new BankMainClass("Invalid PinNo.");
						throw bmc;
					}
					boolean k = new CheckPinNo().verify(pinNo);
					if(!k)
					{
						BankMainClass bmc = new BankMainClass("PinNo. Doesnot Exsist");
						throw bmc;
					}
					
					System.out.println("*****CHOICE*****");
					System.out.println("\t1.WithDraw Amount" + "\n\t2.Deposit Amount");
					System.out.println("Enter the Choice");
					int choice = s.nextInt();
					switch(choice)
					{
					case 1:
						try
						{
							System.out.println("Enter the Amount to WithDraw");
							int a1 = s.nextInt();
							if(!(a1>0 && a1%100==0))
							{
								BankMainClass bmc = new BankMainClass("Invalid Amount");
								throw bmc;
							}
							WithDraw wd = new WithDraw("");
							wd.process(a1);
						}
						catch(BankMainClass bmc)
						{
							System.out.println(bmc.getMessage());
						}
						catch(WithDraw ob)
						{
							System.out.println(ob.getMessage());
						}
						break xyz;
						
					case 2:
						try
						{
							System.out.println("Enter the Amount to Deposit");
							int a2 = s.nextInt();
							if(!(a2>0 && a2%100==0))
							{
								BankMainClass bmc = new BankMainClass("Invalid Amount");
								throw bmc;
							}
							Deposit dp = new Deposit();
							dp.process(a2);
						}
						catch(BankMainClass | WithDraw bmc)
						{
							System.out.println(bmc.getMessage());
						}
						break xyz;
						
						default:
							System.out.println("Invalid Choice...");
							break xyz;
					}
				}
				catch(BankMainClass bmc)
				{
					System.out.println(bmc.getMessage());
					count++;
					if(count==3)
					{
						System.out.println("Transaction Blocked..");
						break;
					}
				}
			}
		}
		finally
		{
			s.close();
		}
	}
}
