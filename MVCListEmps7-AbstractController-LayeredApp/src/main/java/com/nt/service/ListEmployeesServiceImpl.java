package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.EmployeeBO;
import com.nt.dao.ListEmployeesDAO;
import com.nt.dto.EmployeeDTO;

public class ListEmployeesServiceImpl implements ListEmployeeService {
	private ListEmployeesDAO dao;

	public ListEmployeesServiceImpl(ListEmployeesDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO dto=null;
		//use DAO
		listBO=dao.retriveAllEmployees();
		//Convert listBO to listDTO
		listDTO=new ArrayList();
		for(EmployeeBO bo:listBO){
			dto=new EmployeeDTO();
			dto.setSno(listDTO.size()+1);
			dto.setEmpNo(bo.getEmpNo());
			dto.setEname(bo.getEname());
			dto.setDesg(bo.getDesg());
			dto.setSalary(bo.getSalary());
			dto.setDeptNo(bo.getDeptNo());
			listDTO.add(dto);
		}
		return listDTO;
	}//method
}//class
