package com.xk;

/*    1
    /   \
   2     3
  / \    / 
 4   5  6
    / \
   7   8     */
//similar problem is: Minimum Depth of Binary Tree£¬ Balanced Binary Tree

public class Solution {
	public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int depth = Math.max(left, right)+1;
        return depth;
    }
	
	public static void main(String[] args) {
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
		node5.left = node7;
		node5.right = node8;
		 Solution s = new Solution();
//		 List<String> res = s.binaryTreePaths(root);
//		 for(String str : res)
//			 System.out.println(str+" ");
		 int d = s.maxDepth(node1);
		 System.out.println(d);
	}
}
