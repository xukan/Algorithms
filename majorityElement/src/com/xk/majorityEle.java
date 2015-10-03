package com.xk;

import java.util.*;

public class majorityEle {
	//public int majorityElement(int[] num) {
//        int count=0;
//        int len=num.length;
//        //List<Integer> time =new LinkedList<Integer>();
//        for(int i=0;i<len;i++){
//        	for(int j=i+1;j<num.length;j++){
//        		if(num[j]==num[i]){
//        			count++;
//        			if(count==(len/2))
//        				return ++count;
//        		}	
//        	}
//        	count=0;
//        }
//        return 0;
		
		
//    }
	public int findCandidate(int[] num,int candidate){
		int count=0;
		int len=num.length;
		for(int i=0;i<len;i++)
			if(num[i]==candidate)
				count++;
		if(count>(len/2))
			return candidate;
		return 0;
	}
	
	//Moore¡¯s Voting Algorithm
	//find the candidate with most frequent show time
	public int majorityElement(int[] num){
		int count=1;
		int max_can=0;
		int len=num.length;
		for(int i=1;i<len;i++){
			if(num[max_can]==num[i])
				count++;
			else
				count--;
			if(count==0){
				max_can=i;
				count=1;
			}
		}
		return num[max_can];
	}
	public static void main(String [] args){
		majorityEle m=new majorityEle();
		int[] array={3, 3, 4, 2, 4, 4, 2, 4, 4};
		int maxEle=m.majorityElement(array);
		int result=m.findCandidate(array, maxEle);
		System.out.println(result);
	}
}
