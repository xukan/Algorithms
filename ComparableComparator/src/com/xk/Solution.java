package com.xk;

import java.util.*;

public class Solution {
	public static void print(List<Employee> list){
		for(Employee e:list)
			System.out.println("id: "+e.id+" "+"name: "+e.name+" "+"age: "+e.age+" ");
	}
	
	public static void main(String[] args){
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(5, "Frank", 28)); 
		list.add(new Employee(1, "Jorge", 19)); 
		list.add(new Employee(6, "Bill", 34)); 
		list.add(new Employee(3, "Michel", 10)); 
		list.add(new Employee(7, "Simpson", 8)); 
		list.add(new Employee(4, "Clerk",16 )); 
		list.add(new Employee(8, "Lee", 40)); 
		list.add(new Employee(2, "Mark", 30));
		System.out.println("Test of Comparable:(sorted by age)");
		Collections.sort(list);
		print(list);
		System.out.println("Test of Comparator:(sorted by name)");
		Collections.sort(list, Employee.comp);
		print(list);
	}
}
