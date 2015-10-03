package com.xk;

import java.util.*;

public class Solution {
	public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n==0)
            return res;
        StringBuilder item = new StringBuilder();
        //String item ="";
        helper(res, item,  n, n);
        return res;
    }
	
    public static void helper(List<String> res, StringBuilder item, int numofLeftParen, int numofRightParen){
        if(numofLeftParen>numofRightParen)//deal wiith ")("
            return;
        if(numofLeftParen ==0 && numofRightParen ==0){
            res.add(item.toString());
            return;
        }
        if(numofLeftParen > 0)
            helper(res, item.append('('), numofLeftParen-1, numofRightParen);
        if(numofRightParen >0)
            helper(res, item.append(')'), numofLeftParen, numofRightParen-1);
    }
	
	public static void main(String[] args){
		List<String> res = generateParenthesis(3);
		for(String str: res)
			System.out.println(str);
	}
}
