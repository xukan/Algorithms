package com.xk;

import java.util.*;

public class Solution {
	public static int minimumTotal(List<List<Integer>> triangle) {
		
		//自顶向下考虑
		/*if(triangle == null || triangle.size() == 0)  
	        return 0;  
	    if(triangle.size()==1)  
	        return triangle.get(0).get(0);  
	    int[] sums = new int[triangle.size()];  
	    sums[0] = triangle.get(0).get(0);  
	    for(int i=1;i<triangle.size();i++)  
	    {  
	        sums[i] = sums[i-1]+triangle.get(i).get(i);  
	        for(int j=i-1;j>=1;j--)  
	        {  
	            sums[j] = (sums[j]<sums[j-1]?sums[j]:sums[j-1]) + triangle.get(i).get(j);  
	        }  
	        sums[0] = sums[0]+triangle.get(i).get(0);  
	          
	    }  
	    int minimum = sums[0];  
	    for(int i=1;i<sums.length;i++)  
	    {  
	        if(sums[i]<minimum)  
	        {  
	            minimum = sums[i];  
	        }  
	    }  
	    return minimum;*/
		
		//自底向上考虑, 很牛的是res[0]就是最小值了
		if(triangle.size() == 0)  
	        return 0;  
	    int[] res = new int[triangle.size()];  
	    for(int i=0;i<triangle.size();i++)  
	    {  
	        res[i] = triangle.get(triangle.size()-1).get(i);  
	    }  
	    for(int i=triangle.size()-2;i>=0;i--)  
	    {  
	        for(int j=0;j<=i;j++)  
	        {  
	            res[j] = Math.min(res[j],res[j+1])+triangle.get(i).get(j);   
	        }  
	    }  
	    return res[0];
		
    }
	
	public static void main(String[] args){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		item.add(2);
		triangle.add(new ArrayList(item));
		item.clear();
		item.add(3);
		item.add(4);
		triangle.add(new ArrayList(item));
		item.clear();
		item.add(6);
		item.add(5);
		item.add(7);
		triangle.add(new ArrayList(item));
		item.clear();
		item.add(4);
		item.add(1);
		item.add(8);
		item.add(3);
		triangle.add(new ArrayList(item));
		int res = minimumTotal(triangle);
		System.out.println(res);
	}
}
