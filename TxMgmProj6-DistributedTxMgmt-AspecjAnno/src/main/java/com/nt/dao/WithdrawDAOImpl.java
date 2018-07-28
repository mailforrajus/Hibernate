package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("withdrawDAO")
public class WithdrawDAOImpl implements WithdrawDAO {
	 private static final String  WITHDRAW_QUERY="UPDATE DTXACCOUNT1 SET BALANCE=BALANCE-? WHERE ACNO=?";
	
	@Autowired
	@Qualifier("oraTemplate")
	private JdbcTemplate oraJt;

	@Override
	public int withdraw(int acno, int amt) {
		int count=0;
		count=oraJt.update(WITHDRAW_QUERY,amt,acno);
		return count;
	}

}
