package com.xk;

import java.util.*;

public class Solution {
	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
			
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
<<<<<<< HEAD
			//if (map.keySet().contains(curr))
			if(map.containsKey(curr)){
=======
			if (map.keySet().contains(curr)) {
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.empty();
	}
	
	public static void main(String[] args){
		String input= "{{([])}}";
		boolean flag = isValid(input);
		System.out.println(flag);
	}
}
