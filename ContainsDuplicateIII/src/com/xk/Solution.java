package com.xk;

import java.util.*;
//https://codesolutiony.wordpress.com/2015/06/01/leetcode-contains-duplicate-iii/
public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//		if(k<1 || t<0 || nums==null) return false;  
//        
//        SortedSet<Long> set = new TreeSet<Long>();  
//          
//        for(int j=0; j<nums.length; j++) {  
//            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);  
//            if(!subSet.isEmpty()) return true;  
//              
//            if(j>=k) {  
//                set.remove((long)nums[j-k]);  
//            }  
//            set.add((long)nums[j]);  
//        }  
//        return false;  	

	
		if(k<1 || t<0 || nums==null) 
			return false;
	    TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();//pair: value-index
	    for (int i = 0; i < nums.length; i++) {
	        if (i > k) { 
	        	//����ɾ������û���õ�������i>k,�±�Ϊi-k~k�����������õģ����������жϣ���nums[i-k-1]��û������(i-(i-k-1)=k+1>k)�����Կ��Դ�map��ɾ��
	            map.remove((long)nums[i-k-1]);
	        }
	        long val = (long)nums[i];
	        //ע�⣺���������Long,����һ��object��long��һ��primitive data type,�ж��Ƿ�Ϊ��ʱ�����Զ���Ϊ��׼��
	        Long greater = map.ceilingKey(val);
	        //ceilingKey:The method call returns the least key greater than or equal 
	        //to key, or null if there is no such key.
	        if (greater != null && greater - val <= t) {
	            return true;
	        }
	        Long smaller = map.lowerKey(val);
	        //lowerKey:  The method call returns the greatest key less than key, 
	        //or null if there is no such key.
	        if (smaller != null && val - smaller <= t) {
	            return true;
	        }
	        map.put(val, i);
	    }
	    return false;
	}
	
	public static void main(String[] args){
		int[] input = {3,5,0,9,1};
//		int[] input = {1,2};
		Solution s = new Solution();
		boolean res = s.containsNearbyAlmostDuplicate(input,2,1);
		System.out.println(res); 
	}
}
