
public class Department {
	
	Integer id;
	String deptName;
	
	public Department(Integer id, String deptName) {
		this.id = id;
		this.deptName = deptName;
	}
	
	public String toString()
	{	
		return this.deptName+" "+this.id.intValue();
	}
} 
