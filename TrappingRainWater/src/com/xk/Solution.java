package com.xk;
//������õ���˼·��Candy��һ����,Ҳ���Կ�����Longest Palindromic Substring�еĵ�һ�ַ���
/*������leetcode�ϵ�ͼ�� 
 *index:           0 1 2 3 4 5 6 7 8 9 10 11
 *input:           0 1 0 2 1 0 1 3 2 1 2  1
 * container:
 * ��һ��:(������߶�)  0 0 1 1 2 2 2 2 3 3 3  3
 * �ڶ���:(������С�߶�)  0 0 1 1 2 2 2 2 2 2 1  0
 *  
 *             res 0 0 1 1 1 2 4 5 5 6 6 6 
 *             max 1 2 2 2 3 3 3 3 3 3 3 3
 * */


/*
 * ���ַ����ǻ��ڶ�̬�滮�ģ�����˼·����ά��һ������Ϊn������(container)����������ɨ�裬һ�δ������ң�һ�δ������󡣵�һ��ɨ���ʱ��ά������ÿһ��bar������ĸ߶��Ƕ��٣����������ӦԪ���У�
 * �ڶ���ɨ���ʱ��ά���ұ����ĸ߶�(max)�����ұȽϽ���ߺ��ұ�С�����߶ȣ����ǳ�Ϊƿ������������(contaienr)��ӦԪ���С���������ɨ��֮��Ϳ��Եõ�ÿһ��bar�ܳ��ܵ����ˮ�����Ӷ��ۼӵó������
 * �������ֻ��Ҫ����ɨ�裬����ʱ�临�Ӷ���O(2*n)=O(n)���ռ�����Ҫһ������Ϊn�����飬���Ӷ���O(n)��*/
public class Solution {
	
	public static int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int len = height.length;
        int[] container = new int[len];
        int max = 0;
        int res = 0;
        for(int i=0;i<len;i++){
            container[i] = max;
            max = Math.max(height[i], max);
        }
        max = 0;
        for(int i=len-1;i>=0;i-- ){
            container[i] = Math.min(max, container[i]);
            max = Math.max(max, height[i]);
            res+= (container[i] - height[i])>0? (container[i]-height[i]): 0;
        }
        return res;
	}	
	
	public static void main(String[] args){
//		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] input = {2,0,2};
		int maxVol = trap(input);
		System.out.println(maxVol);
	}
}
