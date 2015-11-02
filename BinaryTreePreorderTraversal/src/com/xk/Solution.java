package com.xk;

import java.util.*;
/*
 *                         5
 *                       /    \
 *                     4       8
 *                   /        /    \
 *                 11      13    4
 *               /    \            /  \
 *              7     2         5    1
 * */
// preorder traversal : 5 4 11 7 2 8 13 4 5 1 
//Morris algorithm:
/*
 *  如果当前节点左子树为空，那么输出此节点，并置当前节点为此节点的右孩子
 *  如果当前节点左子树不为空，那么找到此节点在中序遍历下的父节点(左子树的最右节点)，
 *  1)如果父节点的右孩子为空，那么输出此节点，设置父节点的右孩子为当前节点，当前节点变为此节点的左孩子
 *  2)如果父节点的右孩子不为空，说明当前节点已经被遍历过了，父节点的右孩子置为空，当前节点变为此节点的右孩子 
 * */
public class Solution {
	//Morris Traversal
	//Time Complexity: O(n)
	//Space Complexity: O(1)
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null)
			return list;
		TreeNode cur = root, prev = null;
		while(cur!=null){
			if(cur.left ==null){
				list.add(cur.val);
				cur = cur.right;
			}else{
				prev = cur.left;
				while(prev.right !=null && prev.right!=cur)
					prev = prev.right;
				if(prev.right == null){
					list.add(cur.val);
					prev.right = cur;
					cur = cur.left;
				}else{
					prev.right = null;
					cur = cur.right;
				}
			}
		}
		return list;
	}
	
	/*
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || ! stack.empty()){
			if(root!=null){

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
	*/
		
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
		 List<Integer> res = preorderTraversal(root);
		 for(Integer i : res)
			 System.out.print(i+" ");
		 System.out.println();
	} 
}
