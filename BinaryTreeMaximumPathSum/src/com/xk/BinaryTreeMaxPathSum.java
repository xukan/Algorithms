package com.xk;
<<<<<<< HEAD
/*
 * ��������Ǳ���������ͼ��Ѱ��·����
 * һ���ڵ�������·���������������ķ���ֵ(�������0)����������������ֵ(�������0)�����Ͻڵ������ֵ
 * �㷨�ı��ʻ���һ�����ı��������Ը��Ӷ���O(n)�����ռ�����Ȼ��ջ��СO(logn)��
 * 
 *                5
 *              /   \
 *             4     8
 *            /    /   \  
 *           11   13    4 
 *          /  \       / \
 *         7    2     5   1
 * */
public class BinaryTreeMaxPathSum {
	int max; 
	 
//	public int maxPathSum(TreeNode root){
//		max = (root == null) ? 0: root.val;
//		findMax(root);
//		return max;
//	}
//	
//	public int findMax(TreeNode node) {
//		if (node == null)
//			return 0;
//		
//		// recursively get sum of left and right path
//		int left = Math.max(findMax(node.left), 0);
//		int right = Math.max(findMax(node.right), 0);
// 
//		//update maximum here
//		max = Math.max(node.val + left + right, max);
//		//System.out.println(max);
//		// return sum of largest path of current node
//		return node.val + Math.max(left, right);
//	}
	
	
	public int maxPathSum(TreeNode root) {
        max = (root ==null)?0:root.val;
        findMax(root);
        return max;
    }
    
    public int findMax(TreeNode node){
    	if(node == null)
    		return 0;
//        if(node.left == null&& node.right == null)
//            return node.val;
    	//������������������У���ô����
    	//    -2
    	//    /
    	//   1
    	//���������max���޷���¼1����Ϊ������1��ʱ����Ϊ��Ҷ�ڵ�����ֱ�ӷ�����1��max��¼����߲���
    	//���һ��Ҫ�ӣ����Է������棺
        int left = Math.max(findMax(node.left), 0);
        int right = Math.max(findMax(node.right), 0);
        max = Math.max(node.val+left+right, max);
        //��������Ϳ��ԣ����ò��Ǻܴ�
//      if(node.left == null&& node.right == null)
//      	return node.val;
        return node.val + Math.max(left, right);
    }
	
	public static void main(String[] args){
//		 TreeNode root = new TreeNode(5);
//		 TreeNode node1 = new TreeNode(4);
//		 TreeNode node2 = new TreeNode(8);
//		 TreeNode node3 = new TreeNode(11);
//		 TreeNode node4 = new TreeNode(13);
//		 TreeNode node5 = new TreeNode(4);
//		 TreeNode node6 = new TreeNode(7);
//		 TreeNode node7 = new TreeNode(2);
//		 TreeNode node8 = new TreeNode(5);
//		 TreeNode node9 = new TreeNode(1);
//		 root.left=node1;
//		 root.right = node2;
//		 node1.left = node3;
//		 node2.left = node4;
//		 node2.right = node5;
//		 node3.left = node6;
//		 node3.right = node7;
//		 node5.left = node8;
//		 node5.right = node9;
		 
		 TreeNode root = new TreeNode(-2);
		 TreeNode node1 = new TreeNode(1);
		 root.left=node1;
		 
=======

public class BinaryTreeMaxPathSum {
	int max; 
	 
//	public int maxPathSum(TreeNode root) {
//		max = (root == null) ? 0 : root.val;
//		findMax(root);
//		return max;
//	}
	
	public int maxPathSum(TreeNode root){
		max = (root == null) ? 0: root.val;
		findMax(root);
		return max;
	}
	
	public int findMax(TreeNode node) {
		if (node == null)
			return 0;
		
		// recursively get sum of left and right path
		int left = Math.max(findMax(node.left), 0);
		int right = Math.max(findMax(node.right), 0);
 
		//update maximum here
		max = Math.max(node.val + left + right, max);
		//System.out.println(max);
		// return sum of largest path of current node
		return node.val + Math.max(left, right);
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
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		 BinaryTreeMaxPathSum res = new BinaryTreeMaxPathSum();
		 int maximum = res.maxPathSum(root);
		 System.out.println(maximum);
	}
}
