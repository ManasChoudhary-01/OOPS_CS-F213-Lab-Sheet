package lab12;
import java.io.*;
import java.util.Scanner;

public class WriteExample {
    public static void main(String[] args) {        
//        try {
//        	PrintWriter outStream = new PrintWriter("data.txt");
//        	
//        	outStream.println("Hellow world");
//        	outStream.println(123);
//        	outStream.println(12.45);
//        	
//        	outStream.close();
//        	System.out.println("Text file created");
//        } catch(IOException e) {
//        	e.printStackTrace();
//        }
        
//        try {
//        	PrintWriter outStream = new PrintWriter(new FileOutputStream("data.txt", true));
//        	
//        	outStream.println("New line added");
//        	outStream.println(14);
//        	
//        	outStream.close();
//        	System.out.println("Text appended");
//        } catch(IOException e) {
//        	e.printStackTrace();
//        }
        
//        try {
//        	Scanner sc = new Scanner(new FileInputStream("data.txt"));
//        	
//        	while(sc.hasNext()) {
//        		String name = sc.next();
//        		int marks = sc.nextInt();
//        		System.out.println(name + " : " + marks);
//        	}
//        	
//        	sc.close();
//        } catch(IOException e) {
//        	e.printStackTrace();
//        }
    	
//    	try {
//            PrintWriter outStream = new PrintWriter(new FileOutputStream("students.csv"));
//
//            outStream.println("Name,Age,Marks");
//            outStream.println("John,20,85");
//            outStream.println("Alice,22,90");
//            outStream.println("Bob,19,70");
//
//            outStream.close();
//            System.out.println("CSV created!");
//        } catch (IOException e) {
//            System.out.println("File Error: " + e.getMessage());
//        }
    	
//    	try {
//            PrintWriter outStream = new PrintWriter(new FileOutputStream("students.csv", true));
//
//            outStream.println("David,21,88");
//
//            outStream.close();
//            System.out.println("Row appended!");
//        } catch (IOException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
    	
    	try {
            Scanner sc = new Scanner(new FileInputStream("students.csv"));
            sc.nextLine();  // skip header

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");  
                
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int marks = Integer.parseInt(data[2]);

                System.out.println(name + " " + age + " " + marks);
                
            }

            sc.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
