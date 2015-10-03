package com.xk;

import java.util.*;

//二叉树的层次遍历，每层按照从右向左的顺序依次访问节点
//similar problem: 
//Binary Tree Zigzag Level Order Traversal, Binary Tree Zigzag Level Order Traversal II
public class binaryTreeRightSideView {
	public static List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> rightView = new ArrayList<Integer>();//只需在后面添加数据，并需要随机访问
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();//需要在前面或中间添加或删除数据
		if(root==null)
			return rightView;
		queue.add(root);
		while(queue.size()>0){
			int size=queue.size();
			for(int i=0;i<size;i++){
				TreeNode top=queue.remove();
				  //the first element in the queue (right-most of the tree)
				if(i==0)
					rightView.add(top.val);
				if(top.right!=null)
					queue.add(top.right);
				if(top.left!=null)
					queue.add(top.left);
			}
		}
		return rightView;
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);

		TreeNode firstLeft = new TreeNode(2);
		TreeNode firstRight = new TreeNode(3);
		TreeNode secondLeft = new TreeNode(5);
//		TreeNode secondRight = new TreeNode(4);
		List<TreeNode> list = new LinkedList<TreeNode>();
		root.left=firstLeft;
		root.right=firstRight;
		firstLeft.left= secondLeft;
//		firstRight.right = secondRight;
		list.add(root); 
		list.add(firstLeft);
		list.add(firstRight);
		list.add(secondLeft);
//		list.add(secondRight);
		List<Integer> rightView = new LinkedList<Integer>();
		rightView=rightSideView(root);
		Iterator<Integer> it= rightView.iterator();
		while(it.hasNext()){
			int x=it.next();
			System.out.print(x+" ");
		}
	}
}
