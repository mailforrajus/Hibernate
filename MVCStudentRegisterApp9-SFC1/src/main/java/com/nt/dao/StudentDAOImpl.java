package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static  final String  MVC_STUD_INSERT="INSERT INTO MVC_STUDENT VALUES(MVC_STUD_SEQ.NEXTVAL,?,?,?,?)"; 
	private JdbcTemplate jt;

	public StudentDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int insert(StudentBO bo) {
		int result=0;
		//use JdbcTemplate
		result=jt.update(MVC_STUD_INSERT,bo.getSname(),bo.getSadd(),bo.getCourse(),bo.getPercentage());
		return result;
	}

}
