package com.xk;

public class Solution {
	public int maxProfit(int[] prices) {
//Best Time to Buy and Sell Stock I
//至多允许一次交易
//其实就是一个扫描数组，求数组中数字相差最大值的过程，但是这个最大值，永远都是后者减去前者。
//        if(prices == null)
//            return 0;
//        int profit = 0;
//        int minElement = prices[0];
//        for(int i=0; i<prices.length; i++){
//            minElement = Math.min(minElement, prices[i]);
//            profit = Math.max(profit, prices[i]-minElement);
//        }
//        return profit;

		//Best Time to Buy and Sell Stock II
		//交易次数不限，求最大利润
		if(prices == null || prices.length == 0){  
            return 0;  
        }  
        int len = prices.length;  
        int maxProfit = 0;  
        for(int i = 1; i < len; i++){  
            int tempProfit = prices[i] - prices[i-1];  
            if(tempProfit > 0){  
                maxProfit += tempProfit;  
            }  
        }  
        return maxProfit; 
    }
	
	public static void main(String[] args){
//		int[] input= {5, 7, 2, 4, 9, 1};
		int[] input= {3,5,7,2, 9, 1};
		Solution s = new Solution();
		int res = s.maxProfit(input);
		System.out.println(res);
	}
}
