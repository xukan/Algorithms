package com.xk;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	int id;
	String name;
	int age;
	
	public Employee(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Employee e){
		return this.age-e.age;
	}
	
	public static Comparator<Employee> comp = new Comparator<Employee>(){
		 public int compare(Employee e1, Employee e2) {
			 
		      String name1 = e1.name.toUpperCase();
		      String name2 = e2.name.toUpperCase();
	 
		      //ascending order
		      return name1.compareTo(name2);

		 }
	};//注意这里要加分号的
}

/*
 * Comparable

 * A comparable object is capable of comparing itself with another object. 
 * The class itself must implements the java.lang.Comparable interface 
 * in order to be able to compare its instances. 
 * 
 * java.lang.Comparable: int compareTo(Object o1)
 * This method compares this object with o1 object. Returned int value has the following meanings.
 * positive – this object is greater than o1
 * zero – this object equals to o1
 * negative – this object is less than o1
 * 
 * */
 