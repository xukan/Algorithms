package com.xk;
//Implement next permutation, which rearranges numbers into the lexicographically next greater 
//permutation of numbers.

/*
 * 所以这道题重点在理解lexicographically这个词，意思是按照字典顺序
 * 也就是排序是按照由小到大的顺利排列的
 * 举个例子：2,3,6,5,4,1
 * 从右边开始找，找到第一个破坏升序的数，是3,(对3后面的4个数，它们的排列，按字典顺序，最小的组合是1，4,5,6,最大的组合是6,5,4,1。也就是说这四个数已经完成了排序)
 * 再从右边开始找，找到第一个比3大的数是4，交换3和4的位置(显然，按照字典顺序，2,3排好后就要排2,4了)
 * 交换位置后变为：2,4,6,5,3,1,把后四个数逆序，得到最终答案，2,4,1,3,5,6
 * 这道题难在理解好题意*/
public class Solution {
	public static int[] nextPermutation(int[] nums) {
        int i=0, j=0;
        for(i=nums.length - 2;i>=0;i--){
            if(nums[i] >= nums[i+1])
                continue;
            for(j = nums.length-1;j>i;j--)
                if(nums[j]>nums[i])
                    break;
            break;
        }
        if(i>0){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int start = i+1, end = nums.length-1;
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        return nums;
    }
	
	public static void main(String[] args){
		int[] input = {5,1,1};
		int[] res = nextPermutation(input);
		for(int i: res)
			System.out.print(i+" ");
	}
}
