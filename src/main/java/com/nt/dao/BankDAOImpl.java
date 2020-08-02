package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements BankDAO {
	private static final String WITHRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=? ";
	private static final String DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=? ";
	private JdbcTemplate jt;
	
	public BankDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int withdraw(int acno, float amt) {
		int count=0;
		count=jt.update(WITHRAW_QUERY, amt,acno);
		return count;
	}

	public int deposite(int acno, float amt) {
		int count=0;
		count=jt.update(DEPOSITE_QUERY,amt,acno);
		return count;
	}

}
