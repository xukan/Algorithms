package com.xk;

public class findPeakElement {
<<<<<<< HEAD
//	public static int findPeak(int arr[], int low, int high, int size){
//		int mid= (low + high) / 2;
//		
//		if((mid==0||arr[mid-1]<=arr[mid])&&((mid==size-1)||arr[mid]>=arr[mid+1]))
//			return arr[mid];
//		else if(mid>0&&arr[mid-1]>arr[mid])
//			return findPeak(arr, low, (mid-1), size);
//		else 
//			return findPeak(arr, (mid+1), high, size);
//	}
	
	//二分查找的变形， 时间复杂度是O(lgn)
	//如果中间元素大于其相邻后续元素，则中间元素左侧(包含该中间元素）必包含一个局部最大值。如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值。
	public static int findPeakElement(int[] nums) {
		int l=0, r= nums.length-1;
		while(l<=r){
			if(l == r)
				return l;
			int m = (l+r)/2;
			if(nums[m]>nums[m+1])
				r = m;
			else
				l = m+1;
		}
		return 1;
	}
	public static void main(String[] args){
		int a[] = {1, 3, 20, 4,19,7,15, 1, 0};
		//int a[] = {1};
		int peak = findPeakElement(a);
=======
	public static int findPeak(int arr[], int low, int high, int size){
		int mid= (low + high) / 2;
		//System.out.println(mid);
		if((mid==0||arr[mid-1]<=arr[mid])&&((mid==size-1)||arr[mid]>=arr[mid+1]))
			return arr[mid];
		else if(mid>0&&arr[mid-1]>arr[mid])
			return findPeak(arr, low, (mid-1), size);
		else 
			return findPeak(arr, (mid+1), high, size);
	}
	public static void main(String[] args){
		//int a[] = {1, 3, 20, 4,19,7,15, 1, 0};
		int a[] = {1};
		int peak = findPeak(a, 0, a.length-1, a.length);
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		System.out.println(peak);
	}
}
