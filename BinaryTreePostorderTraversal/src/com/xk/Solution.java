package com.xk;

import java.util.*;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
             		while(root!=null || !stack.empty()){
			if(root!=null){
				stack.push(root);
				root = root.left;
			}else{
				TreeNode peekNode = stack.peek();
  				if(peekNode.right!=null && prev != peekNode.right){
  					//peekNode.right!=null && prev!=peekNode.right说明peekNode的右节点还没有被访问过 
  					//peekNode.right!=null && prev==peekNode.right说明peekNode的右节点已经被访问过 
					root = peekNode.right;
				}else{
					stack.pop();
  					res.add(peekNode.val);
					prev = peekNode;
				}	
			}
		}
		return res;
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
		 List<Integer> res = s.postorderTraversal(root);
		 for(Integer i : res)
			 System.out.print(i+" ");
		 System.out.println();
	}
}
