package com.rakshit.springjpadata;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rakshit.springjpadata.service.EmployeeService;





public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/rakshit/springjpadata/config/my_spring_config.xml");
		EmployeeService employeeService = (EmployeeService) applicationContext.getBean("employeeService");
		
		try {
			while(true) {
				System.out.println();
				System.out.println("Enter 1: Insert Employee");
				System.out.println("Enter 2: Update Employee");
				System.out.println("Enter 3: List  Employee");
				System.out.println("Enter 4: Delete Employee");
				System.out.println("Enter 5: List All Employee");
				System.out.println("Enter 6: Find Employee By Name");
				System.out.println("Enter 7: Find Employee By Name Like");
				System.out.println("Enter 8: Exit");
				System.out.println();
				
				Scanner scanner = new Scanner(System.in);
				int option = scanner.nextInt();
				
				switch(option) {
				case 1:employeeService.insert();
				break;
				case 2:employeeService.update();
				break;
				case 3:employeeService.read();
				break;
				case 4:employeeService.delete();
				break;
				case 5:employeeService.readAll();
				break;
				case 6:employeeService.findByName();
				break;
				case 7:employeeService.nameLike();
				break;
				case 8:System.exit(0);
				break;
				default:System.out.println("Unexpected value : "+option);
				
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
