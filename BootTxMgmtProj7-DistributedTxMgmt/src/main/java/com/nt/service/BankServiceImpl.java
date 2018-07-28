package com.nt.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.DepositeDAO;
import com.nt.dao.WithdrawDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
  private WithdrawDAO wDAO;
	@Autowired
  private DepositeDAO dDAO;
  
	@Override
	@Transactional(propagation=Propagation.REQUIRED,timeout=300,readOnly=false)
	public String transferMoney(int srcAcno, int destAcno, int amt) {
		int result1=0,result2=0;
		result1=wDAO.withdraw(srcAcno, amt);
		result2=dDAO.deposite(destAcno, amt);
		if(result1==0 || result2==0)
			throw new RuntimeException("Money transfer failed");
			else
				return "Moeny transfered";
	}

}
