package rest.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import rest.entity.Employee;


@Repository
public interface EmployeeDAO {

	public Employee getEmployeeById(int id) ;
	public List<Employee> getAllEmployees() ;
	public void deleteEmployee(int id);
	public void updateEmployee( Employee item ) ;
	public void createEmployee(Employee item) ;
	
	
}
