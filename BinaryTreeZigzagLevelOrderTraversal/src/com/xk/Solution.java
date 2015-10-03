package com.xk;

import java.util.*;

public class Solution {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null)
			return res;
//        boolean order = true;
//        ArrayList<TreeNode> toVisit = new ArrayList<TreeNode>();
//        toVisit.add(root);
//        while(!toVisit.isEmpty()){
//            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
//            ArrayList<Integer> temp = new ArrayList<Integer>();
//            for(TreeNode node:toVisit){
//                temp.add(node.val);
//            }
//            res.add(temp);
//            for(int i=toVisit.size()-1;i>=0;i--){
//                TreeNode node = toVisit.get(i);
//                if(order){
//                    if(node.right!=null) next.add(node.right);
//                    if(node.left!=null) next.add(node.left);
//                }else{
//                    if(node.left!=null) next.add(node.left);
//                    if(node.right!=null) next.add(node.right);
//                }
//            }
//            order = order?false:true;
//            toVisit = new ArrayList<TreeNode>(next);
//        }
//        return res;
		
		boolean order = true;
		ArrayList<TreeNode> toVisit = new ArrayList<TreeNode>();
		toVisit.add(root);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		while(!toVisit.isEmpty()){
			ArrayList<TreeNode> children = new ArrayList<TreeNode>();
			for(TreeNode node:toVisit)
				temp.add(node.val);
			res.add(new ArrayList<Integer>(temp));
			for(int i=toVisit.size()-1;i>=0;i--){
				TreeNode curr = toVisit.get(i);
				if(order){
					if(curr.right!=null)
						children.add(curr.right);
					if(curr.left!=null)
						children.add(curr.left);
				}else{
					if(curr.left!=null)
						children.add(curr.left);
					if(curr.right!=null)
						children.add(curr.right);
				}
			}
			temp.clear();
			toVisit = children;
			order = order?false:true;
		}
		return res;
    }
	
	public static void main(String[] args){
		//Tree for traversal
		 TreeNode traversalRoot = new TreeNode(5);
		 TreeNode traversalNode1 = new TreeNode(4);
		 TreeNode traversalNode2 = new TreeNode(8);
		 TreeNode traversalNode3 = new TreeNode(11);
		 TreeNode traversalNode4 = new TreeNode(13);
		 TreeNode traversalNode5 = new TreeNode(4);
		 TreeNode traversalNode6 = new TreeNode(7);
		 TreeNode traversalNode7 = new TreeNode(2);
		 TreeNode traversalNode8 = new TreeNode(5);
		 TreeNode traversalNode9 = new TreeNode(1);
		 traversalRoot.left=traversalNode1;
		 traversalRoot.right = traversalNode2;
		 traversalNode1.left = traversalNode3;
		 traversalNode2.left = traversalNode4;
		 traversalNode2.right = traversalNode5;
		 traversalNode3.left = traversalNode6;
		 traversalNode3.right = traversalNode7;
		 traversalNode5.left = traversalNode8;
		 traversalNode5.right = traversalNode9;
		 
		 System.out.println("ZigzagLevelorder traversal of the tree is: ");
			List<List<Integer>> levelorderTraversal = zigzagLevelOrder(traversalRoot);
			for(List<Integer> l:levelorderTraversal){
				for(int i: l)
					System.out.print(i+" ");
				System.out.println();
			}
	}
	
}
