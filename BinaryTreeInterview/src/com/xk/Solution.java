package com.xk;

import java.util.*;

public class Solution {
	//计算二叉树的结点总数
	//递归解法：
	public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left =getNodeNumRec(root.left);
        int right = getNodeNumRec(root.right);
        return left + right + 1;
    }
	
	//计算二叉树的结点总数
	//非递归解法：
	public static int getNodeNum(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int cnt = 0;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node.left!=null)
				queue.offer(node.left);
			if(node.right!=null)
				queue.offer(node.right);
			cnt++;
		}
		return cnt;
	}
	
	//2. 求二叉树的深度:
	/*  1
	  /   \
	 2     3
	/ \   / 
   4   5 6
        / \
       7   8     */
	//Maximum Depth of Binary Tree
	public static int getDepthRec(TreeNode root) {
		if(root == null)
			return 0;
		int left = getDepthRec(root.left);
		int right = getDepthRec(root.right);
		int depth = Math.max(left, right) + 1;
		return depth;
	}
	//求二叉树的最小深度/Minimum Depth of Binary Tree
	public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int minleft = minDepth(root.left);
        int minright = minDepth(root.right);
        if(minleft==0 || minright==0)
            return minleft>=minright?minleft+1:minright+1;
        return Math.min(minleft,minright)+1;
    }
	
	public static List<Integer> preorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root!=null || !stack.empty()){
			if(root != null){
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				//res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}
	
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root!=null || !stack.empty()){
			if(root!=null){
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}
	
	public static List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
		while(root!=null || !stack.empty()){
			if(root!=null){
				stack.push(root);
				root =root.left;
			}else{
				TreeNode peekNode = stack.peek();
				if(peekNode.right!=null && prev!=peekNode.right)
					root = peekNode.right;
				else{
					stack.pop();
					res.add(peekNode.val);
					prev = peekNode;
				}
			}
		}
		return res;
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> currQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> childrenQueue = new LinkedList<TreeNode>();
        currQueue.add(root);
        List<Integer> list = new ArrayList<Integer>();
        while(!currQueue.isEmpty()){
            TreeNode node = currQueue.poll();
            list.add(node.val);
            if(node.left!=null)
                childrenQueue.add(node.left);
            if(node.right!=null)
                childrenQueue.add(node.right);
            if(currQueue.isEmpty()){
                currQueue = childrenQueue;
                childrenQueue = new LinkedList<TreeNode>();//childrenQueue必须重新生成一个，否则queue会随着children的变化而变化
                res.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
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
		node6.left = node7;
		node6.right = node8;
		Solution s = new Solution();
		System.out.print("The total number of nodes in the tree is:");
		int nodeNum = s.getNodeNumRec(node1);
		int nodenum = s.getNodeNum(node1);
		System.out.println(nodeNum);
		System.out.println(nodenum);
		System.out.print("The depth of the tree is: ");
		int depth = s.getDepthRec(node1);
		System.out.println(depth);

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
//		System.out.println("Preorder traversal of the tree is: ");
//		List<Integer> preorder = s.preorderTraversal(traversalRoot);
//		for(int i: preorder) 
//			System.out.print(i+" ");
//		System.out.println();
//		System.out.println("Inorder traversal of the tree is: ");
//		List<Integer> inorder = s.inorderTraversal(traversalRoot);
//		for(int i: inorder) 
//			System.out.print(i+" ");
//		System.out.println();
//		System.out.println("Postorder traversal of the tree is: ");
//		List<Integer> postorder = s.postorderTraversal(traversalRoot);
//		for(int i: postorder) 
//			System.out.print(i+" ");
//		System.out.println();
		System.out.println("Levelorder traversal of the tree is: ");
		List<List<Integer>> levelorderTraversal = s.levelOrder(traversalRoot);
		for(List<Integer> l:levelorderTraversal){
			for(int i: l)
				System.out.print(i+" ");
			System.out.println();
		}
	}
}
