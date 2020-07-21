package com.montran.pojo;

public class Current extends Account{
	private double overDraftBalance;
	private double overDraftLimit;
	private double toOverDraftBalance;
	public Current() {
		// TODO Auto-generated constructor stub
	}
	public Current(int accountNumber, String name, double balance, double overDraftBalance,double overDraftLimit) {
		super(accountNumber, name, balance);
		this.overDraftBalance = overDraftBalance;
		this.overDraftLimit=overDraftLimit;
	}
	public double getOverDraftBalance() {
		return overDraftBalance;
	}
	
	public void setOverDraftBalance(double overDraftBalance) {
		this.overDraftBalance = overDraftBalance;
	}
	
	@Override
	public boolean withdraw(double amount) {
		if(amount>0)
		{
			if(amount<=getBalance()) {
				setBalance(getBalance()-amount);
				return true;
			}
			if(amount>getBalance() && amount<=getBalance()+overDraftBalance) {
				amount=amount-getBalance();
				setBalance(getBalance()-getBalance());
				overDraftBalance=overDraftBalance-amount;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean deposit(double amount) {
		if(amount>0)
		{
			if(overDraftBalance!=overDraftLimit)
			{
				toOverDraftBalance=overDraftLimit-overDraftBalance;
				if(toOverDraftBalance<amount)
				{
					overDraftBalance=overDraftBalance+toOverDraftBalance;
					amount=amount-toOverDraftBalance;
					setBalance(amount+getBalance());
					return true;
				}
				if(toOverDraftBalance>=amount) {
					overDraftBalance=overDraftBalance+amount;
					return true;
				}
			}
			else
			{
				setBalance(amount+getBalance());
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Current [overDraftBalance=" + overDraftBalance + ", getAccountNumber()=" + getAccountNumber()
				+ ", getName()=" + getName() + ", getBalance()=" + getBalance() + "]";
	}
	
	
	
	
	
}
