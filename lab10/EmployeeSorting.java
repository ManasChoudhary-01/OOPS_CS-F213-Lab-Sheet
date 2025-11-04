package lab10;
import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String fname;
    String lname;
    double salary;
    String name;

    public Employee(int id, String fname, String lname, double salary) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.name = fname + " " + lname;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }

    @Override
    public String toString() {
        return id + " - " + name + " - $" + salary;
    }
}

class FirstNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.fname.compareTo(e2.fname);
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int FirstComp = e1.fname.compareTo(e2.fname);
        
        if(FirstComp == 0) {
        	return e1.lname.compareTo(e2.lname);
        }
        
        return FirstComp;
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
    	
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "Jones", 50000));
        employees.add(new Employee(2, "Manas", "Choudhary", 40000));
        employees.add(new Employee(3, "Nishit", "Garg", 3000));
        employees.add(new Employee(4, "Manas", "Jon", 100));

        System.out.println("Sorted by salary (Natural Order):");
        Collections.sort(employees);
        System.out.println(employees);

        Collections.sort(employees, new FirstNameComparator());
        System.out.println("Sorted by name (Custom Order):");
        System.out.println(employees);
        
        Collections.sort(employees, new NameComparator());
        System.out.println("Sorted by name (Custom Order):");
        System.out.println(employees);
    }
}

