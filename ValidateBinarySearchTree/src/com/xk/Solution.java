package com.xk;

import java.util.*;

public class Solution {
	
	//Use inorder traverse to check a binary search tree, awesome!
	public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root, pre);
    }
    public boolean helper(TreeNode root, ArrayList<Integer> pre)
    {
        if(root == null)
            return true;
        boolean left = helper(root.left,pre);
        if(pre.get(0)!=null && root.val<=pre.get(0))
            return false;
        pre.set(0,root.val);
        return left && helper(root.right,pre);
    }
	
<<<<<<< HEAD
=======
	
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(10);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		Solution s = new Solution();
		boolean res = s.isValidBST(node1);
		System.out.println(res);
	}
}
