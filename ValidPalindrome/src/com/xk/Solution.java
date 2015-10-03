package com.xk;

public class Solution {
	public static boolean isValidPalindrome(String s){
<<<<<<< HEAD
//		if(s==null) return false;
//		if(s.length()==0) return true;
//		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//		System.out.println(s);
// 
//		for(int i = 0; i < s.length() ; i++){
//			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
//				return false;
//			}
//		}
// 
//		return true;
		if(s.length() == 0)
            return true;
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0, j=s.length()-1;
        while(i<j-i){
            char a = s.charAt(i);
            char b = s.charAt(j-i);
            if(a == b)
                i++;
            else
                return false;
        }
        return true;
=======
		if(s==null) return false;
		if(s.length()==0) return true;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
 
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
 
		return true;
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	}
 
	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
 
		System.out.println(isValidPalindrome(str));
	}
}
