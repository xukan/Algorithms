package com.xk;
/* http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
 * ���������⶯̬�滮������ͳ�Ķ�̬�滮���ǻ������룬����i��ʱ����j�ν��׵�������棬Ҫô���ڵ���i-1��ʱ����j�ν��׵�������棨��i��۸���ڵ�i-1��ļ۸񣩣�Ҫô���ڵ���i-1��ʱ����j-1�ν��ף�Ȼ���i�����һ�ν��ף���i��۸���ڵ�i-1��۸�ʱ�������ǵõ����淽�����£�����diff = prices[i] �C prices[i �C 1]����
 * profit[i][j] = max(profit[i �C 1][j], profit[i �C 1][j �C 1] + diff)
 * ���������е�������ʵ���ԣ�Ϊʲô�����أ���Ϊdiff�ǵ�i��͵�i-1��Ĳ�����棬�����i-1�쵱�챾��Ҳ�н����أ�
 * ��ô�����ν��׾Ϳ��Ժ�Ϊһ�ν��ף�����profit[i �C 1][j �C 1] + diffʵ����ֻ������j-1�ν��ף������������Ե�j�Σ�
 * �����õ�����������С�ˡ�(Ҫ�������۵㣬
 * ��Ҫ����Ū����Best Time to Buy and Sell Stock II��ԭ�� -a+b+c-b= c-a,����b�ǵ�i-1��ļ۸����i-1���н��ף�i��Ҳ�н��ף���ôi-1��ļ۸�ͱ�������)
 * ��ô���������i����н��׵������������棬�Ż�����ټ���һ�ν����أ�
 * ������һ���ֲ����Ž��ȫ�����н��ʾ����i�����j�ε����棬����Ǹö�̬�滮������֮����
 * ��local[i][j]��ʾ�����i��ʱ��������j�ν��׵ľֲ����Ž⣻��global[i][j]��ʾ�����i��ʱ��������j�ε�ȫ�����Ž⡣���Ƕ��ߵĹ�ϵ���£�����diff = prices[i] �C prices[i �C 1]����
 * local[i][j] = max(global[i �C 1][j �C 1] + max(diff, 0), local[i �C 1][j] + diff)
 * global[i][j] = max(global[i �C 1][j], local[i][j])
 * ���е�local[i �C 1][j] + diff����Ϊ�˱����i�콻�׺͵�i-1�콻�׺ϲ���һ�ν��׶���һ�ν������档
 * 
 * ����Ľⷨ��һά����ģ���ʵ��ά����Ľⷨ��������⣺
 * http://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
 * 
 * ����������code ganker�ķ�����
 * http://blog.csdn.net/linhuanmars/article/details/23236995
 * ���������Ƚ��������Խ���k�ν��׵��㷨��Ȼ����������������ֻ��Ҫ��kȡ��2���ɡ����ǻ���ʹ�á��ֲ����ź�ȫ�����Žⷨ����
 * ����ά����������һ���ǵ�ǰ�����i�����������j�ν��ף���õ������Ƕ��٣�global[i][j]����
 * ��һ���ǵ�ǰ�����i�죬���ɽ���j�ν��ף��������һ�ν����ڵ�����������õ������Ƕ��٣�local[i][j]����
 * ����������������ʽ��ȫ�ֵıȽϼ򵥣�
 * global[i][j]=max(local[i][j],global[i-1][j])��
 * Ҳ����ȥ��ǰ�ֲ���õģ��͹���ȫ����õ��д���Ǹ�����Ϊ���һ�ν������������ǰ��һ���ھֲ���õ����棬����һ���ڹ���ȫ�����ŵ����棩�����ھֲ�������ά��������ʽ��
 * local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)��
 * Ҳ���ǿ�����������һ����ȫ�ֵ�i-1�����j-1�ν��ף�Ȼ����Ͻ���Ľ��ף����������׬Ǯ�Ļ���Ҳ����ǰ��ֻҪj-1�ν��ף����һ�ν���ȡ��ǰ�죩���ڶ���������ȡlocal��i-1��j�ν��ף�Ȼ����Ͻ���Ĳ�ֵ��������Ϊlocal[i-1][j]���������i-1�������Ľ��ף��������ڱ�ɵ�i�����������������ӽ��״�����������������diff�ǲ��Ǵ���0��һ��Ҫ���ϣ���Ϊ����Ͳ�����local[i][j]���������һ�������������ˣ���
 * */
public class Solution {
	public static int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k <= 0)
		    return 0;
        
        /*
         * ���k��ֵԶ����prices������������k�Ǻü����򣬶�prices��������Ϊ������Ļ��������DP�ⷨ�ͷǳ���û��Ч�ʣ�
         * Ӧ��ֱ����Best Time to Buy and Sell Stock II ���Ʊ�����ʱ��֮���ķ�������⣬
         * ����ʵ�����������֮ǰ�Ķ��������ۺ��壬
         * */
        
        if(k>=prices.length)
        	return maxProfit2(prices);
        
        //��ά����ⷨ��
//        int[][] local = new int[len][k + 1];
//    	int[][] global = new int[len][k + 1];
//     
//    	for (int i = 1; i < len; i++) {
//    		int diff = prices[i] - prices[i - 1];
//    		for (int j = 1; j <= k; j++) {
//    			local[i][j] = Math.max(
//    					global[i - 1][j - 1] + Math.max(diff, 0),
//    					local[i - 1][j] + diff);
//    			global[i][j] = Math.max(global[i - 1][j], local[i][j]);
//    		}
//    	}    
//    	return global[prices.length - 1][k];
        
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        
        for(int i=1;i<prices.length;i++){
        	int diff = prices[i] - prices[i-1];
        	for(int j=k;j>0;j--){
        		local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
        		global[j] = Math.max(global[j], local[j]);
        	}
        }
       
        
        return global[k];
	}
	
	public static int maxProfit2(int[] prices){
		int maxProfit=0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]>prices[i-1])
				maxProfit+= prices[i] - prices[i-1];
		}
		return maxProfit;
	}
	
	public static void main(String[] args){
		int[] prices = {9,20,5,3,100,50,70,90};
		int maxProfit = maxProfit(3,prices);
		System.out.println(maxProfit);
	}
}
