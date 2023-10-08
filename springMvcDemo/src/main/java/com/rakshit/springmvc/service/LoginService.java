package com.rakshit.springmvc.service;

import com.rakshit.springmvc.bean.Login;
import com.rakshit.springmvc.dao.LoginDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

		public String validateLogin(Login loginBean){
			
			return loginDAO.validateLogin(loginBean);
			
		}

}
