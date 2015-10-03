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


public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        TreeNode root = helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
        return root;
    }
    
    public TreeNode helper(int[] inorder, int inl, int inr, int[] postorder, int pol, int por, HashMap<Integer, Integer> map){
        if(inl>inr||pol>por)
            return null;
        int index = map.get(postorder[por]);
        TreeNode root = new TreeNode(postorder[por]);
        root.left= helper(inorder, inl, index-1, postorder, pol, pol+index-inl-1, map);
        root.right = helper(inorder, index+1, inr, postorder, pol+index-inl, por-1, map);
        return root;
    }
    
    public static void main(String[] args){
		int[] postorder = {7,2,11,4,13,9,1,3,8,5};
		int[] inorder =  {7,11,2,4,5,13,8,9,3,1};
		Solution s = new Solution();
		TreeNode root = s.buildTree(inorder, postorder);
		System.out.println(root.val);
	}
}
