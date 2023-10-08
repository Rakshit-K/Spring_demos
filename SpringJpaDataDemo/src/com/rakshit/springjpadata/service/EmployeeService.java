package com.rakshit.springjpadata.service;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakshit.springjpadata.dao.EmployeeDAO;
import com.rakshit.springjpadata.entity.Employee;

@Component
public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	public void insert() throws Exception {
		try {
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

			Employee result = employeeDAO.save(employee);
			System.out.println("Employee registered successfully " + result.getEmployeeId());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public void update() throws Exception {
		try {
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

			Employee empExist = employeeDAO.findOne(employee.getEmployeeId());
			if (empExist != null) {
				empExist.setEmployeeName(employee.getEmployeeName());
				empExist.setInserttime(employee.getInserttime());
				empExist.setRole(employee.getRole());
				empExist.setSalary(employee.getSalary());
				employeeDAO.save(empExist);
				System.out.println("Employee updated successfully");
			} else {
				System.out.println("Employee not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public void read() throws Exception {
		try {
			Employee employee = new Employee();
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter existing employee id");
			employee.setEmployeeId(scanner.nextInt());
			Employee empExist = employeeDAO.findOne(employee.getEmployeeId());
			System.out.println("id: " + empExist.getEmployeeId());
			System.out.println("name: " + empExist.getEmployeeName());
			System.out.println("date: " + empExist.getInserttime());
			System.out.println("role: " + empExist.getRole());
			System.out.println("salary: " + empExist.getSalary());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public void delete() throws Exception {
		try {
			Employee employee = new Employee();
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter existing employee id");
			employee.setEmployeeId(scanner.nextInt());

			Employee empExist = employeeDAO.findOne(employee.getEmployeeId());
			if (empExist != null) {
				employeeDAO.delete(empExist);
				System.out.println("Employee removed successfully");
			} else {
				System.out.println("Employee not found");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public void readAll() throws Exception {
		try {
			Iterable<Employee> empList = employeeDAO.findAll();
			for (Employee empExist : empList) {
				System.out.println("id: " + empExist.getEmployeeId());
				System.out.println("name: " + empExist.getEmployeeName());
				System.out.println("date: " + empExist.getInserttime());
				System.out.println("role: " + empExist.getRole());
				System.out.println("salary: " + empExist.getSalary());
				System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public void findByName() throws Exception {
		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter Name");
			String name = scanner.next();

			Employee empExist = employeeDAO.findByEmployeeName(name);
			System.out.println("id: " + empExist.getEmployeeId());
			System.out.println("name: " + empExist.getEmployeeName());
			System.out.println("date: " + empExist.getInserttime());
			System.out.println("role: " + empExist.getRole());
			System.out.println("salary: " + empExist.getSalary());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public void nameLike() throws Exception {
		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter name like pattern");
			String pattern = scanner.next();

			Employee empExist = employeeDAO.findByEmployeeNameLike(pattern);
			System.out.println("id: " + empExist.getEmployeeId());
			System.out.println("name: " + empExist.getEmployeeName());
			System.out.println("date: " + empExist.getInserttime());
			System.out.println("role: " + empExist.getRole());
			System.out.println("salary: " + empExist.getSalary());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
