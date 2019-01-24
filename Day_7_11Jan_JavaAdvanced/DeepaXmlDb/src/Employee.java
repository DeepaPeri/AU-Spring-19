
public class Employee 
{
	Integer id;
	String name;
	Long salary;
	Integer deptID;
	
	public Employee(Integer id, String name, Long salary, Integer deptID) 
	{
		this.deptID = deptID;
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	public String toString(){
		
		return this.name+" "+this.id.toString()+" "+this.salary.toString()+" "+this.deptID.toString();
	}
}
