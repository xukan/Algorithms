package com.xk;

public class merge {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int length = m+n;
//        int[] merge = new int[length];
//        int i=0,j=0,k=0;
//        while(k<length){
//            if(n==0||j==n||i<=(m-1)&&nums1[i]<=nums2[j]){
//                merge[k]=nums1[i];
//                i++;
//            }
//            else{
//                merge[k] = nums2[j];
//                j++;  
//            }
//            k++;
//        }
//		for(int l=0;l<length;l++)
//        	System.out.print(merge[l]+" ");
		
		int k = m+n-1;
		int i=m-1;
		int j=n-1;
		while(k>=0){
			if(j<0||(i>=0)&&(nums1[i]>nums2[j]))
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}
        for(int l=0;l<(m+n);l++)
        	System.out.print(nums1[l]);
	}
	
	public static void main(String[] args){
		int a[]={0}, b[]={1};
		int m=0,n=1;
		merge(a,m,b,n);
	}
	
}
