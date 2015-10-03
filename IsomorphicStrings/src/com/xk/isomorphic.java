package com.xk;

import java.util.*;

public class isomorphic {
	public static boolean isIsomorphic(String s, String t) {
        if(s.length()==0&&t.length()==0)
        	return true;
        if(s.length()!=t.length())
        	return false;
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        for(int i=0;i<s.length();i++){
        	char c1 = s.charAt(i);
        	char c2 = t.charAt(i);
        	if(map1.containsKey(c1)){
        		 if(map1.get(c1)!=c2)
        			 return false;
        	}else{
        		map1.put(c1, c2);
        		if(map2.containsKey(c2)){
        			if(map2.get(c2)!=c1)
        				return false;
        		}
        		map2.put(c2, c1);
        	}
        }
        return true;
    }
	public static void main(String [] args){
		String s = "egg";
		String t = "add";
		String s1 = "title";
		String t1 = "paper";
		
		boolean answer = isIsomorphic(s1, t1);
		System.out.println(answer);
	}
}
