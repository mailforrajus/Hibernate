package com.nt.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.handler.SysDateGenerator;
import com.nt.handler.SysPropsGenerator;

public class MainFrontControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String vpath=null;
		SysDateGenerator dateGenerator=null;
		Date date=null;
		String view_page;
		SysPropsGenerator  propsGenerator=null;
		Properties props=null;
		RequestDispatcher rd=null;
		//get Virtual Path of request url
		vpath=req.getServletPath();
		if(vpath.equalsIgnoreCase("/link1.do")){
			//use Hanlder class
			dateGenerator=new SysDateGenerator();
			date=dateGenerator.generateDate();
			//select view page
			view_page="/show_date.jsp";
			//keep result in request scope
			req.setAttribute("result",date);
		}
		else if(vpath.equalsIgnoreCase("/link2.do")){
			//use Handler class
			propsGenerator=new SysPropsGenerator();
			props=propsGenerator.getSysProperties();
			//select view page
			view_page="/show_props.jsp";
			//keep  result in request scope
			req.setAttribute("result", props);
		}
		else{
			//select error.jsp as view page
			view_page="/error.jsp";
			//keep error message in request scope
			req.setAttribute("result","Invalid Request");
		}
		
		//forward control to view page
		rd=req.getRequestDispatcher(view_page);
		rd.forward(req,res);
		
		
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
