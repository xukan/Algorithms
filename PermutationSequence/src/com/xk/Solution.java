package com.xk;

import java.util.*;

public class Solution {
//	public static String getPermutation(int n, int k) {
//		if(n<=0)  
//	        return "";  
//	    k--;  
//	    StringBuilder res = new StringBuilder();  
//	    int factorial = 1;  
//	    ArrayList<Integer> nums = new ArrayList<Integer>();  
//	    for(int i=2;i<n;i++)  
//	    {  
//	        factorial *= i;  
//	    }  
//	    for(int i=1;i<=n;i++)  
//	    {  
//	        nums.add(i);  
//	    }  
//	    int round = n-1;  
//	    while(round>=0)  
//	    {  
//	        int index = k/factorial;  
//	        k %= factorial;  
//	        res.append(nums.get(index));  
//	        nums.remove(index);  
//	        if(round>0)  
//	            factorial /= round;  
//	        round--;  
//	    }  
//	    return res.toString();  
//	}
	
	
	//�и�Сϸ�ڣ�����һ��ʼ��k--��Ŀ�������±��0��ʼ�������±���Ǵ�0��n-1�����ÿ���nʱȥȡ�࣬���õظ������±�ƥ�䡣
	public static String getPermutation(int n, int k) {
		String res = "";
		if(k<=0)
			return res;
		k--;  //��һ������Ҫ��
		int factorial = 1;
		for(int i=2;i<n;i++)
			factorial *= i;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1;i<=n;i++)
			nums.add(i);
		for(int round = n-1; round >=0; round--){
			int index = k/factorial;
			k %= factorial;
			res += Integer.toString(nums.get(index));
			nums.remove(index);
			if(round>0)
				factorial /= round;
		}
		return res;
	}
	
	public static void main(String[] args){
		String res = getPermutation(4,10);
		System.out.println(res);
	}
}
