package com.xk;

//�õ����ֲ��ҵ�һ�����ۣ����û���ҵ�Ŀ��Ԫ�أ���ô��ֹͣʱ��Lǡ��ͣ�ڱ�Ŀ��Ԫ��λ�ô��index�ϣ�Rǡ��ͣ�ڱ�Ŀ��Ԫ��λ��С��index�ϡ�
//ʵ�����õ�����Search Insert Position���ᵽ�ķ��������Ա�֤����������ʱ��l��r��ͣ��λ��������Ŀ�����ĺ����ǰ�档
//���ֲ��ҵ���Ŀ���ǱȽϳ�����
public class Solution {
	public static int[] searchRange(int[] nums, int target) {
        int[] res ={-1,-1};
        if(nums==null || nums.length==0)  
        {  
            return res;  
        }  
        int ll=0, lr=nums.length-1;
        while(ll<=lr)//������ҵ�whileѭ��������<=
        {
        	int m = (ll+lr)/2;
        	if(nums[m]<target)
        		ll = m+1;
        	else
        		lr=m-1;//���ʱ����ƽ�,   �������ll������߽�
        }
        int rl=0, rr=nums.length-1;
        while(rl<=rr){
        	int m = (rl+rr)/2;
        	if(nums[m]<=target)//���ʱ��������ұƽ�
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
	
	//�ݹ鷨
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
