package com.jmaster.shopbanhang.controller.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jmaster.shopbanhang.model.AccountDTO;
import com.jmaster.shopbanhang.service.AccountService;

@Controller
public class LoginController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "site/login";
	}
	
	
	@GetMapping("/access/deny")
	public String accessDey(HttpServletRequest request) {
		return "access-deny";
	}
}
