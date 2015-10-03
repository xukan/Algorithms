package com.xk;

import java.util.*;
<<<<<<< HEAD
/*
 *                5
 *              /   \
 *             4     8
 *            /    /   \  
 *           11   13    4 
 *          /  \         \
 *         7    2         1
 *         
 * 这道题和Sum Root to Leaf Numbers 思路基本相同
 * */
public class pathSum {
//	 public boolean hasPathSum(TreeNode root, int sum) {
=======

public class pathSum {
	 public boolean hasPathSum(TreeNode root, int sum) {
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
//	        if(root == null) return false;
//	 
//	        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
//	        LinkedList<Integer> values = new LinkedList<Integer>();
//	 
//	        nodes.add(root);
//	        values.add(root.val);
//	 
//	        while(!nodes.isEmpty()){
//	            TreeNode curr = nodes.poll();
//	            int sumValue = values.poll();
//	 
//	            if(curr.left == null && curr.right == null && sumValue==sum){
//	                return true;
//	            }
//	 
//	            if(curr.left != null){
//	                nodes.add(curr.left);
//	                values.add(sumValue+curr.left.val);
//	            }
//	 
//	            if(curr.right != null){
//	                nodes.add(curr.right);
//	                values.add(sumValue+curr.right.val);
//	            }
//	        }
//	 
//	        return false;
		 
<<<<<<< HEAD
//	 }
	 
	 public boolean hasPathSum(TreeNode root, int sum) {
	        if(root == null)
	            return false;
	        return helper(root, 0, sum);
	    }
	    
	    public boolean helper(TreeNode node, int value, int sum){
	        if(node == null)
	            return false;
	        value += node.val;
	        if(node.left == null && node.right == null){
	            if(value == sum)
	                return true;
	        }
	        return helper(node.left, value, sum)|| helper(node.right, value, sum);
	    }
=======
		
		 if (root == null)
				return false;
			if (root.val == sum && (root.left == null && root.right == null))
				return true;
		 
			return hasPathSum(root.left, sum - root.val)
					|| hasPathSum(root.right, sum - root.val);
	 }
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	 
	 public static void main(String[] args){
		 TreeNode root = new TreeNode(5);
		 TreeNode node1 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(11);
		 TreeNode node4 = new TreeNode(13);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(7);
		 TreeNode node7 = new TreeNode(2);
		 TreeNode node8 = new TreeNode(1);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;
		 node5.right = node8;
		 int sum = 22;
		 pathSum ps = new pathSum();
		 boolean judge = ps.hasPathSum(root, sum);
		 System.out.println(judge);
	 }
}
