package oopsPackage;

import java.util.ArrayList;

abstract class Employee{
	private String name;
	private int id;
	
	public Employee(String name, int id) {
		this.name=name;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public int getId(){
		return id;
	}
	
	public abstract double calculateSalary();
 
	@Override 
	
	public String toString() {
	return "Empolyee[name="+name+",id="+id+",salary="+calculateSalary()+"]";	
	}
}

class FullTimeEmployee extends Employee{
public FullTimeEmployee(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

private double monthlySalary;

public FullTimeEmployee(String name, int id,double monthlySalary) {
	super(name,id);
	this.monthlySalary=monthlySalary;
}

   @Override
   
   public double calculateSalary() {
	   return monthlySalary;
   }
}

class PartTimeEmployee extends Employee{
private int hourWorked;
private  double hourRate;

public PartTimeEmployee(String name, int id, int hourWorked,double hourRate) {
	super(name,id);
	this.hourWorked=hourWorked;
	this.hourRate=hourRate;
}
@Override

public double calculateSalary() {
	return hourWorked*hourRate;
}
}

class PayrollSystem{
	private ArrayList<Employee> employeeList;
	
	public PayrollSystem() {
	employeeList=new ArrayList<>();	
	}
	
	public void addEmployee(Employee employee) {
	 employeeList.add(employee);	
	}
	
	public void removeEmployee(int id) {
		Employee employeeToRemove=null;
		
		for(Employee employee:employeeList) {
			if(employee.getId()==id) {
				employeeToRemove=employee;
				break;
			}
		}
		if (employeeToRemove!=null) {
			employeeList.remove(employeeToRemove);
		}
	}
	public void displayEmployee() {
		for(Employee employee: employeeList) {
			System.out.println(employee);
		}
	}
	
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  PayrollSystem payrollSystem= new PayrollSystem();
  
  
FullTimeEmployee emp1= new FullTimeEmployee("vikas",1,70000.0);

PartTimeEmployee emp2= new PartTimeEmployee ("alex",2,40,100);

payrollSystem.addEmployee(emp1);
payrollSystem.addEmployee(emp2);
System.out.println("initial Employee Deatials:");
payrollSystem.displayEmployee();
System.out.println("Removing Employee");
payrollSystem.removeEmployee(2);
System.out.println("Remaining Employee Details:");
payrollSystem.displayEmployee();
	}
	

}
				