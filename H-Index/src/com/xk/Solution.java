package com.xk;

import java.util.*;
//这里的index h其实是一个计数(数量)
//h papers of N papers has at least h citations each, the other N-h papers has no more than
//h citations each.
public class Solution {
	//O(nlogn)时间，O(1)空间。
	public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int count = 0;
        for(int i=citations.length-1;i>=0;i--){
            if(count >= citations[i]){
                return count;
            }    
            count++;
        }
        return count;
    }
	
//	public static int hIndex(int[] citations) {
//        int len = citations.length;
//        if(citations == null || len == 0) return 0;
//        int[] counts = new int[len + 1];
//        for(int c : citations){
//            if(c > len) counts[len]++;
//            else counts[c]++;
//        }
//        if(counts[len] >= len) return len;
//        for(int i = len - 1; i >= 0; i--){
//            counts[i] += counts[i + 1];
//            if(counts[i] >= i) 
//            	return i;//两种方法的返回值不同
//        }
//        return 0;
//    }
	
	
	public static void main(String[] args) {
//		int[] input={1};
//		int[] input={0};
		int[] input={3, 0, 6, 1, 5};
		int res = hIndex(input);
		System.out.println(res);
	}
}
