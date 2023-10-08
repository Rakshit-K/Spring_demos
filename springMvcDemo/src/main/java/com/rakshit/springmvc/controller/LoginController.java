package com.rakshit.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rakshit.springmvc.bean.Login;
import com.rakshit.springmvc.service.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService; 
	
	
	@RequestMapping(value = "/validateLogin.html", method = RequestMethod.POST)
	public ModelAndView validateLogin(@RequestParam("uName")String userName, @RequestParam("pwd")String password) {

		
		
		Login loginBean = new Login();
		loginBean.setPassword(password);
		loginBean.setUserName(userName);
		
		String returnValue = loginService.validateLogin(loginBean);

		ModelAndView modelAndView = new ModelAndView();

		if (returnValue.equals("success")) {
			modelAndView.setViewName("success.jsp");
			modelAndView.addObject("message", 
					"Welcome: " + userName);
		} else {
			modelAndView.setViewName("failure.jsp");
			modelAndView.addObject("errorMessage","Please Login again with valid credentials");
		}
		return modelAndView;

	}

}
