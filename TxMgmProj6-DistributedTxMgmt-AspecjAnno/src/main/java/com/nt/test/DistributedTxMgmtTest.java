package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class DistributedTxMgmtTest{

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC contaier
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
       //get Proxy obj
		proxy=ctx.getBean("bankService",BankService.class);
		try{
			System.out.println("result==>"+proxy.transferMoney(1004, 1002,2000));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
