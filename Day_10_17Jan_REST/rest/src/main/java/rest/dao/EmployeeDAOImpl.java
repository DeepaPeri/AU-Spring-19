package rest.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import rest.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String SQL_FIND_ITEM = "SELECT employee_id , employee_NAME , employee_salary FROM employee WHERE employee_id = ?";
	private static final String SQL_DELETE_ITEM = "DELETE FROM employee WHERE employee_ID = ?";
	private static final String SQL_UPDATE_ITEM = "UPDATE employee SET employee_NAME=?, employee_salary= ? WHERE employee_ID=?";
	private static final String SQL_GET_ALL_ITEMS = "SELECT employee_ID , employee_NAME , employee_salary  FROM employee";
	private static final String SQL_INSERT_ITEM = "INSERT INTO employee (  employee_ID ,employee_NAME , employee_salary ) VALUES ( ?, ?, ?)";

	@Override
	public Employee getEmployeeById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_ITEM, new Object[] { id },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(SQL_GET_ALL_ITEMS, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public void deleteEmployee(int id) {
		jdbcTemplate.update(SQL_DELETE_ITEM, id);
	}

	@Override
	public void updateEmployee(Employee item) {
		jdbcTemplate.update(SQL_UPDATE_ITEM, item.getEmployee_name(), item.getEmployee_salary(), item.getEmployee_id());
	}

	@Override
	public void createEmployee(Employee item) {
		jdbcTemplate.update(SQL_INSERT_ITEM, item.getEmployee_id(), item.getEmployee_name(), item.getEmployee_salary());

	}

}
