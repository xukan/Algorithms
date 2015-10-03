package com.xk;
<<<<<<< HEAD
/*
 * �����֮���Ի������ö��ֲ��ң�ǰ������ת�������������Ȼ�������
 * 
 * ������Ƕ��ֲ���Search Insert Position�ı��壬�����е��鷳����ʵ����һ�»��ǱȽϼ򵥵ġ�
 * ��Ϊrotate��Ե�ʣ���������ȡһ���ʱ����ܻ������������������Ҫ����һ�����жϡ�
 * ������˵������������A��ÿ�����ԵΪl���ұ�ԵΪr�������м�λ����m����ÿ�ε����У������������
��1�����target==A[m]����ôm��������Ҫ�Ľ����ֱ�ӷ��أ�
��2�����A[m]<A[r]����ô˵����m��rһ��������ģ�û���ܵ�rotate��Ӱ�죩��
           ��ô����ֻ��Ҫ�ж�target�ǲ�����m��r֮�䣬�����������Ե�Ƶ�m+1�������target����һ�룬�����ұ�Ե�Ƶ�m-1��
��3�����A[m]>=A[r]����ô˵����l��mһ��������ģ�ͬ��ֻ��Ҫ�ж�target�Ƿ��������Χ�ڣ���Ӧ���ƶ���Ե���ɡ�
           �������Ϸ�����ÿ�����Ƕ������е�һ������ݣ������㷨��ʱ�临�Ӷ���O(logn)���ռ临�Ӷ���O(1)
           
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
	public int search(int[]A, int target) {
		if(A == null || A.length == 0)
			return -1;
		int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target)
                return mid;
            if (A[left] <= A[mid]) {
                if (target >= A[left] && target <= A[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target >= A[mid] && target <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] input ={13,15,17,3,5,7,9,11};
<<<<<<< HEAD
		int res = s.search(input, 15);
=======
		int res = s.search(input, 9);
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		System.out.println(res);
	}
}
