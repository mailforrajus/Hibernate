package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentInsertController extends SimpleFormController {
	 

	private  StudentService service;
	
	  public StudentInsertController(StudentService service) {
			this.service = service;
		}
	   
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		StudentDTO dto=null;
		String result=null;
		StudentCommand cmd=null;
		//type casting
		cmd=(StudentCommand)command;
		// Applicatioon logic error
        if(cmd.getSadd().equalsIgnoreCase("hyd") || cmd.getSadd().equalsIgnoreCase("secbad")){
        	errors.rejectValue("sadd","addrs.restriction");
        	return showForm(request,response,errors);
        	
        }
		//convert Cmd obj to  DTO
		dto=new StudentDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use Service
		result=service.register(dto);
		 //return new ModelAndView("result","resMsg",result);
		return new ModelAndView(getSuccessView(),"resMsg",result);
	}
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("dbl_post_error");
	}

}
