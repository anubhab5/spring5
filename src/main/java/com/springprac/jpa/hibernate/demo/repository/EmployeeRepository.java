package com.springprac.jpa.hibernate.demo.repository;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springprac.jpa.hibernate.demo.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager em;

	// Save an Employee
	public void saveEmployee(Employee emp) {
		em.persist(emp);
	}
	
	public List<Employee> getAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
}
