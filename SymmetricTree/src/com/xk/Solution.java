package com.xk;

import java.util.*;

public class Solution {
<<<<<<< HEAD
	//递归的思路与Same tree完全一致
	// public boolean isSymmetric(TreeNode root) {
    //     if(root == null)
    //         return true;
    //     return helper(root.left, root.right);
    // }
    
    // public boolean helper(TreeNode node1, TreeNode node2){
    //     if(node1==null && node2== null)
    //         return true;
    //     if(node1 == null || node2 == null)
    //         return false;
    //     return (node1.val == node2.val) && helper(node1.left, node2.right) && helper(node1.right, node2.left);
    // }
=======
//	public boolean isSymmetric(TreeNode root) {
//		if(root == null)
//			return true;
//		return isSymmetric(root.left, root.right);
//	}
//	
//	public boolean isSymmetric(TreeNode l, TreeNode r){
//		if(l == null && r == null)
//			return true;
//		else if(l == null || r == null)
//			return false;
//		
//		if(l.val != r.val)
//			return false;
//		if(!isSymmetric(l.left, r.right))
//			return false;
//		if(!isSymmetric(l.right, r.left))
//			return false;
//		return true;
//	}
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	
	public void enqueue(TreeNode node, Queue<TreeNode> q, TreeNode nullNode){
        if(node!=null)
            q.add(node);
        else
            q.add(nullNode);
    }
    
    public boolean isSymmetric(TreeNode root){
        if(root == null)
            return true;
        Queue<TreeNode> ql = new LinkedList<TreeNode>();
        Queue<TreeNode> qr = new LinkedList<TreeNode>();
        TreeNode nullNode = new TreeNode(Integer.MIN_VALUE);
        enqueue(root.left,ql,nullNode);
        enqueue(root.right,ql,nullNode);
        while(!ql.isEmpty()&&!qr.isEmpty()){
            TreeNode tl = ql.remove();
            TreeNode tr = qr.remove();
            if(tl.val == tr.val){
                if(tl.left!=null&&tr.right!=null){
                    enqueue(tl.left, ql, nullNode);
                    enqueue(tr.right, qr, nullNode);
                }
                
                if(tl.right!=null&&tr.left!=null){
                    enqueue(tl.right, ql, nullNode);
                    enqueue(tr.left, qr, nullNode);
                }
                
                if((tl.left == null)&&(tr.right!=null)||
                   (tl.left != null)&&(tr.right==null)||
                   (tl.right == null)&&(tr.left!=null)||
                   (tl.right != null)&&(tr.left==null))
                   return false;
            }else
                return false;
        }
        return ql.isEmpty()&&qr.isEmpty();
    }

	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
<<<<<<< HEAD
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(4);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		node2.right = node6;
		node3.left = node7;
=======
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(2);
//		TreeNode node4 = new TreeNode(3);
//		TreeNode node5 = new TreeNode(3);
//		TreeNode node6 = new TreeNode(4);
//		TreeNode node7 = new TreeNode(4);
//		node1.left =node2;
//		node1.right = node3;
//		node2.left = node4;
//		node3.right = node5;
//		node2.right = node6;
//		node3.left = node7;
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		Solution s = new Solution();
		boolean res = s.isSymmetric(node1);
		System.out.println(res);
	}
}
