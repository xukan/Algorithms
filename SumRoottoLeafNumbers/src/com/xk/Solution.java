package com.xk;

import java.util.*;
<<<<<<< HEAD
//similar problem：Path Sum
=======

>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
public class Solution {
	public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0, 0);
    }
    
    public int helper(TreeNode node, int num, int sum){
<<<<<<< HEAD
        if(node == null)
        	//注意leaf node的定义 
        	return 0;
=======
        if(node == null) return sum;
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
        
        num = num*10 + node.val;
        
        // leaf reached
        if(node.left == null && node.right == null) {
            sum += num;
            return sum;
        }
        
        // sum of left subtree + right subtree
        sum = helper(node.left, num, sum) + helper(node.right, num, sum);
        return sum;
    }
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		Solution s = new Solution();
		int res = s.sumNumbers(node1);
		System.out.println(res);
	}
}
