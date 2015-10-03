package com.xk;

import java.util.*;

public class Solution {
	//我的解法超时啦，囧rz
//	public static List<List<Integer>> threeSum(int[] nums) {
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		if(nums == null || nums.length <= 2)
//			return res;
//		Arrays.sort(nums);
//		for(int i=0;i<nums.length-2;i++){
//			boolean flag = false;
//			ArrayList<Integer> temp = new ArrayList<Integer>();
//			temp.add(nums[i]);
//			for(int k = i+1;k<nums.length-1;k++){
//				temp.add(nums[k]);
//				int twoSum = nums[i]+nums[k];			
//				int left=k+1, right = nums.length-1;
//				while(left<=right){
//					int m = (left + right)/2;
//					if(twoSum+nums[m] == 0){
//						temp.add(nums[m]);
//						if(res.contains(temp)){
//							flag = true;
//							break;
//						}
//						else
//							res.add(new ArrayList<Integer>(temp));
//						flag = true;
//						break;
//					}
//					if(nums[m]<(-twoSum))
//						left = m+1;
//					else
//						right = m-1;
//				}
//				
//				if(flag){
//					temp.remove(2);
//					temp.remove(1);
//					flag = false;
//				}else
//					temp.remove(1);
//			}
//		}
//		return res;
//    }
	
//	public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//		if(nums == null || nums.length <= 2)
//			return res;
//		Arrays.sort(nums);
//		for(int i=nums.length-1;i>=2;i--){
//			//这里的判断非常好，避免了重复
//		    if(i<nums.length-1&&nums[i] == nums[i+1])
//		        continue;
//		    List<List<Integer>> curRes = new ArrayList<List<Integer>>();
//		    curRes = twoSum(nums, i-1, -nums[i]);
//		    for(int j=0;j<curRes.size();j++)
//		        curRes.get(j).add(nums[i]);
//		    res.addAll(curRes);//这里必须是addAll
//		}
//		return res;
//    }
//    
//    public static List<List<Integer>> twoSum(int[] nums, int end, int target){
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        
//        int l=0;
//        int r = end;
//        while(l<r){//如果这里是l<=r,结果会包含重复项
//            if(nums[l] + nums[r] == target){
//            	//注意这个temp的声明位置必须在while循环里面
//            	List<Integer> temp = new ArrayList<Integer>();
//                temp.add(nums[l]);
//                temp.add(nums[r]);
//                res.add(temp);
//                l++;//这里注意成功添加了一组之后，双指针要继续把范围缩小进行判断
//                r--;
//                while(l<r&&nums[l] == nums[l-1])//因为l指针已经向右移动过了，所以这里比较nums[l](当前)和nums[l+1](上一个)
//                    l++;
//                while(l<r&&nums[r] == nums[r+1])//r指针比较的道理同上
//                    r--;
//            }else if(nums[l] + nums[r] < target)
//                l++;
//            else
//                r--;
//        }
//        return res;
//    }
	//对nums数组正向遍历即可
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
        	if(i-1>=0 && nums[i] == nums[i-1])
        		continue;
            List<List<Integer>> curRes = new ArrayList<List<Integer>>();
            helper(nums, i+1, nums[i], curRes);
            for(List<Integer> l: curRes){
                l.add(0,nums[i]);
            }
            res.addAll(curRes);    
        }
        return res;
    }
    
    public static void helper(int[] nums, int l, int target, List<List<Integer>> curRes){
        int r= nums.length-1;
        while(l<r){
        	List<Integer> temp = new ArrayList<Integer>();
            if(nums[l] + nums[r] + target == 0){
                temp.add(nums[l]);
                temp.add(nums[r]);
                curRes.add(new ArrayList<Integer>(temp));
                l++;
                r--; 
                while(l<r&&nums[l-1] == nums[l])
                    l++;
                while(l<r&&nums[r+1] == nums[r])
                    r--;
            }else if(nums[l] + nums[r] + target <0)
                l++;
            else
                r--;
        }
    }
	
	
	public static void main(String[] args){
		//int[] input={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int[] input ={-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = threeSum(input);
		for(List<Integer> l : res){
			for(int i: l)
				System.out.print(i+" ");
			System.out.println();
		}
	}
}
