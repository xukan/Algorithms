package com.xk;

import java.util.*;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {  
        // Start typing your Java solution below  
        // DO NOT write main() function  
//        int length = s.length();  
//        if (length == 0) {  
//            return 0;  
//        }  
//        int [] countTable = new int[256];  //countTable是用来记录字符串中字母位置的表
//        Arrays.fill(countTable, -1);  
//        int max = 0;  
//        int start = 0;  
//        int end = 0;  
//           
//        while(end<length){
//        	if(countTable[s.charAt(end)] >= start){
//        		start = countTable[s.charAt(end)] + 1;
//        	}
//        	countTable[s.charAt(end)] = end;
//        	max = Math.max(max, end-start+1);
//        	end++;
//        }
//        return max;  
		
		//双指针的题目(滑动窗口)，可以发现循环的时候都是while(fast<length)的这种形式，而不用for循环
		//这道题set的作用是为了查重, 但不是用了add,而是remove
		/*
		 * 我们介绍一种线性的算法，也是这类题目最常见的方法。基本思路是维护一个窗口，每次关注窗口中的字符串，在每次判断中，左窗口和右窗口选择其一向前移动。
		 * 同样是维护一个HashSet, 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，如果发现重复字符，则说明当前窗口中的串已经不满足要求，继续移动有窗口不可能得到更好的结果
		 * 此时移动左窗口，直到不再有重复字符为止，中间跳过的这些串中不会有更好的结果，因为他们不是重复就是更短。因为左窗口和右窗口都只向前，所以两个窗口都对每个元素访问不超过一遍，
		 * 因此时间复杂度为O(2*n)=O(n),是线性算法。空间复杂度为HashSet的size,也是O(n). 
		 * */
		
		if(s==null || s.length()==0)  
            return 0;  
        HashSet<Character> set = new HashSet<Character>();
        int slow = 0, fast = 0, maxLen = 0;
        while(fast<s.length()){
            char c = s.charAt(fast);
            if(set.contains(c)){
                maxLen = Math.max(maxLen, fast-slow);
                while(s.charAt(slow)!=c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }else
                set.add(c);
            fast++;
        }
        //maxLen = Math.max(maxLen, set.size());
        maxLen = Math.max(maxLen, fast-slow);//上面那句，set.size()和fast-slow效果是一样的
        return maxLen;

    }     
	
	public static void main(String[] args){
		String input ="vqblqcb";//"";
		int res = lengthOfLongestSubstring(input);
		System.out.println(res);
	}
}
