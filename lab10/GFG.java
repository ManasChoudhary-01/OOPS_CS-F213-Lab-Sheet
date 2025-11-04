package lab10;
import java.util.*;

class Student {
	int rollno;
	String name;
	
	public Student(int rollno,String name) {
		this.rollno = rollno;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return rollno + ":" + name;
	}
}

class SortbyRoll implements Comparator<Student> {
	public int compare(Student a, Student b) {
		return a.rollno - b.rollno;
	}
}

class SortbyName implements Comparator<Student> {
	public int compare(Student a , Student b ) {
		return a.name.compareTo(b.name);
	}
}
public class GFG {

	public static void main(String args[]) {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(131, "Manas"));
		students.add(new Student(121, "Rohan"));
		students.add(new Student(140, "Nishit"));
		students.add(new Student(141, "Nishim"));
		
		Collections.sort(students, new SortbyRoll());
		
		for(int i=0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
		
		System.out.println(" ");
		
		Collections.sort(students, new SortbyName());
		
		for(int i=0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
	}
}
