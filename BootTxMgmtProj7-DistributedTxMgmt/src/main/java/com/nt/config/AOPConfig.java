package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
@EnableTransactionManagement
public class AOPConfig {
	
	@Bean(name="amsTxService")
	public  UserTransactionImp  createAmsUserTxService(){
		UserTransactionImp txService=null;
		txService=new UserTransactionImp();
		return txService;
	}
	
	@Bean(name="amsTxMgmr")
	public  UserTransactionManager createAmsUserTxMgmr(){
		UserTransactionManager txMgmr=null;
		txMgmr=new UserTransactionManager();
		return txMgmr;
	}
	
	
	@Bean(name="jtaTxMgmr")
	public JtaTransactionManager createJtaTxMgmr(){
		JtaTransactionManager  jtaTxMgmr=null;
		jtaTxMgmr=new JtaTransactionManager();
		jtaTxMgmr.setUserTransaction(createAmsUserTxService());
		jtaTxMgmr.setTransactionManager(createAmsUserTxMgmr());
		return jtaTxMgmr;
		
	}

}
