package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;
import com.nt.service.ListEmployeeService;

public class ListEmployeesController extends AbstractController {
	private  ListEmployeeService  service;
	
	public ListEmployeesController(ListEmployeeService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<EmployeeDTO> listDTO=null;
		ModelAndView mav=null;
		//use SErvice
		listDTO=service.getAllEmployees();
		//create and return MAV object
		mav=new ModelAndView();
		mav.setViewName("emps_report");
		mav.addObject("listEmps",listDTO);
		return mav;
	}

}
