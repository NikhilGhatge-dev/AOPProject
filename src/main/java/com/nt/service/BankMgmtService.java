package com.nt.service;

public interface BankMgmtService {
	public String withdrowMoney(int acno,float amt);
	public String depositeMoney(int acno,float amt);
}
