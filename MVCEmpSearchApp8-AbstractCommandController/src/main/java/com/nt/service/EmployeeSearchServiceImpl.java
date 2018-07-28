package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;
import com.nt.dao.EmployeeSearchDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;

public class EmployeeSearchServiceImpl implements EmployeeSearchService {
	private EmployeeSearchDAO dao;
	
	public EmployeeSearchServiceImpl(EmployeeSearchDAO dao) {
		this.dao = dao;
		}

	

	@Override
	public List<EmployeeResultDTO> findEmployees(EmployeeDTO dto) {
		 EmployeeBO bo=null;
		 List<EmployeeResultBO> listRBO=null; 
		 List<EmployeeResultDTO>listRDTO=null;
		 EmployeeResultDTO rdto=null;
		//Convert DTO to BO
		 bo=new EmployeeBO();
		 BeanUtils.copyProperties(dto,bo);
		 //use DAO
		 listRBO=dao.search(bo);
		 // Convert listRBO to listRDTO
		 listRDTO=new ArrayList();
		 for(EmployeeResultBO rbo:listRBO){
			 rdto=new EmployeeResultDTO();
			 rdto.setSno(listRDTO.size()+1);
			 BeanUtils.copyProperties(rbo,rdto);
			 listRDTO.add(rdto);
		 }
		return listRDTO;
	}//method
}//class

