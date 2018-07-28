package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;

public class EmployeeSearchDAOImpl implements EmployeeSearchDAO {
	private static final String GET_EMPS_BY_INPUTS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP WHERE EMPNO=? OR ENAME=? OR JOB=? OR SAL=?";
	private JdbcTemplate jt;

	public EmployeeSearchDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<EmployeeResultBO> search(EmployeeBO bo) {
		List<EmployeeResultBO> listRBO;
		listRBO=jt.query(GET_EMPS_BY_INPUTS, 
				                       new SearchEmployeeExtractor(),
				                       bo.getEmpNo(),bo.getEmpName(),bo.getEmpDesg(),bo.getEmpSalary());
		return listRBO;
	}
	
	private class  SearchEmployeeExtractor implements ResultSetExtractor<List<EmployeeResultBO>>{

		@Override
		public List<EmployeeResultBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		   List<EmployeeResultBO> listRBO=null;
		   EmployeeResultBO  RBO=null;
			//copy ResultSet obj records ListRBO
		   listRBO=new ArrayList();
		   while(rs.next()){
			   RBO=new EmployeeResultBO();
			   RBO.setDeptNo(rs.getInt(5));
			   RBO.setEmpNo(rs.getInt(1));
			   RBO.setEmpName(rs.getString(2));
			   RBO.setEmpDesg(rs.getString(3));
			   RBO.setEmpSalary(rs.getInt(4));
			   RBO.setMgrNo(rs.getInt(6));
			   listRBO.add(RBO);
		   }//while
			return listRBO;
		}//extractResult
	}//inner class

}//outer class
