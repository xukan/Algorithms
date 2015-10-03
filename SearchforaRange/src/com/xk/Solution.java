package com.xk;

//用到二分查找的一个结论：如果没有找到目标元素，那么当停止时，L恰好停在比目标元素位置大的index上，R恰好停在比目标元素位置小的index上。
//实现中用到了在Search Insert Position中提到的方法，可以保证当搜索结束时，l和r所停的位置正好是目标数的后面和前面。
//二分查找的题目还是比较常考的
public class Solution {
	public static int[] searchRange(int[] nums, int target) {
        int[] res ={-1,-1};
        if(nums==null || nums.length==0)  
        {  
            return res;  
        }  
        int ll=0, lr=nums.length-1;
        while(ll<=lr)//二叉查找的while循环条件是<=
        {
        	int m = (ll+lr)/2;
        	if(nums[m]<target)
        		ll = m+1;
        	else
        		lr=m-1;//相等时向左逼近,   这样最后ll就是左边界
        }
        int rl=0, rr=nums.length-1;
        while(rl<=rr){
        	int m = (rl+rr)/2;
        	if(nums[m]<=target)//相等时会继续向右逼近
        		rl = m+1;
        	else
        		rr=m-1;
        }
        if(ll<=rr){
        	res[0] = ll;
        	res[1] = rr;
        }
        return res;
    }
	
	//递归法
//	public static int[] searchRange(int[] nums, int target) {
//        int[] res={-1,-1};
//        binarySearch(nums, target, res , 0, nums.length-1);
//        return res;
//    }
//    
//    public void binarySearch(int[] nums, int target, int[] res, int l, int r){
//        if(r<l)
//            return;
//        if(nums[l] == nums[r] && nums[l] == target){
//            res[0] = l;
//            res[1] = r;
//            return;
//        }
//        int m = (l+r)/2;
//        if(nums[m] > target)
//            binarySearch(nums,target,res, l, m-1);
//        else if(nums[m] < target)
//            binarySearch(nums, target,res, m+1, r);
//        else{
//            res[0] = m;
//            res[1] = m;
//            int tl = m;
//            while(tl>l && nums[tl] == nums[tl-1]){
//                tl--;
//                res[0] = tl;
//            }
//            int tr = m;
//            while(tr<r&& nums[tr] == nums[tr+1]){
//                tr++;
//                res[1] = tr;
//            }
//            return;
//        }
//        return;
//    }
	
	
	public static void main(String[] args){
		int[] input ={1,2,3,3,3,5,7,9,10};
		int[] res =  searchRange(input, 3);
		for(int i:res)
			System.out.print(i+" ");
	}
}
