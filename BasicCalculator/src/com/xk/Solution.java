package com.xk;

import java.util.*;

public class Solution {
	//two stacks solution:
//	public int calculate(String s) {
//        if(s == null || s.length() == 0)
//        	return 0;
//        char[] arr = s.toCharArray();
//        Stack<Integer> num = new Stack<Integer>();
//        Stack<Character> operator = new Stack<Character>();
//        int currnum = 0;
//        
//        for(int i=0;i<s.length();i++){
//        	char c = arr[i];
//        	switch(c){
//        	case ' ':
//        		continue;
//        	case '+': case '-': case '(' : {
//        		operator.push(c);
//        		continue;
//        		}
//        	case ')':
//        		operator.pop();
//        		break;
//        	}
//        	if( Character.isDigit(c)){
//        		currnum = currnum*10 + c - '0';
//        		if(i+1<arr.length && Character.isDigit(arr[i+1]))
//        			continue;
//        		num.push(currnum);
//        		currnum = 0;
//        	}
//        	if(operator.empty() || operator.peek() == '(')
//        		continue;
//        	int num2 = num.pop();
//        	int num1 = num.pop();
//        	char ope = operator.pop();
//        	switch(ope){
//        	case '+':
//        		num.push(num1+num2);
//        		break;
//        	case '-':
//        		num.push(num1-num2);
//        		break;
//        	}
//        }
//        return num.pop();
//       
//	}
	
	//infix to postfix solution:
	public static int calculate(String s) {
        Stack<Character> stack = new Stack<Character>();
        List<Object> postfix = new ArrayList<Object>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + s.charAt(++i)-'0';
                }
                postfix.add(num);
            }
            switch(c){
                case ')':{
                    while(!stack.empty() && stack.peek()!='('){
                        postfix.add(stack.pop());
                    }
                    stack.pop();
                    }break;
                case '(': 
                    stack.push(c);
                    break;
                case '+': case '-':{
                	if(stack.empty())
                		stack.push(c);
                	else{
                		if(stack.peek()!='(')
                			postfix.add(stack.pop());
                		stack.push(c);
                	}
                }
                case ' ':
                    continue;
            }
        }
        while(!stack.empty())
        	postfix.add(stack.pop());
        for(Object ss:postfix)
        	System.out.print(ss);
        System.out.println();
        int res = getValue(postfix);
        return res;
    }
    
    public static int getValue(List<Object> postfix){
        int res = 0;
        int a=0, b=0;
        Stack<Integer> stack = new Stack<Integer>();
        for(Object obj : postfix){
            if(obj instanceof Character){
                char c = (Character) obj;
                if(!stack.empty()){
                    a = stack.pop();
                    b = stack.pop();
                }
                switch(c){
                    case '+':
                        stack.push(a+b);
                        break;
                    case '-':
                        stack.push(b-a);
                        break;
                }
            }else
                stack.push((Integer)obj);
        }
        return stack.pop();
    }
	
	public static void main(String[] args) {
//        String input = "1+1-(3-10)+2";
		String input = "2-1+2";
        Solution s = new Solution();
        int res = s.calculate(input);
        System.out.println(res);
	}
    
}
