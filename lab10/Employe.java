package lab10;
import java.util.logging.Logger;

public class Employe {
	private static final Logger logger = Logger.getLogger(Employe.class.getName());
	private String name;
	private double salary;

	public Employe(String name, double initialSalary) {
		this.name = name;
		this.salary = initialSalary;
		logger.info( name + " has initial salary of " + initialSalary);
	}

	public void updateSalary(double newSalary) {
		logger.info("old salary is " + salary);
		salary += newSalary;
		logger.info("new salary is " + salary);
	}

	public double getSalary() {
		return salary;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String arg[]) {
		
		Employe employee = new Employe("Manas" , 2000.24);
		employee.updateSalary(400);
		
		System.out.println(employee.getSalary());
	}
}
