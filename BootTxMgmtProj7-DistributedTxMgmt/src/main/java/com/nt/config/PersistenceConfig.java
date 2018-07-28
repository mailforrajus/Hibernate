package com.nt.config;

import java.util.Properties;

import javax.sql.XADataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="oraXADs")
	public AtomikosDataSourceBean  createOraXADataSource(){
		AtomikosDataSourceBean  xaOraDs=null;
		Properties props=null;
		xaOraDs=new AtomikosDataSourceBean();
		xaOraDs.setUniqueResourceName("oraXADs");
		xaOraDs.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		props=new Properties();
		props.setProperty("databaseName", "xe");
		props.setProperty("URL","jdbc:oracle:thin:@localhost:1521:xe");
		props.setProperty("user","system");
		props.setProperty("password","manager");
		xaOraDs.setXaProperties(props);
		return xaOraDs;
	}
	
	@Bean(name="mysqlXADs")
	public AtomikosDataSourceBean  createMysqlXADataSource(){
		AtomikosDataSourceBean  xaOraDs=null;
		Properties props=null;
		xaOraDs=new AtomikosDataSourceBean();
		xaOraDs.setUniqueResourceName("mysqlXADs");
		xaOraDs.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		props=new Properties();
		props.setProperty("databaseName", "ntsp69db");
		props.setProperty("URL","jdbc:mysql:///ntsp69db");
		props.setProperty("user","root");
		props.setProperty("password","root");
		xaOraDs.setXaProperties(props);
		return xaOraDs;
	}
	
	@Bean(name="oraTemplate")
	public  JdbcTemplate createOraJdbcTemplate(){
		return new JdbcTemplate(createOraXADataSource());
	}
	
	@Bean(name="mysqlTemplate")
	public  JdbcTemplate createMysqlJdbcTemplate(){
		return new JdbcTemplate(createMysqlXADataSource());
	}


}
