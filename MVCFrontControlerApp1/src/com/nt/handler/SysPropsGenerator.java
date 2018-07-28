package com.nt.handler;

import java.util.Properties;

public class SysPropsGenerator {
	
	public  Properties  getSysProperties(){
		Properties props=null;
		props=System.getProperties();
		return props;
	}

}
