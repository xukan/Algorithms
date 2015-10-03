package com.xk;

public class Solution {
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0||strs == null)
            return "";
            
        for(int i = 0; i<strs[0].length(); i++){
            char x = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(strs[j].length() == i || strs[j].charAt(i) != x)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
	
	public static void main(String[] args){
		String[] input = {"iloveuhow", "iloveuuloveme", "iloveuu", "iloveuhi", "iloveusomuch"};
		String res = longestCommonPrefix(input);
		System.out.println(res);
	}
}
