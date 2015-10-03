package com.xk;

public class Solution {
	public int removeElement(int[] A, int elem) {
		if(A == null || A.length == 0)
			return 0;
//		int num = 0;
//		for(int i=0;i<A.length;i++){
//			if(A[i]!=elem)
//				A[num++] = A[i];
//		}
		  int p=0, q=0;
         // 1 1 2
         while(q != A.length){
             if(A[q] == elem){
                 q++;
             }else{
                 A[p] = A[q];
                 p++;
                 q++;
             }
         }
		return p;
	}
	
	public static void main(String[] args){
		int[] input= {1,2,2,3};
		Solution s = new Solution();
//		input = s.removeElement(input, 2);
//		
//		for(int i=0;i<input.length;i++)
//			System.out.print(input[i]);
//		System.out.println();
		int res = s.removeElement(input, 2);
		System.out.println(res);
	}
}
