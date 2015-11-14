package com.xk;

import java.util.*;

public class Solution {
	//param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        buildMaxHeap(numbers);
        heapSort(numbers);
      //In this method, we build a maxHeap, then we use heapSort to sort the elements. 
       //The result is sorted in ascending order.
        for(int i: numbers)
        	System.out.print(i+" ");
        System.out.println();
        return numbers.get(k-1);
    }
    
    public void buildMaxHeap(ArrayList<Integer> numbers){
        int size = numbers.size();
        for(int i=(size-1)/2;i>=0;i--)
            maxHeapify(numbers, i, size);
    }
    
    public void maxHeapify(ArrayList<Integer> numbers, int i, int size){
        int l=2*i+1;
        int r = 2*i+2;
        int largest = i;
        if( l< size && numbers.get(l)>numbers.get(i))
            largest = l;
        if( r< size && numbers.get(r)>numbers.get(largest))
            largest = r;
        if(largest!=i){
            swap(numbers, i, largest);
            maxHeapify(numbers, largest, size);
        }
    }
    
    public void heapSort(ArrayList<Integer> numbers){
        for(int i=numbers.size()-1;i>=0;i--){
            swap(numbers, 0, i);
            maxHeapify(numbers, 0, i);
        }
    }
    
    public void swap(ArrayList<Integer> numbers, int a, int b){
        int temp = numbers.get(a);
        numbers.set(a, numbers.get(b));
        numbers.set(b,temp);
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> num = new ArrayList<Integer> ();
    	//1,2,3,4,5,6,8,9,10,7
    	num.add(1);
    	num.add(2);
    	num.add(3);
    	num.add(4);
    	num.add(5);
    	num.add(6);
    	num.add(8);
    	num.add(9);
    	num.add(10);
    	num.add(7);
    	Solution s = new Solution();
    	int res = s.kthLargestElement(10,num);
    	System.out.println(res);
	}
}
