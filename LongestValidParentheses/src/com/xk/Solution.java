package com.xk;

import java.util.*;
//这道题的巧妙之处在于stack中存储的是下标，而不是括号，这样就方便计算长度了！！！
public class Solution {
	public static int longestValidParentheses(String s) {
		if(s==null || s.length()==0)
	        return 0;
	    //LinkedList<Integer> stack = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
	    int start = 0;
	    int maxlen= 0;
	    for(int i=0;i<s.length();i++){
	    	if(s.charAt(i)=='(')
	    		stack.push(i);
	    	else{
	    		if(stack.empty()){//当遇到单独的")"时，start的位置需要调整
	    			start = i+1;
	    		}else{
	    			stack.pop();
	    			if(stack.empty())//栈为空，说明当前出现的括号对都是匹配的，用i-start+1计算长度
	    				maxlen = Math.max(maxlen, i-start+1);
	    			else//栈不为空，说明有单独的“(”
	    				maxlen = Math.max(maxlen, i-stack.peek());//注意这里不需要再加1，因为栈顶的数字比弹出去的小，相当于已经加回来了
	    		}
	    	}
	    }
	    return maxlen;
	}
	
	public static void main(String[] args){
		String input = "())((())";
		int res = longestValidParentheses(input);
		System.out.println(res);
	}
}
