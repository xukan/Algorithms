package com.xk;

public class Solution {
	
	private String text;
	private String pattern;
	
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
			
	public void KMPMatcher() {
		int n = text.length();
		int m = pattern.length();
		
		int prefix[] = computePrefix();
		int q = 0;
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			
			while(q > 0 && pattern.charAt(q)!= text.charAt(i)) {
				q = prefix[q -1];
			}
			
			if(pattern.charAt(q) == text.charAt(i))
				q++;
			
			if(q == m) {
				System.out.println("Pattern occurs with shift  " + ++count + "times");
				q = prefix[q - 1];
			}
		}
		
		if(count == 0) {
			System.out.println("There is no matcher!");
		}
	}
	
	private int[] computePrefix() {
		int length = pattern.length();
		int[] prefix = new int[length];
		
		prefix[0] = 0;
		
		int k = 0;
		for(int i = 1; i < length; i++) {
			while(k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
				k = prefix[k -1]; 
			}
			if(pattern.charAt(k) == pattern.charAt(i))
				k++;
			prefix[i] = k;
		}
		
		return prefix;
	}
	
	public static void main(String[] args) {
		
		//String ptrn = "aabaabaaa";    prefix[] = {0,1,0,1,2,3,4,5,2}
		//另外一个对于理解prefix[]数组比较有帮助的例子：
		//ptrn = "acacabacacabacacac",  prefic[] = {0,0,1,2,3,0,1,2,3,4,5,6,7,8,9,10,11,4}
 	    String ptrn = "abcaby";
        String text = "abxabcabcaby";  
		
		

		Solution kmp = new Solution();
		kmp.setText("ababacabacbababababacabcbabababaca");
//				kmp.setPattern("ababaca");
		kmp.setPattern("ababaca");
		
		kmp.KMPMatcher();
		
	}
}
