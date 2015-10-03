package com.xk;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
	public TreeNode invertTree(TreeNode root) {
		
		if(root == null)
            return root;
		TreeNode left = root.left;
		TreeNode right = root.right;
		/*
		 * 这道题需要注意的是不能写成:
		 * root.left = invertTree(root.right);
		 *  root.right = invertTree(root.left);
		 *  在root.left这一行，root.left的值已经发生改变，下一行中的root.left的值已经是原root.right中的值了，
		 *  因此，需要在上面用left,right先把root.left和root.right的值先保存下来 
		*/
		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
		
//        if(root == null)
//            return root;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//        	TreeNode node = queue.poll();
//        	TreeNode left = node.left;
//        	node.left = node.right;
//        	node.right = left;
//        	if(node.left!= null)
//        		queue.offer(node.left);
//        	if(node.right!=null)
//        		queue.offer(node.right);
//        }
//        return root;
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
		Solution s = new Solution();
		TreeNode res = s.invertTree(node1);
		System.out.println(res);
	}
}
