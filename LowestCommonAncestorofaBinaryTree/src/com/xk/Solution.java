package com.xk;
/*
 * O(n^2)�Ľⷨ��ֱ�ۣ�top-down�ؿ�ÿ��root�Ƿ�cover both nodes
          Ȼ����O(n)�Ľⷨ��bottom-up����cover����Щnode��
          ��������˵��bottom-up�������Ǻ�ֱ�ۣ����ʶ��Ǵ�root��ʼ��leaf�ߣ���ô��bottom-up��
         ��ʵ���ϣ������bottom-up��ָ���ڷ��ʵ�leaf��������bottom-up�ķ�ʽ���ϴ��ݡ�
        ֮ǰtop-down approach��ÿ�ζ�������ߵ�������Ȼ�����һ�ã��ټ�����������ظ��Ĳ������ڣ��������ܱ����check��
        ��ͨ��bottom-up�ķ�ʽ����Ϣ��ֻ��Ҫһ�ξ��ܵ�λ��
 * 
 * 
 * 
 * ����recursive�㷨��һ��Ҫ���жϵ�ǰ�ڵ����ж������������������Ϣ���ڵ�ǰ�ڵ����ã�����Եߵ�˳����bottom-up�ķ�ʽ
 * ����bottom-up��ʽ��top-down��ʽ����Ҫ�������ڣ��ȴ�����ǰ�ڵ㻹���ȴ�������
 * recursionʱ�����ص�ֵ��һ��Ҫ�����յ��Ƿ��жϡ�Ҳ���Է�������������Ϣ����������ݡ�
 * */
public class Solution {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 if (root == null || root == p || root == q)
		 // found p or q or touch the ground
			 return root;

		 // search p and q from left and right
		 TreeNode left = lowestCommonAncestor(root.left, p, q);
		 TreeNode right = lowestCommonAncestor(root.right, p, q);

		 if (left != null && right != null)
		 // from root's left & right we found both p and q, so root is the LCA
			 return root;
		 else
		 // left is not null means from left's left & right we found both q and q
		 // so left is the LCA, otherwise, right is the answer
		 return left != null ? left : right;
	}
	
	public static void main(String[] args){
		 TreeNode root = new TreeNode(3);
		 TreeNode node1 = new TreeNode(5);
		 TreeNode node2 = new TreeNode(1);
		 TreeNode node3 = new TreeNode(6);
		 TreeNode node4 = new TreeNode(2);
		 TreeNode node5 = new TreeNode(0);
		 TreeNode node6 = new TreeNode(8);
		 TreeNode node7 = new TreeNode(7);
		 TreeNode node8 = new TreeNode(4);
		 //TreeNode node9 = new TreeNode(1);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node1.right = node4;
		 node4.left = node7;
		 node4.right = node8;
		 node2.left = node5;
		 node2.right = node6;

		 TreeNode res = lowestCommonAncestor(root, node8, node6);
		 System.out.println(res.val);
	}
}