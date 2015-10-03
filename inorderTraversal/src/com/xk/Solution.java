package com.xk;

import java.util.*;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    TreeNode cur = root;
	    TreeNode pre = null;
	    while(cur != null)
	    {
	        if(cur.left == null)
	        {
	            res.add(cur.val);
	            cur = cur.right;
	        }
	        else
	        {
	            pre = cur.left;
	            while(pre.right!=null && pre.right!=cur)
	                pre = pre.right;
	            if(pre.right==null)
	            {
	                pre.right = cur;
	                cur = cur.left;
	            }
	            else
	            {
	                pre.right = null;
	                res.add(cur.val);
	                cur = cur.right;
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
		 List<Integer> res = s.inorderTraversal(root);
		 for(Integer i : res)
			 System.out.print(i+" ");
		 System.out.println();
	}
}
