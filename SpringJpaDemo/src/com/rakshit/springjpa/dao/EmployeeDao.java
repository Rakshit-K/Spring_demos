package com.rakshit.springjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rakshit.springjpa.entity.Employee;


@Repository
public class EmployeeDao {
	
	@Autowired
	private EntityManagerFactory emf;
	public static EntityManager em;

	public EntityManager getEntityManager() {
		try {
			if (em == null) {
				em = emf.createEntityManager();
				return em;
			} else {
				return em;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void insert(Employee employee) {
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			System.out.println("Employee saved succesfully");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

	}

	public void update(Employee employee) throws Exception {
		try {
			em = getEntityManager();
			Employee empExist = em.find(Employee.class, employee.getEmployeeId());
			if (empExist != null) {
				em.getTransaction().begin();
				empExist.setEmployeeName(employee.getEmployeeName());
				empExist.setRole(employee.getRole());
				empExist.setInserttime(employee.getInserttime());
				empExist.setSalary(employee.getSalary());
				em.getTransaction().commit();
				System.out.println("Employee updated succesfully");
			} else {
				System.out.println("Employee not found");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Employee not found");
		}
		

	}

	public void read(Employee employee) throws Exception {
		try {
			em = getEntityManager();
			Employee empExist = em.find(Employee.class, employee.getEmployeeId());
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

	public void delete(Employee employee) throws Exception {
		try {
			em = getEntityManager();
			Employee empExist = em.find(Employee.class, employee.getEmployeeId());
			if (empExist != null) {
				em.getTransaction().begin();
				em.remove(empExist);
				em.getTransaction().commit();
				System.out.println("Employee updated succesfully");
			} else {
				System.out.println("Employee not found");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Employee not found");
		}
		

	}

	public void readAll() throws Exception {
		try {
			em = getEntityManager();
			Query query = em.createQuery("select e from Employee e");
			List<Employee> empList = query.getResultList();
			for (Employee empExist : empList) {
				System.out.println("id: " + empExist.getEmployeeId());
				System.out.println("name: " + empExist.getEmployeeName());
				System.out.println("date: " + empExist.getInserttime());
				System.out.println("role: " + empExist.getRole());
				System.out.println("salary: " + empExist.getSalary());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

	}

	public void idRange(int from, int to) throws Exception {
		try {
			em = getEntityManager();
			Query query = em.createQuery("SELECT e FROM Employee e where e.employeeId between ?1 and ?2");
			query.setParameter(1, from);
			query.setParameter(2, to);
			List<Employee> empList = query.getResultList();
			for (Employee empExist : empList) {
				System.out.println("id: " + empExist.getEmployeeId());
				System.out.println("name: " + empExist.getEmployeeName());
				System.out.println("date: " + empExist.getInserttime());
				System.out.println("role: " + empExist.getRole());
				System.out.println("salary: " + empExist.getSalary());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	public void nameLike(String pattern) throws Exception {
		try {
			em = getEntityManager();
			Query query = em.createQuery("Select e from Employee e where e.employeeName like :p1");
			query.setParameter("p1", pattern);
			List<Employee> empList = query.getResultList();
			for (Employee empExist : empList) {
				System.out.println("id: " + empExist.getEmployeeId());
				System.out.println("name: " + empExist.getEmployeeName());
				System.out.println("date: " + empExist.getInserttime());
				System.out.println("role: " + empExist.getRole());
				System.out.println("salary: " + empExist.getSalary());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
