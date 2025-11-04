package lab9;
import java.util.*;

public class University {

	private String universityName;
	
	private List<Student> students = new ArrayList<>();
	
	public University(String universityName) {
		this.universityName = universityName;
	}
	
	public void addStudent(String name, int id) {
		students.add(new Student(name, id));
	}
	
	public void list_students() {
		System.out.println("University : " + universityName);
		System.out.println(" ");
		System.out.println("Student Records:");
		
		for(Student s : students) {
			// System.out.println(s.studentId + " : " + s.studentName);
			s.display();
		}
	}
	
	class Student {
		String studentName;
		int studentId;
		
		public Student(String name, int id) {
			this.studentName = name;
			this.studentId = id;
		}
		
		public void display() {
			System.out.println(studentId + " : " + studentName);
		}
	}
	
	public static void main(String arg[]) {
		University oxf = new University("Oxford University");
		oxf.addStudent("Manas Choudhary", 1342);
		oxf.addStudent("Saakshi Singh", 1302);
		oxf.list_students();
	}
}
