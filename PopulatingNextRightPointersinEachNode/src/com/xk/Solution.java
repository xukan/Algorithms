package com.xk;

import java.util.*;
//�˽ⷨ�ʺ���������Ķ����������������
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
            	//while���ж�children.peek()!=null��Ϊ��Ӧ�Է��������������
            	//����       1
            	//    /
            	//   2 
            	//��ʱ���û��children.peek()!=null�жϣ������while���޷�����ѭ��
            	while(children.peek()!=null&&children.peek()!=head){
                    kid.next = children.peek();
                    children.add(kid);
                    kid = children.poll();
                }
                kid.next = null;
                children.add(kid);
                queue = children;
                children = new LinkedList<TreeLinkNode>();//children������������һ��������queue������children�ı仯���仯
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
