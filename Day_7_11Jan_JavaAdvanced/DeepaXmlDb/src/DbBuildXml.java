import java.sql.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.*;

public class DbBuildXml {

	Class<?> driverClass = null;
	Connection con = null;
	DocumentBuilder dBuilder = null;

	DbBuildXml() {
		try {

			// jdbc
			driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "root");
			dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

	public static void main(String[] args) {

		try {

			DbBuildXml dbBuilder = new DbBuildXml();

			if (args.length == 1 && args[0].equalsIgnoreCase("export")) {
				// xml parsing
				File empFile = new File("src/employees.xml");
				File deptFile = new File("src/depatments.xml");

				dbBuilder.parseDepartments(deptFile);
				dbBuilder.parseEmployees(empFile);
				
			} else if (args.length == 1 && args[0].equalsIgnoreCase("import")) {
				
				dbBuilder.createEmployeeXML();
				dbBuilder.createDepartmentXML();
						
			}
			else {
				System.out.println("wrong option");
			}
			dbBuilder.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// used for closing the db connections
	void closeConnection() throws SQLException {
		con.close();
	}

	// parses department xml file and stores in db
	List<Department> parseDepartments(File file) throws Exception {

		PreparedStatement ps = con.prepareStatement("insert into employee.dept values(?, ?)");
		Document doc = dBuilder.parse(file);	
		List<Department> depts = new ArrayList<Department>();
		NodeList nodeList = doc.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				Integer ID = Integer
						.parseInt(elem.getElementsByTagName("Id").item(0).getChildNodes().item(0).getNodeValue());
				String name = elem.getElementsByTagName("Name").item(0).getChildNodes().item(0).getNodeValue();
				depts.add(new Department(ID, name));

				// inserting into dept
				ps.setInt(1, ID.intValue());
				ps.setString(2, name);

				ps.executeUpdate();
			}
		}

		System.out.println(depts);
		ps.close();

		return depts;
	}

	// parses given employee xml file and stores in db
	List<Employee> parseEmployees(File file) throws Exception {

		PreparedStatement ps = con.prepareStatement("insert into employee.emp values(?, ?, ?, ?)");
		Document doc = dBuilder.parse(file);
		List<Employee> employees = new ArrayList<Employee>();
		NodeList nodeList = doc.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				Integer ID = Integer
						.parseInt(elem.getElementsByTagName("Id").item(0).getChildNodes().item(0).getNodeValue());
				String name = elem.getElementsByTagName("Name").item(0).getChildNodes().item(0).getNodeValue();
				Long salary = Long
						.parseLong(elem.getElementsByTagName("Salary").item(0).getChildNodes().item(0).getNodeValue());
				Integer deptID = Integer.parseInt(
						elem.getElementsByTagName("DepartmentId").item(0).getChildNodes().item(0).getNodeValue());
				employees.add(new Employee(ID, name, salary, deptID));

				// inserting into db
				ps.setInt(1, ID.intValue());
				ps.setString(2, name);
				ps.setInt(3, salary.intValue());
				ps.setInt(4, deptID.intValue());

				ps.executeUpdate();
			}
		}

		System.out.println(employees);
		ps.close();
		return employees;

	}

	// creates employee xml taking emp data from db
	List<Employee> createEmployeeXML() throws Exception {
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select id,ename,salary,deptId from employee.emp");
		List<Employee> employees = new ArrayList<Employee>();
		Document doc = dBuilder.newDocument();

		while (rs.next()) {
			Integer id = rs.getInt(1);
			String name = rs.getString(2);
			Long salary = rs.getLong(3);
			Integer deptID = rs.getInt(4);

			employees.add(new Employee(id, name, salary, deptID));
		}

		Element rootEle = doc.createElement("Employees");
		doc.appendChild(rootEle);

		employees.stream().forEach((emp) -> rootEle.appendChild(getEmployeeNode(doc, emp)));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);

		// writing to file
		StreamResult file = new StreamResult(new File("src/emp.xml"));
		transformer.transform(source, file);

		s.close();
		return employees;
	}

	// creates dept xml taking dept data from table
	List<Department> createDepartmentXML() throws Exception {
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select id,ename,salary,deptId from employee.emp");
		List<Department> depts = new ArrayList<Department>();
		Document doc = dBuilder.newDocument();

		while (rs.next()) {
			Integer id = rs.getInt(1);
			String name = rs.getString(2);

			depts.add(new Department(id, name));
		}

		Element rootEle = doc.createElement("Departments");
		doc.appendChild(rootEle);

		depts.stream().forEach((dept) -> rootEle.appendChild(getDepartmentNode(doc, dept)));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);

		// writing to file
		StreamResult file = new StreamResult(new File("src/dept.xml"));
		transformer.transform(source, file);

		s.close();
		return depts;
	}

	Node getEmployeeNode(Document doc, Employee emp) {
		Element employee = doc.createElement("Employee");
		employee.appendChild(getElementNode(doc, employee, "Id", emp.id.toString()));
		employee.appendChild(getElementNode(doc, employee, "Name", emp.name));
		employee.appendChild(getElementNode(doc, employee, "Salary", emp.salary.toString()));
		employee.appendChild(getElementNode(doc, employee, "DepartmentId", emp.deptID.toString()));

		return employee;
	}

	Node getDepartmentNode(Document doc, Department dept) {
		Element department = doc.createElement("Department");
		department.appendChild(getElementNode(doc, department, "Id", dept.id.toString()));
		department.appendChild(getElementNode(doc, department, "Name", dept.deptName));

		return department;
	}

	// utility method to create text node
	private static Node getElementNode(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

}
