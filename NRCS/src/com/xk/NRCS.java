package com.xk;

import java.util.*;
//维护一个窗口，时间复杂度是O(n)，空间复杂度也是O(size)=O(n)
public class NRCS {
	public static int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0)
			return 0;
		
		int preIndex=0, curIndex=0, maxlen=0,curlen=0;
		Set<Character> set= new HashSet<Character>();
		while(curIndex<s.length()){
			if(set.contains(s.charAt(curIndex))){
				if(maxlen<curIndex-preIndex)
					maxlen=curIndex-preIndex;
				set.remove(s.charAt(preIndex));
				preIndex++;
			}else{
				set.add(s.charAt(curIndex));
				curIndex++;
			}
		}
		maxlen = Math.max(maxlen, curIndex-preIndex);
		return maxlen;
	}
	public static void main(String[] args){
//		String input = "abcabcbb";
		String input = "abc";
		int l=lengthOfLongestSubstring(input);
		System.out.println(l);
	}
}
