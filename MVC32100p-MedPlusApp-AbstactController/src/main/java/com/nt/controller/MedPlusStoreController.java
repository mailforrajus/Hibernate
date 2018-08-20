package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.MedicineDetailsDTO;
import com.nt.service.MedPlusStoreService;

@Controller
public class MedPlusStoreController {
   @Autowired
	private MedPlusStoreService service;
    
	@RequestMapping("/medplus.htm")
	public String handle(Map<String,Object> map) throws Exception {
		List<MedicineDetailsDTO> listDTO=null;
		//use sErvice class
		listDTO=service.getAllMedicines();
		//prepare Model Data
	map.put("listMed",listDTO);
	//return  LVN 
		return "show_report";
	}

}
