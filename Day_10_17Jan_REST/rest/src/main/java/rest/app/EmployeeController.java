package rest.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.dao.EmployeeDAO;
import rest.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO itemDAO ;
	
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return itemDAO.getEmployeeById(id) ;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return itemDAO.getAllEmployees() ;
	}

	@PostMapping("/employee")
	public void createEmployee(@RequestBody Employee item) {
		itemDAO.createEmployee(item);
	}
	
	@PutMapping("/employee")
	public void updateEmployee(@RequestBody Employee item) {
		itemDAO.updateEmployee(item);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteSPCard( @PathVariable int id) {
		itemDAO.deleteEmployee(id);
	}

}
