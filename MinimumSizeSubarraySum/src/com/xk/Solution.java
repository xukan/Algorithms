package com.xk;

public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		//O(n) solution : sliding window
//		int start=0, current = 0;
//		if(nums.length == 0)
//			return 0;
//		int sum = 0, min=Integer.MAX_VALUE;
//		for(;current<nums.length;current++){
//			sum+=nums[current];
//			while(sum>=s){
//				int length = current - start +1;
//				min= Math.min(min, length);
//				sum-=nums[start++];
//			}
//		}
//		return min == Integer.MAX_VALUE? 0: min;
		
		
//		int length = nums.length;
//		int left=0, right = length-1, min = 0;
//		boolean flag = false;
//		while(left<=right){
//			int mid = (left+right)/2;
//			flag = solve(mid, s, nums);
//			if(flag){
//				min = mid;
//				right = mid -1;
//			}else
//				left = mid + 1;
//		}
//		return min;
		
//		def minSubArrayLen(self, s, nums):
//	        size = len(nums)
//	        left, right = 0, size
//	        bestAns = 0
//	        while left <= right:
//	            mid = (left + right) / 2
//	            if self.solve(mid, s, nums):
//	                bestAns = mid
//	                right = mid - 1
//	            else:
//	                left = mid + 1
//	        return bestAns

//	    def solve(self, l, s, nums):
//	        sums = 0
//	        for x in range(len(nums)):
//	            sums += nums[x]
//	            if x >= l:
//	                sums -= nums[x - l]
//	            if sums >= s:
//	                return True
//	        return False	
		
//    }
//	
//	public boolean solve(int mid, int s, int[] nums){
//		int sum = 0;
//		for(int i=0;i<nums.length;i++){
//			sum+=nums[i];
//			if(i >=mid)
//				sum -= nums[i-1];
//			if(sum >= s)
//				return true;
//		}
//		return false;
				
	    int min = Integer.MAX_VALUE;  
	    int len = nums.length;
	    int[] sum = new int[len+1];  
	    for (int i = 0; i < len; i++)  
	        sum[i+1] = sum[i] + nums[i];  
	    for (int i = 0; i < len; i++) {
	            //int j = binarySearch(0, i, sum[i+1]-s+1, sum);  
	            int right = binarySearch(i + 1, len, sum[i] + s, sum);
	            if (right == len + 1) break;
	            if (min > right - i) min = right - i;
	    }  
	    return min == Integer.MAX_VALUE ? 0 : min;  
	}  
		      
	int binarySearch(int left, int right, int target, int[] sum) {  
		while (left <= right) {
            int mid = (left + right) / 2;
            if (sum[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
	
	public static void main(String[] args){
		int[] input = {1,2,3,4,5};
		Solution s = new Solution();
		int length = s.minSubArrayLen(11,input);
		System.out.println(length);
	}
}
