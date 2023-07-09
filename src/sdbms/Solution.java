package sdbms;

import java.util.Scanner;

import customException.IvvaliedChoiceExceptionn;

public class Solution 
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Student Database Management");
		System.out.println("======================================");
		Scanner ip = new Scanner(System.in);
		StudentManagementSystem sms = new StudentManagementSystemimpl();
		while(true)
		{
			System.out.println("1.AddStudent\n2.DisplayStudent\n3.Display all Student\n4.Remove Student\n5.RemoveAll Student");
			System.out.println("6.UpdateStudent\n7.Count Student\n8.Sort Student\n9.GetStudentWithHighestMarks\n10.GetStudentWithHighestMarks\n11.Exit");
			System.out.println("Enter your Choice");
			int choice = ip.nextInt();
			switch(choice)
			{
			case 1:
				  sms.addStudent();
				break;
			case 2: 
				 sms.displayStudent();
				break;
			case 3: 
				sms.displayAllStudents();
				break;
			case 4: 
				sms.removeStudent();
				break;
			case 5: 
				sms.removeAllStudents();
				break;
			case 6: 
				sms.updateStudent();
				break;
			case 7: 
				sms.countStudents();
				break;
			case 8: 
				sms.sortStudent();
				break;
			case 9: 
				sms.getStudentWithHighestMarks();
				break;
			case 10: 
				sms.getStudentWithLowestMarks();
				break;
			case 11: 
			      System.out.println("Thank You...!");
				  System.exit(0);
			default :
				try
				{
					String mssg ="Invalied Choice, Kindly Enter Valied Choice";
					throw new  IvvaliedChoiceExceptionn (mssg);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			
			}
		}
	}

}
