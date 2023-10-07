package com.rakshit.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rakshit.springcore.bean.Employee;
import com.rakshit.springcore.bean.Person;
import com.rakshit.springcore.bean.Student;
import com.rakshit.springcore.bean.Teacher;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/rakshit/springcore/config/my_spring_config.xml");
		Employee emp = (Employee) applicationContext.getBean("empObject");
		System.out.println("Employee name : "+ emp.getEmployeeName());
		System.out.println("Employee role : "+ emp.getRole());
		System.out.println();
		
		Student std = (Student) applicationContext.getBean("stdObj");
		System.out.println("Student name : "+ std.getStudentName());
		System.out.println("Student course : "+ std.getCourse());
		System.out.println();
		
		Teacher tch = (Teacher) applicationContext.getBean("teacher");
		System.out.println("Teacher name : "+ tch.getTeacherName());
		System.out.println("Teacher subject : "+ tch.getSubject());
		System.out.println();
		
		Person per = (Person) applicationContext.getBean("person");
		System.out.println("Person Employee name : "+ per.getEmployee().getEmployeeName());
		System.out.println("Person Employee role : "+ per.getEmployee().getRole());
		System.out.println();
		System.out.println("Person Student name : "+ per.getStudent().getStudentName());
		System.out.println("Person Student course : "+ per.getStudent().getCourse());
		System.out.println();
		System.out.println("Person Teacher name : "+ per.getTeacher().getTeacherName());
		System.out.println("Person Teacher subject : "+ per.getTeacher().getSubject());
		System.out.println();
		
		

	}

}
