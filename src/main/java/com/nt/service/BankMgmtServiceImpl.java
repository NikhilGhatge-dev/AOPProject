package com.nt.service;

import com.nt.dao.BankDAO;

public class BankMgmtServiceImpl implements BankMgmtService {
	private BankDAO dao;

	public BankMgmtServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	public String withdrowMoney(int acno, float amt) {
		int count = 0;
		// use dao
		count = dao.withdraw(acno, amt);
		if (count == 0)
			return "Money is not available";
		else
			return "Money is withdrow " + amt + " from AcountNo:- " + acno;
	}

	public String depositeMoney(int acno, float amt) {
		int count;
		// use dao
		count = dao.deposite(acno, amt);
		return (count == 0) ? "Money is not deposite " : "Money is deposited from  " + acno + " account";
	}

}
