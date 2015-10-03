package com.xk;
/*
 * O(n^2)���㷨�������뵽��
��Ѱһ����j����ԭ����price[0..n-1]�ָ�Ϊprice[0..j]��price[j..n-1]���ֱ������ε����profit��
�����Ż���
���ڵ�j+1����price[0..j+1]�����profitʱ���ܶ๤�����ظ��ģ�����price[0..j]�����profit���Ѿ������ˡ�
������Best Time to Buy and Sell Stock��������O(1)��ʱ���price[0..j]�Ƴ�price[0..j+1]�����profit��
������δ�price[j..n-1]�Ƴ�price[j+1..n-1]��������˼�������ǿ�����O(1)��ʱ����price[j+1..n-1]�Ƴ�price[j..n-1]��
�����㷨��
����l[i]��¼��price[0..i]�����profit��
����r[i]��¼��price[i..n]�����profit��
��֪l[i]����l[i+1]�Ǽ򵥵ģ�ͬ����֪r[i]����r[i-1]Ҳ�����ס�
�����������O(n)��ʱ���ҳ�����l[i]+r[i]����Ϊ��Ŀ����
 * 
 * */
/*
 * �����ʹ�õķ����������������������飬��Trapping Rain Water��Product of Array Except Self�������ж�ʹ��
 * ���˷�������ʵ��Product of Array Except Self��ʮ�����Ƶ�.
 * */
public class Solution {
	public int maxProfit(int[] prices) {
	    if (prices == null || prices.length <= 1) {
	        return 0;
	    }
	    int n = prices.length;
	    int[] endsAt = new int[n]; 
	    int[] startsAt = new int[n];
	    int lowest = prices[0];
	    // From left, find the max profit if 1st transac ends at i.
	    // Just like the first version of this problem.
	    for (int i = 1; i < n; i++) {
	        // in the first loop, endsAt[0] = 0
	        endsAt[i] = Math.max(endsAt[i - 1], prices[i] - lowest);
	        lowest = Math.min(lowest, prices[i]);
	    }
	    int highest = prices[n - 1];
	    // From right, find the max profit if 2nd transac starts at i.
	    // It is a reversed version of the previous for-loop logic.
	    for (int i = n - 2; i >= 0; i--) {
	        // in the first loop, startsAt[n-1] = 0
	        startsAt[i] = Math.max(startsAt[i + 1], highest - prices[i]);
	        highest = Math.max(highest, prices[i]);
	    }
	    int value = 0;
	    
	    System.out.println("endsAt: ");
	    for(int i=0;i<endsAt.length;i++)
	    	System.out.print(endsAt[i]+" ");
	    System.out.println();
	    System.out.println("StartsAt: ");
	    for(int i=0;i<startsAt.length;i++)
	    	System.out.print(startsAt[i]+" ");
	    System.out.println();
	    
	    
	    // combine to get the max result
	    for (int i = 0; i < n; i++) {
	        value = Math.max(value, endsAt[i] + startsAt[i]);
	    }
	    return value;
	}
	
	public static void main(String[] args){
		int[] input= {5, 7, 2, 4, 9, 1};
		Solution s = new Solution();
		int res = s.maxProfit(input);
		System.out.println(res);
	}
}
