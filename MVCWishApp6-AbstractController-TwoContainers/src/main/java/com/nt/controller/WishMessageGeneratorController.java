package com.nt.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMessageService;

public class WishMessageGeneratorController extends AbstractController {
	 private WishMessageService  service;
	public WishMessageGeneratorController(WishMessageService service) {
		this.service=service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result=null;
		//use service
		result=service.generateWishMessage();
		
			return new ModelAndView("show_wish","wMsg",result);
	}

}
