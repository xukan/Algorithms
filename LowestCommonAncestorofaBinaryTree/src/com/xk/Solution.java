package com.xk;
/*
 * O(n^2)的解法很直观：top-down地看每个root是否cover both nodes
          然后是O(n)的解法：bottom-up地找cover了哪些node。
          对于树来说，bottom-up这个概念不是很直观：访问都是从root开始向leaf走，怎么会bottom-up。
         而实际上，这里的bottom-up是指：在访问到leaf后结果按照bottom-up的方式向上传递。
        之前top-down approach是每次都检查两边的子树，然后进入一棵，再检查其子树，重复的部分在于：子树可能被多次check。
        而通过bottom-up的方式，信息流只需要一次就能到位。
 * 
 * 
 * 
 * 树的recursive算法不一定要先判断当前节点再判断子树，如果子树的信息对于当前节点有用，则可以颠倒顺序变成bottom-up的方式
 * 树的bottom-up方式和top-down方式的主要差别就在于：先处理当前节点还是先处理子树
 * recursion时，返回的值不一定要是最终的是否判断。也可以返回其他包含信息量更多的内容。
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
