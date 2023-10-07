package com.rakshit.springjpa.service;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakshit.springjpa.dao.EmployeeDao;
import com.rakshit.springjpa.entity.Employee;


@Component
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	public void insert() throws Exception {
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		employee.setEmployeeId(scanner.nextInt());
		System.out.println("Enter employee name");
		employee.setEmployeeName(scanner.next());
		System.out.println("Enter employee role");
		employee.setRole(scanner.next());
		System.out.println("Enter employee salary");
		employee.setSalary(scanner.nextDouble());
		employee.setInserttime(new Date());
		
		employeeDao.insert(employee);

	}

	public void update() throws Exception {
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter existing employee id");
		employee.setEmployeeId(scanner.nextInt());
		System.out.println("Enter updated employee name");
		employee.setEmployeeName(scanner.next());
		System.out.println("Enter updated employee role");
		employee.setRole(scanner.next());
		System.out.println("Enter updated employee salary");
		employee.setSalary(scanner.nextDouble());
		employee.setInserttime(new Date());
		
		employeeDao.update(employee);

	}

	public void read() throws Exception {
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter existing employee id");
		employee.setEmployeeId(scanner.nextInt());
		employeeDao.read(employee);

	}

	public void delete() throws Exception {
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter existing employee id");
		employee.setEmployeeId(scanner.nextInt());
		
		employeeDao.delete(employee);

	}
	
	public void readAll() throws Exception {
		employeeDao.readAll();

	}
	
	public void idRange() throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter from id");
		int from = scanner.nextInt();
		
		System.out.println("Enter to id");
		int to = scanner.nextInt();
		employeeDao.idRange(from, to);

	}
	
	public void nameLike() throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter name like pattern");
		String pattern = scanner.next();
		
		employeeDao.nameLike(pattern);

	}

}
