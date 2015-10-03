package com.xk;

import java.util.*;
<<<<<<< HEAD
/*
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       / \     / \
 *      7   2   5   1
 * */
=======

>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || ! stack.empty()){
<<<<<<< HEAD
			if(root!=null){ 
=======
			if(root!=null){
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
				list.add(root.val);
				stack.push(root);
				root= root.left;
			}else{
				root = stack.pop();
				root = root.right;
			}
		}
		return list;
		
		
	}
	
		
	public static void main(String[] args){
		 TreeNode root = new TreeNode(5);
		 TreeNode node1 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(11);
		 TreeNode node4 = new TreeNode(13);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(7);
		 TreeNode node7 = new TreeNode(2);
		 TreeNode node8 = new TreeNode(5);
		 TreeNode node9 = new TreeNode(1);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;
		 node5.left = node8;
		 node5.right = node9;
		 Solution s = new Solution();
		 List<Integer> res = s.preorderTraversal(root);
		 for(Integer i : res)
			 System.out.print(i+" ");
		 System.out.println();
	} 
}
