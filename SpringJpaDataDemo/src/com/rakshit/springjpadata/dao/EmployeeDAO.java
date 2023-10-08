package com.rakshit.springjpadata.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rakshit.springjpadata.entity.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
	Employee findByEmployeeName(String name);
	
	@Query("select e from Employee e where e.employeeName like:name")
	Employee findByEmployeeNameLike(@Param("name") String name);

}
