package com.xk;

import java.util.*;

public class happyNumber {
	public static boolean isHappy(int n){
		Set<Integer> process = new HashSet<Integer>();
		while(n!=1){
			int sum=0;
			while(n!=0){
				int m=n%10;	
				n/=10;
				sum+=m*m;
			}
			if(process.contains(sum))
				return false;
			n=sum;
			process.add(n);
		}
		return true;
	}
	public static void main(String [] args){
		boolean x=isHappy(19);
		System.out.println(x);
	}
}
