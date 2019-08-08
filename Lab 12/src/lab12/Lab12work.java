package lab12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This Class should read in the students from the students.in file and store them in a
 * BST based on GPA
 * @author Jacob Coriell
 */

public class Lab12work {
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Lab12work obj = new Lab12work();
		obj.read();
	}
	
		
	public void read() throws FileNotFoundException {	
		int id = 0;
		String name = null;
		double gpa = 0.0;
		String advisor = null;
		StudentGPA student;
		int numStudents = 0;
		StudentGPA[] stuarray;
		
		BinarySearchTree<String> myTree = new BinarySearchTree<String>();
		
		Scanner reader1 = new Scanner(new FileInputStream("students.in"), "UTF-8");
		
		while(reader1.hasNextLine()) {
			numStudents++;
			reader1.nextLine();
		}
		
		stuarray = new StudentGPA[numStudents];
		Scanner reader2 = new Scanner(new FileInputStream("students.in"), "UTF-8");
		
		while(reader2.hasNext()) {
				int x = 0;
				id = reader2.nextInt();
				name = reader2.next();
				gpa = reader2.nextDouble();
			
				if (reader2.hasNextInt()) {
				student = new StudentGPA(id,name,gpa);
				stuarray[x] = student;
				x++;
				}
			
				else if (!reader2.hasNext()) {
				student = new StudentGPA(id,name,gpa);
				stuarray[x] = student;
				x++;
				
				}
			
				else {
				advisor = reader2.next();
				GraduateStudentGPA grad = new GraduateStudentGPA(id,name,gpa,advisor);
				stuarray[x] = grad;
				
				//System.out.println(stuarray[x].GPA);
				x++;
				}
		}
		
		insertToTree(stuarray);
		
		reader2.close();
	}
	
	public void insertToTree(StudentGPA[] stu) {
		//WIP
		for(int x = 0; x < 9; x++) {
			System.out.println(stu[x].GPA);
		}
	}
}
