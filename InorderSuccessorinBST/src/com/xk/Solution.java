package com.xk;

import java.util.ArrayList;

/*
 * 1. if p.right!=null, successor of p must be the minimum node of the right subtree
 * 2. if p.right == null, successor of p must be the minimum node which is greater than p's value.
 * we can start from the root node. 
 * If root.val > p.val, then we go to the left subtree because we wanna try a smaller one. However, we need to save this node 
 * caz it is possible that root.left < p.val. 
 * If root.val < p.val, then we go to the right subtree.
 * 
 * Reference:
 * http://buttercola.blogspot.com/2015/10/leetcode-inorder-successor-in-bst.html
 * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 * */
/*
 *                        20
 *                       /    \
 *                    15      25
 *                   /     \
 *                 10     18
 *                         /    \          
 *                       16    19      
 *                          \
 *                          17
 * */

public class Solution {
	public static  TreeNode root=null;
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root ==null || p == null)
			return null;
		//case1:
		if(p.right != null)
			return findMin(p.right);
		//case2:
		TreeNode succ = null, q=root;
		
		while(q != null){
			if(q.val>p.val){
				succ = q;
				q = q.left;
			} else if( q.val <p.val)
				q = q.right;
			else
				break;
		}
		return succ;
	}
	
	public static TreeNode findMin(TreeNode node){
		while(node.left!=null)
			node = node.left;
		return node;
	}
	
	public static void display(TreeNode root){
		if(root!=null){
			display(root.left);
			System.out.print(root.val+" " );
			display(root.right);
		}
	}
	
	public static void insert(TreeNode node){
		if(root ==null){
			root = node;
			return;
		}
		TreeNode cur = root;
		TreeNode parent = null;
		while(true){
			parent = cur;
			if(node.val < cur.val){
				cur = cur.left;
				if(cur == null){
					parent.left = node;
					return;
				}
			}else{
				cur = cur.right;
				if(cur == null){
					parent.right = node;
					return;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		 TreeNode node1 = new TreeNode(3);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(1);
		 TreeNode node4 = new TreeNode(4);
		 TreeNode node5 = new TreeNode(6);
		 TreeNode node6 = new TreeNode(2);
		 TreeNode node7 = new TreeNode(10);
		 TreeNode node8 = new TreeNode(9);
		 TreeNode node9 = new TreeNode(20);
		 TreeNode node10 = new TreeNode(25);
		 TreeNode node11= new TreeNode(15);
		 TreeNode node12 = new TreeNode(16);
		 insert(node1);
		 insert(node2);
		 insert(node3);
		 insert(node4);
		 insert(node5);
		 insert(node6);
		 insert(node7);
		 insert(node8);
		 insert(node9);
		 insert(node10);
		 insert(node11);
		 insert(node12);
		 display(root);
		 System.out.println();
		 System.out.println(node4.val);
		 TreeNode res1= inorderSuccessor(root, node4);
		 System.out.println(res1.val);
	}
}
