package com.rakshit.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.rakshit.springmvc.bean.Login;


@Repository
public class LoginDAO {
public String validateLogin(Login loginBean){
		
		String uName = loginBean.getUserName();
		String password = loginBean.getPassword();
		
		if(uName.equals("Rakshit") && password.equals("1234")){
			return "success";
		}
		else{
			return "faliure";
		}
	}

}
