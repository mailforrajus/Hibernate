package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDAO")
public class DepositeDAOImpl implements DepositeDAO {
	 private static final String  DEPOSITE_QUERY="UPDATE DTXACCOUNT2 SET BALANCE=BALANCE+? WHERE ACNO=?";
		
		@Autowired
		@Qualifier("mysqlTemplate")
		private JdbcTemplate mysqlJt;

		@Override
		public int deposite(int acno, int amt) {
			int count=0;
			count=mysqlJt.update(DEPOSITE_QUERY,amt,acno);
			return count;
		}
}
