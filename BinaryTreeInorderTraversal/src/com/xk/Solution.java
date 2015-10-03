package com.xk;

import java.util.*;
//Morris Algorithm
/*
 * �㷨�����������£�
1. �����ǰ��������Ϊ�գ��������ǰ��㲢���䵱ǰ�ڵ㸳ֵΪ�Һ��ӡ�
2. �����ǰ�ڵ�����Ӳ�Ϊ�գ���Ѱ�ҵ�ǰ�ڵ�����������µ�ǰ���ڵ㣨Ҳ���ǵ�ǰ��������������Һ��ӣ��������������������
 a) ���ǰ���ڵ���Һ���Ϊ�գ��������Һ�������Ϊ��ǰ�ڵ㣨������ʹ���Ժ�������·��ظ���㣩��Ȼ�󽫵�ǰ�ڵ����Ϊ��ǰ�ڵ�����ӡ�
 b) ���ǰ���ڵ���Һ���Ϊ��ǰ�ڵ㣬�����������Ѿ������꣬���Է��ʵ�ǰ�ڵ㡣�������Һ���������Ϊ�գ��ָ����Ľṹ���������ǰ�ڵ㡣
             ��ǰ�ڵ����Ϊ��ǰ�ڵ���Һ��ӡ�*/
public class Solution {
//	public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        if(root == null)
//            return list;
//        TreeNode curr = root, prev = null;
//        while(curr!=null){
//            if(curr.left == null){
//                list.add(curr.val);
//                curr = curr.right;
//            }else{
//                prev = curr.left;
//                while(prev.right!=null && prev.right != curr)
//                    prev = prev.right;
//                if(prev.right == null){
//                    prev.right = curr;
//                    curr = curr.left;
//                }
//                else{
//                    prev.right = null;
//                    list.add(curr.val);
//                    curr = curr.right;
//                }
//            }
//        }
//        return list;
//    }
	
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();  
	    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  
	    while(root!=null || !stack.isEmpty())  
	    {  
	        if(root!=null)  
	        {  
	        	res.add(root.val);
	            stack.push(root);  
	            root = root.left;  
	        }  
	        else  
	        {  
	            root = stack.pop();  
	            //res.add(root.val);  
	            root = root.right;  
	        }  
	    }  
	    return res;   
	}
	
	public static void main(String[] args){
		 TreeNode root = new TreeNode(5);
		 TreeNode node1 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(11);
		 TreeNode node4 = new TreeNode(13);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(7);
		 TreeNode node7 = new TreeNode(2);
		 TreeNode node8 = new TreeNode(5);
		 TreeNode node9 = new TreeNode(1);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;
		 node5.left = node8;
		 node5.right = node9;
		 Solution s = new Solution();
		 List<Integer> res = s.inorderTraversal(root);
		 for(Integer i : res)
			 System.out.print(i+" ");
		 System.out.println();
	} 
}
