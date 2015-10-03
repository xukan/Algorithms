package com.xk;

//������������+= gas[i] - cost[i]��һ�������жϵ�ǰ�������Ϊgas station�����ϲ����ʣ�һ�������ж��ܵ������ǲ��Ǵ��ڹ�����
//����ܵ�������ڹ�����ô�϶����޽�ģ��������С�ڵ��ڹ������Ϳ��Է��ظղ��ҵ�����ʼ�㡣

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
