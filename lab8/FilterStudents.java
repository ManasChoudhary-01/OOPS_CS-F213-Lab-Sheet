package lab8;
import java.util.*;
import java.util.function.*;

class Student {
	String name;
	int marks;
	
	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class FilterStudents {
	
	public static void main(String arg[]) {
		
		List<Student> students = Arrays.asList(
				new Student("Manas", 80),
				new Student("Nishit", 50),
				new Student("Saakshi", 40),
				new Student("Tarun", 90),
				new Student("Rushil", 99)
		);
		
		Predicate<Student> hasHighScore = student -> student.marks > 70;
	    students.stream().filter(hasHighScore).forEach(s -> System.out.println(s.name));
	}

}
