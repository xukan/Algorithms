package com.xk;

import java.util.*;

public class Solution {
//	public void flatten(TreeNode root) {
//        if(root == null)
//            return;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        preorderTraversal(root, queue);
//        queue.poll();
//        TreeNode curr = root;
//        while(!queue.isEmpty()){
//            curr.right = queue.poll();
//            curr = curr.right;
//        }
//    }
//    
//    public void preorderTraversal(TreeNode root, Queue<TreeNode> queue){
//        if(root == null)
//            return;
//        queue.offer(root);
//        preorderTraversal(root.left, queue);
//        preorderTraversal(root.right,queue);
//    }
	
	public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null) return;
        
        TreeNode prev = null;        
        stack.push(root);
        while(!stack.empty()){
            TreeNode curr= stack.pop();
            if(curr.right!=null)
                stack.push(curr.right);
            if(curr.left!=null)
                stack.push(curr.left);
            if(prev!=null){
                prev.left = null;
                prev.right = curr;
            }
            prev = curr;
        }
    }
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6; 
		node6.left = node7;
		node6.right = node8;
		Solution s = new Solution();
		s.flatten(node1);
		while(node1!=null){
			System.out.println(node1.val);
			node1=node1.right;
		}
	}
}
