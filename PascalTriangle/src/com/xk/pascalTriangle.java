package com.xk;

import java.util.*;

public class pascalTriangle {
<<<<<<< HEAD
	public static List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer> ();
		if(numRows == 0)
			return res;
		cur.add(1);
		res.add(cur);
		if(numRows == 1)
			return res;

		for(int i=1;i<numRows;i++){
			List<Integer> temp = new ArrayList<Integer>();
			List<Integer> pre =res.get(i-1);
			temp.add(1);
			for(int j=1;j<i;j++){
				temp.add(pre.get(j)+pre.get(j-1));
			}
			temp.add(1);
			res.add(temp);
		}
		return res;
    }
	
//	public static List<Integer> getRow(int rowIndex) {
//        
//    }
	
	public static void main(String[] args){
		List<List<Integer>> result = generate(5);
	
		for(List<Integer> it : result){
			for(Integer now : it){
				System.out.print(now+" ");
			}
			System.out.println();
		}
	
//	List<Integer> result = getRow(4);
//	for(Integer it : result){
//		System.out.print(it+" ");
//	}
//	System.out.println();
=======
//	public static List<List<Integer>> generate(int numRows) {
//		
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		List<Integer> cur = new ArrayList<Integer> ();
//		if(numRows == 0)
//			return res;
//		cur.add(1);
//		res.add(cur);
//		if(numRows == 1)
//			return res;
//
//		for(int i=1;i<numRows;i++){
//			List<Integer> temp = new ArrayList<Integer>();
//			List<Integer> pre =res.get(i-1);
//			temp.add(1);
//			for(int j=1;j<i;j++){
//				temp.add(pre.get(j)+pre.get(j-1));
//			}
//			temp.add(1);
//			res.add(temp);
//		}
//		return res;
//    }
	
	public static List<Integer> getRow(int rowIndex) {
        
    }
	
	public static void main(String[] args){
//		List<List<Integer>> result = generate(5);
	
//		for(List<Integer> it : result){
//			for(Integer now : it){
//				System.out.print(now+" ");
//			}
//			System.out.println();
//		}
	List<Integer> result = getRow(4);
	for(Integer it : result){
		System.out.print(it+" ");
	}
	System.out.println();
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	}
}
