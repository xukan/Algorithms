package com.xk;

import java.util.*;
/*
 *                5
 *              /   \
 *             4     8
 *            /    /   \  
 *           11   13    4 
 *          /  \         \
 *         7    2         1
 *         
 * 
 * */
public class Solution {
//	List<String> res = new ArrayList<String>();
//    
//    public List<String> binaryTreePaths(TreeNode root) {
//        if(root != null) 
//            findPaths(root,String.valueOf(root.val));
//        return res;
//    }
//    
//    private void findPaths(TreeNode n, String path){
//        if(n.left == null && n.right == null) 
//            res.add(path);
//        if(n.left != null)
//            findPaths(n.left, path+"->"+n.left.val);
//        if(n.right != null)
//            findPaths(n.right, path+"->"+n.right.val);
//    }
    int min;
	public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        min = Integer.MAX_VALUE;
        min = helper(root, 0);
        return min;
    }
    
    public int helper(TreeNode node, int count){
        if(node== null)
            return count;
        count++;
        int left = helper(node.left, count);
        int right = helper(node.right, count);
        min = Math.min(count, min);
        return Math.min(left, right);
    }
	
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5);
		 TreeNode node1 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(11);
		 TreeNode node4 = new TreeNode(13);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(7);
		 TreeNode node7 = new TreeNode(2);
		 TreeNode node8 = new TreeNode(1);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;
		 node5.right = node8;
		 Solution s = new Solution();
//		 List<String> res = s.binaryTreePaths(root);
//		 for(String str : res)
//			 System.out.println(str+" ");
		 int d = s.minDepth(root);
		 System.out.println(d);
	}
}
