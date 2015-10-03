package com.xk;

public class InsertionSort {
	public static int[] insertionSort(int[] A){
		for(int i=1;i<A.length;i++){
			int key = A[i];
			int j=i-1;
			for(;j>=0&&A[j]>key;j--)
				A[j+1]=A[j];
			A[j+1]=key;
		}
		return A;
	}
	
	public static void main(String[] args){
		int[] input = {5,2,4,6,1,3};
		int[] res = insertionSort(input);
		for(int i: res)
		System.out.print(i+" ");
	}
}
