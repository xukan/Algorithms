package com.xk;

import java.util.*;

public class ConvertToTitle {
	public String convertToTitle(int n) {
//		List<Integer> result=new LinkedList<Integer>();
		Stack<Integer> stack=new Stack<Integer>();
        for(int j=n%26;j>0;){
        	int i=n/26;
        	n=i;
        	stack.push(j);
        	if(i<26){
        		stack.push(i);
        		break;
        	}
        }
        String line="";
        for(int m=0;m<stack.size();m++){
        	int num=stack.pop();
        	char x;
        	x=(char)(num+65);
        	line+=x;
        }
        return line;
    }
	public static void main(String [] args){
		int input=52;
		ConvertToTitle me=new ConvertToTitle();
		String output=me.convertToTitle(input);
		System.out.println(output);
	}
}
