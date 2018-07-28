package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication(exclude={ DataSourceAutoConfiguration.class,
	                                                                 DataSourceTransactionManagerAutoConfiguration.class,
	                                                                 JdbcTemplateAutoConfiguration.class,
	                                                              })
@Import(value=AppConfig.class)
public class BootTxMgmtProj7DistributedTxMgmtApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		ctx=SpringApplication.run(BootTxMgmtProj7DistributedTxMgmtApplication.class, args);
		 //get Proxy obj
		proxy=ctx.getBean("bankService",BankService.class);
		try{
			System.out.println("result==>"+proxy.transferMoney(1001, 1006,2000));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}
}
