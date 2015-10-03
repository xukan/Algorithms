package com.xk;
<<<<<<< HEAD
/*
 * ��Search in Rotated Sorted ArrayΨһ�������������Ŀ��Ԫ�ػ����ظ���������֡�
 * ����������Ϊ��������ĳ��֣������˱Ƚϸ��ӵ�case������Ӱ�쵽���㷨��ʱ�临�Ӷȡ�ԭ�������������м�ͱ�ԵԪ�صĴ�С��ϵ��
 * ���ж���һ���ǲ���rotateӰ�죬��Ȼ����ġ���������Ϊ�ظ��ĳ��֣�������������м�ͱ�Ե��ȵ���������ǾͶ�ʧ���ı��������Ϣ��
 * ��Ϊ�ı߶��п���������Ľ��������ԭ������{1,2,3,3,3,3,3}����ô��ת֮���п�����{3,3,3,3,3,1,2}������{3,1,2,3,3,3,3}��
 * �����������ж����Ե�����ĵ�ʱ����3���������ҪѰ��1����2�����ǲ���֪��Ӧ��������һ�롣����İ취ֻ���ǶԱ�Ե�ƶ�һ����ֱ����Ե���м䲻����Ȼ���������
 * ��͵����˻��в�����ȥһ��Ŀ��ܡ���������������ȫ������һ��Ԫ�أ�����ֻ��һ��Ԫ�ز�ͬ������Ԫ�أ������������һ�����ͻ����ÿ���ƶ�һ����
 * �ܹ���n�����㷨��ʱ�临�Ӷȱ��O(n)��
 * 
 * 
 * */

/* BINARY SEARCH:
 * 
 * Search in Rotated Sorted Array
 * Search in Rotated Sorted Array II
 * Find Minimum in Rotated Sorted Array
 * Find Minimum in Rotated Sorted Array II
 * Search Insert Position
 * Search for a Range
 * Search a 2D Matrix
 * Find Peak Element
 * */
=======

>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
public class Solution {
	public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
			return false;
		int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;
            if(nums[left]<nums[mid]){
            	if(nums[left]<=target&&target<nums[mid])
            		right = mid-1;
            	else
            		left = mid+1;
            }else if(nums[left]>nums[mid]){
            	if(nums[mid]<target&&target<=nums[right])
            		left = mid+1;
            	else
            		right = mid -1;
            }else{
            	left++;
            }
        }
        return false;
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] input ={3,3,3,3,3,5};
		boolean res = s.search(input, 5);
		System.out.println(res);
	}
}
