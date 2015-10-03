package com.xk;
<<<<<<< HEAD
//思路与Symmetric Tree完全一致
=======

>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p== null && q == null)
            return true;
        else if(p== null || q== null)
        	return false;
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
	
	public static void main(String[] args){
		TreeNode nodeleft1 = new TreeNode(1);
		TreeNode nodeleft2 = new TreeNode(2);
		TreeNode nodeleft3 = new TreeNode(3);
		TreeNode nodeleft4 = new TreeNode(4);
		TreeNode nodeleft5 = new TreeNode(5);
		nodeleft1.left = nodeleft2;
		nodeleft1.right = nodeleft3;
		nodeleft2.left = nodeleft4;
		nodeleft3.right = nodeleft5;
		
		TreeNode noderight1 = new TreeNode(1);
		TreeNode noderight2 = new TreeNode(2);
		TreeNode noderight3 = new TreeNode(3);
		TreeNode noderight4 = new TreeNode(4);
		TreeNode noderight5 = new TreeNode(5);
		noderight1.left = noderight2;
		noderight1.right = noderight3;
		noderight2.left = noderight4;
		noderight3.left = noderight5;
		
		Solution s = new Solution();
		boolean flag = s.isSameTree(nodeleft1, noderight1);
		
		System.out.println(flag);
	}
}
