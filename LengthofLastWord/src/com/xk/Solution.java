package com.xk;

public class Solution {
	public int lengthOfLastWord(String s) {
//        if(s == null || s.length() == 0)
//            return 0;
//        int count = 0;
//        for(int i=s.length()-1;i>=0;i--){
//            if(s.charAt(i) != ' ')
//                count++;
//            if(s.charAt(i) == ' ')
//                return count;
//        }
//        return count;
		String[] a = s.split(" ");
		if(a.length == 0 || a== null)
			return 0;
		return a[a.length-1].length();
    }
	
	public static void main(String[] args){
		String input= "a ";
		Solution s = new Solution();
		int res = s.lengthOfLastWord(input);
		System.out.println(res);
	}
}
