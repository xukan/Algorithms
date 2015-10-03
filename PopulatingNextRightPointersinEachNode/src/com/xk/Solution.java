package com.xk;

import java.util.*;
//此解法适合任意情况的二叉树（满或非满）
public class Solution {
	public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> children = new LinkedList<TreeLinkNode>();
        root.next = null;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeLinkNode node = queue.poll();
            // if(queue.isEmpty())
            //     node.next = null;
            if(node.left!=null)
                children.offer(node.left);
            if(node.right!=null)
                children.offer(node.right);
            if(queue.isEmpty()&&!children.isEmpty()){
            	TreeLinkNode head = children.peek();
            	TreeLinkNode kid = children.poll();
            	//while中判断children.peek()!=null是为了应对非满二叉树的情况
            	//例如       1
            	//    /
            	//   2 
            	//这时如果没有children.peek()!=null判断，下面的while将无法跳出循环
            	while(children.peek()!=null&&children.peek()!=head){
                    kid.next = children.peek();
                    children.add(kid);
                    kid = children.poll();
                }
                kid.next = null;
                children.add(kid);
                queue = children;
                children = new LinkedList<TreeLinkNode>();//children必须重新生成一个，否则queue会随着children的变化而变化
            }
        }
        //return root;
    }
	
	public static void main(String[] args){
		 TreeLinkNode root = new TreeLinkNode(1);
		 TreeLinkNode node1 = new TreeLinkNode(2);
		 TreeLinkNode node2 = new TreeLinkNode(3);
		 TreeLinkNode node3 = new TreeLinkNode(4);
		 TreeLinkNode node4 = new TreeLinkNode(5);
		 TreeLinkNode node5 = new TreeLinkNode(6);
		 TreeLinkNode node6 = new TreeLinkNode(7);
		 TreeLinkNode node7 = new TreeLinkNode(2);
		 TreeLinkNode node8 = new TreeLinkNode(5);
		 TreeLinkNode node9 = new TreeLinkNode(1);
		 root.left=node1;
//		 root.right = node2;
//		 node1.left = node3;
//		 node1.right = node4;
//		 node2.left = node5;
//		 node2.right = node6;
//		 node3.left = node6;
//		 node3.right = node7;
//		 node5.left = node8;
//		 node5.right = node9;
		 Solution s = new Solution();
		 s.connect(root);
//		 for(Integer i : res)
//			 System.out.print(i+" ");
//		 System.out.println();
	} 
}
