package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.StudentCommand;

public class StudentCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//return   clazz.isAssignableFrom(StudentCommand.class);
		return   clazz==StudentCommand.class;
	}

	@Override
	public void validate(Object command, Errors errors) {
		StudentCommand cmd=null;
		String vstatus=null;
		//type casting
		cmd=(StudentCommand)command;
		//read validation status at client side
		vstatus=cmd.getVflag();
	if(vstatus.equalsIgnoreCase("no")){
	 	System.out.println("StudentCommandValidator.validate(-,-) -->Server side form validations");
		//server side form validations...
		 if(cmd.getSname().length()==0 || cmd.getSname().equals("") || cmd.getSname()==null){
			 errors.rejectValue("sname","sname.required");
		 }
		 if(cmd.getSadd().length()==0 || cmd.getSadd().equals("") || cmd.getSadd()==null){
			 errors.rejectValue("sadd","sadd.required");
		 }
		 if(cmd.getCourse().length()==0 || cmd.getCourse().equals("") || cmd.getCourse()==null){
			 errors.rejectValue("course","course.required");
		 }
		 if(cmd.getPercentage()==null){
			 errors.rejectValue("percentage","percentage.required");
		 }
		 else if(cmd.getPercentage()<0.0f || cmd.getPercentage()>100.0f){
			 errors.rejectValue("percentage", "percentage.range");
		 }
		}//if
	}//method
}//class
