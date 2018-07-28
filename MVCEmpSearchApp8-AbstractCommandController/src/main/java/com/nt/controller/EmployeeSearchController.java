package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.EmployeeSearchCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeSearchService;

public class EmployeeSearchController extends AbstractCommandController {
	private  EmployeeSearchService  service=null;

	public EmployeeSearchController(EmployeeSearchService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		 EmployeeDTO dto=null;
		 EmployeeSearchCommand cmd=null;
		 List<EmployeeResultDTO>  listRDTO=null;
		 //type casting
		 cmd=(EmployeeSearchCommand)command;
		// Convert Command obj to DTO
		 dto=new EmployeeDTO();
		 BeanUtils.copyProperties(cmd,dto);
		 //use Service
		 listRDTO=service.findEmployees(dto);
		 //create and return MAV
		 return  new ModelAndView("report_emps","listEmps",listRDTO);
	}//method
}//class
