package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customException.IvvaliedChoiceExceptionn;
import customException.StudentNotFoundException;

import customSorting.SortStudentByAge;
import customSorting.SortStudentById;
import customSorting.SortStudentByMarks;
import customSorting.SortStudentByName;

public class StudentManagementSystemimpl implements StudentManagementSystem {
Scanner sc= new Scanner(System.in);
Map<String,Student> db = new LinkedHashMap<String,Student>();
	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Student Age:");
		int age = sc.nextInt();
		System.out.println("Enter the Student Name:");
		String sname=sc.next();
		System.out.println("Enter the Student Marks:");
		int marks = sc.nextInt();
		Student std=new Student(age,sname,marks);
		db.put(std.getId(), std);
		System.out.println("Student Records Entered Sucessfully!");
		System.out.println("Student Id is "+std.getId());
		
	}

	@Override
	public void displayStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Student ID:");
		String id=sc.next();// String name= sc.next().toUpperCase();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student std =db.get(id);//getting the Student Object 
			System.out.println("Id: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());
			// System.out.println(std); as toString is Overridden
		}
		else {
			try {
				String message ="Student with the Id"+id+" is not found!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void displayAllStudents() {
		// TODO Auto-generated method stub
		if(db.size()!=0) {
			System.out.println("Student Details are as follows");
			System.out.println("------------------------------");
			Set <String>keys = db.keySet(); // JSP101   JSP102   JSP103
			for(String key: keys) {
				Student std = db.get(key);
				System.out.println(std); // System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message = "Student Database is Empty, nothing to display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void removeStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Id");
		String id = sc.next().toUpperCase();
		if (db.containsKey(id)) {
			System.out.println("Student Record Found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student Record Deleted Sucessfully");
		}
		else {
			try {
				String message ="Student with the Id"+id+" is not found!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudents() {
		// TODO Auto-generated method stub
		if(db.size()!=0) {
			System.out.println("Student Records Available: "+db.size());
			db.clear();
			System.out.println("All Student Record Deleted Successfully!");
			System.out.println("Student Records Available: "+db.size());
		}
		else {
			try {
				String message ="Student database management is empty, nothing to delete!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Id of the Student that is to be Updated!");
		String id = sc.next().toUpperCase();
		
		if (db.containsKey(id)) {
			Student std = db.get(id);
			System.out.println("1:Update Age\n2:Update Name\n3:Upadte Marks");
			System.out.println("Enter the Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age = sc.nextInt();
				std.setAge(age);// std.setAge(sc.nextInt());
				break;
			case 2:
				System.out.println("Enter Name");
				String name = sc.nextLine();
				std.setName(name);// std.setSname(sc.nextLine());
				break;
			case 3:
				System.out.println("Enter marks");
				int marks = sc.nextInt();
				std.setMarks(marks);// std.setMarks(sc.nextInt());
				break;
				
				default :
					try {
						String message ="invalid choice, kindly enter valid choice";
						throw new IvvaliedChoiceExceptionn(message);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
			}
		}
			else {
				try {
					String message ="Student with the Id"+id+" is not found!";
					throw new StudentNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
	}

	@Override
	public void countStudents() {
		// TODO Auto-generated method stub
		System.out.println("no of Student Records: "+db.size());
		
	}

	@Override
	public void sortStudent() {
		// TODO Auto-generated method stub
		Set <String>keys= db.keySet();
		List<Student>list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		System.out.println("1: Sort by Id\n2. Sort by Age");
		System.out.println("3. Sort by Name\n4. Sort by Marks");
		System.out.println("Please enter the choice");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new SortStudentById());
			display(list);
			break;
		case 2:
			Collections.sort(list,new SortStudentByAge());
			display(list);
			break;
		case 3:
			Collections.sort(list,new SortStudentByName());
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortStudentByMarks());
			display(list);
			break;
		default:
			try {
				String message ="invalid choice, kindly enter valid choice";
				throw new IvvaliedChoiceExceptionn(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	private static void display (List <Student>list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		// TODO Auto-generated method stub
		Set <String> keys = db.keySet();
		List<Student>list = new ArrayList<Student>();
		for(String key : keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(list.size()-1));
	}

	@Override
	public void getStudentWithLowestMarks() {
		// TODO Auto-generated method stub
		Set <String> keys = db.keySet();
		List<Student>list = new ArrayList<Student>();
		for(String key : keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(0));
		
		
	}

}