package com.fantastic.web.dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fantastic.web.dao.HelpDao;
import com.fantastic.web.vo.Help;


@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	private HelpDao helpDao;
	
	
	@Autowired
	public void setHelpDao(HelpDao helpDao) {
		this.helpDao = helpDao;
	}



	@RequestMapping("help")
	public String Help(Model model){
		
		List<Help> list = helpDao.getHelps();		
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/view/customer/help.jsp";
	}

}
