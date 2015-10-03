package com.xk;

import java.util.*;

//Your algorithm should run in O(n) complexity.

/*
 * ����һ��Hashtable����HashSet�Ŀռ任ʱ����⣡ 
 * ȡ��HashSet�е�ĳһԪ��x����x-1,x-2....x+1,x+2...�Ƿ�Ҳ��set��
 * */
public class Solution {
	public static int longestConsecutive(int[] num) {
		// if array is empty, return 0
		if (num.length == 0) {
			return 0;
		}
		// ��������������Ҫ���Ӷ�O(n)��������⣬ֻ�����ӿռ临�Ӷȣ���hashset����hashtable 
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
	 
		for (int e : num)
			set.add(e);
	 
		for (int e : num) {
			if(set.contains(e)){
			set.remove(e);
			int left = e - 1;
			int right = e + 1;
			int count = 1;
	 
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
	 
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
	 
			max = Math.max(count, max);
		}
		}
		return max;
	}
	
	public static void main(String a[]){
        
        int[] input = {5,4,6,1,3,2};
        int len = longestConsecutive(input);
            System.out.print(len);
    }
}
