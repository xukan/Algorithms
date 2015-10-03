package com.xk;

import java.util.*;

/*           Tree
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  3
 *       / \     / \
 *      7   2   9   1
 * */
//思路是关键，前序遍历结果的第一个元素就是根节点，有了根节点，就可以在中序遍历的结果中确定左右子树。比如这道题：
//int[] preorder = {5,4,11,7,2,8,13,3,9,1};
//int[] inorder =  {7,11,2,4,5,13,8,9,3,1};
//根节点是5，那么由中序结果可以看到，左子树是7,11,2,4,右子树是13,8,9,3,1
//接下来，对于左子树7,11,2,4,回到前序遍历中可以看出4是根节点,左子树是7,11,2，右子树为空
//所以这个确定子树的过程是递归查找
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null)
			return null;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<inorder.length;i++)
			map.put(inorder[i], i);
		TreeNode root = helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1,map);
		return root;
	}
	
	public TreeNode helper(int[] preorder, int prel,int prer, int[] inorder, int inl, int inr, HashMap<Integer, Integer> map){
		if(prel>prer||inl>inr)
			return null;
		int index = map.get(preorder[prel]);
		TreeNode root = new TreeNode(preorder[prel]);
		root.left = helper(preorder, prel+1, index-inl+prel, inorder, inl, index-1, map);
		root.right = helper(preorder, index-inl+prel+1, prer, inorder, index+1, inr, map);
		return root;
	}
	
	public static void main(String[] args){
		int[] preorder = {5,4,11,7,2,8,13,3,9,1};
		int[] inorder =  {7,11,2,4,5,13,8,9,3,1};
		Solution s = new Solution();
		TreeNode root = s.buildTree(preorder, inorder);
		System.out.println(root.val);
	}
}
