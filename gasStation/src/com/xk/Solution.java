package com.xk;

//用两个变量存+= gas[i] - cost[i]。一个帮助判断当前这个点作为gas station的起点合不合适，一个帮助判断总的需求是不是大于供给。
//如果总的需求大于供给那么肯定是无解的，如果需求小于等于供给，就可以返回刚才找到的起始点。

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sumRemaining = 0; // track current remaining
		int total = 0; // track total remaining
		int start = 0; 
	 
		for (int i = 0; i < gas.length; i++) {
			int remaining = gas[i] - cost[i];
	 
			//if sum remaining of (i-1) >= 0, continue 
			if (sumRemaining >= 0) { 
				sumRemaining += remaining;
			//otherwise, reset start index to be current
			} else {
				sumRemaining = remaining;
				start = i;
			}
			total += remaining;
		}
	 
		if (total >= 0){
			return start;
		}else{
			return -1;
		}
	} 
	
	public static void main(String[] args){
//		int[] gas ={1,2,3,4,5};
//		int[] cost = {1,3,2,4,5};
		int[] gas = {6,2,8,5};
		int[] cost = {5,5,2,3};
		Solution s = new Solution();
		int start = s.canCompleteCircuit(gas, cost);
		System.out.println(start);
	}
}
