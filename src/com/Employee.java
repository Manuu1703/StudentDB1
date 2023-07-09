package com;

public class Employee 
{
String id;
String name;

 static int count = 1;
public Employee(String name)
{
	this.id = "A"+count;
	this.name = name;
	count++;
}
public static void main(String[] args) 
{
	Employee e1 = new Employee("Tom");
	System.out.println(e1.id+" "+e1.name);//A101 Tom
	Employee e2 = new Employee("Jack");
	System.out.println(e2.id+" "+e2.name);//A101 Tom
	Employee e3 = new Employee("Smith");
	System.out.println(e3.id+" "+e3.name);//A101 Tom
}

}
