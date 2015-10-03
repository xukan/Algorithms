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
//˼·�ǹؼ���ǰ���������ĵ�һ��Ԫ�ؾ��Ǹ��ڵ㣬���˸��ڵ㣬�Ϳ�������������Ľ����ȷ��������������������⣺
//int[] preorder = {5,4,11,7,2,8,13,3,9,1};
//int[] inorder =  {7,11,2,4,5,13,8,9,3,1};
//���ڵ���5����ô�����������Կ�������������7,11,2,4,��������13,8,9,3,1
//������������������7,11,2,4,�ص�ǰ������п��Կ���4�Ǹ��ڵ�,��������7,11,2��������Ϊ��
//�������ȷ�������Ĺ����ǵݹ����
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
