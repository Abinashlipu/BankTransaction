package com.nt;

@FunctionalInterface
public interface Transaction 
{
	public Balance b = new Balance();
	public abstract void process(int amt) throws WithDraw;
}
