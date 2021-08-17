package com.jmaster.shopbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jmaster.shopbanhang.service.AccountService;

@Controller
public class LoginController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/login")
	public String login() {
		return "site/login";
	}
}
