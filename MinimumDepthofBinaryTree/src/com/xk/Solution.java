package com.xk;
<<<<<<< HEAD
/*     1
	 /   \
    2     3
   / \    / 
  4   5  6
     / \
    7   8     */
public class Solution {

//	public int minDepth(TreeNode root) {
//        if(root == null)
//            return 0;
//        return helper(root, 0);
//    }
//    
//    public int helper(TreeNode node, int depth){
//        if(node == null)
//            return depth;
//        depth++;
//        if(node.left == null)
//        	return helper(node.right,depth);
//        if(node.right == null)
//        	return helper(node.left, depth);
//        int leftDepth = helper(node.left, depth);
//        int rightDepth = helper(node.right, depth);
//        return Math.min(leftDepth, rightDepth);
//    }
	
	public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int minleft = minDepth(root.left);
        int minright = minDepth(root.right);
        if(minleft==0 || minright==0)
            return minleft>=minright?minleft+1:minright+1;
        return Math.min(minleft,minright)+1;
    }
	
=======

public class Solution {
	public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root, 0);
    }
    
    public int helper(TreeNode node, int depth){
        if(node == null)
            return depth;
        depth++;
        if(node.left == null)
        	return helper(node.right,depth);
        if(node.right == null)
        	return helper(node.left, depth);
        int leftDepth = helper(node.left, depth);
        int rightDepth = helper(node.right, depth);
        return Math.min(leftDepth, rightDepth);
    }
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
<<<<<<< HEAD
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
=======
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node6 = new TreeNode(6);
		//TreeNode node7 = new TreeNode(7);
		node1.left =node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		Solution s = new Solution();
		int res = s.minDepth(node1);
		System.out.println(res);
	}
}
