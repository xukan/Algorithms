package com.xk;

public class Solution {
//	public String shortestPalindrome(String s) {  
//        if(s.length()<=1 ) return s;  
//        int center = (s.length()-1)/2;  
//        String res="";  
//        for(int i=center; i>=0; i--) {  
//            if(s.charAt(i) == s.charAt(i+1)) {  
//                if( (res = check1(s, i, i+1)) !=null) return res;  
//            }  
//            if( (res = check1(s, i, i)) !=null) return res;  
//  
//        }  
//        return res;  
//    }  
//    //aabaac  
//    private String check1(String s, int l, int r) {  
//        int i=1;  
//        for(; l-i>=0; i++) {  
//            if(s.charAt(l-i) != s.charAt(r+i) ) break;  
//        }  
//          
//        if(l-i>=0) return null;   
//        StringBuilder sb = new StringBuilder(s.substring(r+i));  
//        sb.reverse();  
//        return sb+s; 
//    }
    
	public String shortestPalindrome(String word) {
		if(word.length()<= 1)
			return word;
		int len = word.length();
		int center = (len-1)/2;
		String res = "";
		for(int i=center;i>=0;i--){
			if(word.charAt(i) == word.charAt(i+1)){
				if((res = scanFromCenter(word, i, i+1)) !=null)
					return res;
			}//如果目前中点旁边的左右一对中出现了不相等的， 那么就还是要左移中点，比如abcbd,c的左右第一对是b,b,接着发现下一对是a,d，不相等，
			 //左移中点,最后中点移到了a
			if((res = scanFromCenter(word, i, i)) !=null)
				return res;
		}
		return res;
	}
	
	public String scanFromCenter(String s, int l, int r){
		int i=1;
		for(;l-i>=0;i++)
			if(s.charAt(l-i)!=s.charAt(r+i))
				break;
		if(l-i>=0)
			return null;
		StringBuilder str = new StringBuilder(s.substring(r+i));
		str.reverse();
		return str+s;
	}
	
    public static void main(String[] args) {
        String word = "abcbd";
        Solution s = new Solution();
        String shortestPalindrome = s.shortestPalindrome(word);
        System.out.println(shortestPalindrome);
    }
}
