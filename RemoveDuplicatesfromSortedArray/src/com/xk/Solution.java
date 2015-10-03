package com.xk;

public class Solution {
	public int removeDuplicates(int[] nums) {
//        if(nums == null || nums.length == 0)
//            return 0;
//        if(nums.length == 1)
//            return 1;
//        int pos = 0;
//        for(int i=1;i<nums.length-pos;){
//            if(nums[i-1] == nums[i]){
//                for(int j=i;j<nums.length-pos;j++)
//                    nums[j-1] = nums[j];
//                pos++;
//            }else
//            	i++;
//        }
//        return nums.length - pos;
		
//		int n = nums.length;
//        if(n<2) return n;
//        int end=0;
//        for(int i=1; i<n; i++) {
//            if(nums[i]!=nums[end]) {
//                end++;
//                if(i!=end) nums[end] = nums[i];
//            }
//        }
//        return end+1;
        
        
        //removeDuplicatesII
        /*
         * ��Iһ����˼·������������ڵ�A[end-1] = A[end] = A[i]ʱ��A[i]Ϊ�ظ�Ԫ����������
         * ��ʵ��ֻ��Ҫ�Ƚ�A[end-1]��A[i]����Ϊ��A[end-1] = A[i]ʱ������sorted arry���Ա�ȻҲ��A[end]=A[end-1]��
         * */
//        int n = nums.length;
//        if(n<3) return n;
//        int end=1;
//        for(int i=2;i<n;i++){
//            if(nums[i]!=nums[end-1])
//                nums[++end] = nums[i];
//        }
//        return end+1;
		
		int len = nums.length;
        if(len<3)
            return len;
        int end = 0, count = 1;
        for(int i=1;i<len;i++){
            if(nums[i] == nums[end]){
                if(count ==1){
                    count++;
                    end++;
                    nums[end] = nums[i];
                }
            }else{
                if(count ==2)
                	count = 1;
                end++;
                if(end!=i){
                    nums[end]=nums[i];  
                }
            }
        }
        return end+1;
    }
	
	public static void main(String[] args) {
//		int[] input = {1,2,3,3,4,4,4,5,5};
		int[] input = {1,1,1,1,3,3};
		Solution s = new Solution();
		int res = s.removeDuplicates(input);
		System.out.println(res);
	}
}
