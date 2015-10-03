package com.xk;

import java.util.*;
//����������֮������stack�д洢�����±꣬���������ţ������ͷ�����㳤���ˣ�����
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
	    		if(stack.empty()){//������������")"ʱ��start��λ����Ҫ����
	    			start = i+1;
	    		}else{
	    			stack.pop();
	    			if(stack.empty())//ջΪ�գ�˵����ǰ���ֵ����ŶԶ���ƥ��ģ���i-start+1���㳤��
	    				maxlen = Math.max(maxlen, i-start+1);
	    			else//ջ��Ϊ�գ�˵���е����ġ�(��
	    				maxlen = Math.max(maxlen, i-stack.peek());//ע�����ﲻ��Ҫ�ټ�1����Ϊջ�������ֱȵ���ȥ��С���൱���Ѿ��ӻ�����
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
