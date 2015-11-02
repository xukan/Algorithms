package com.xk;

import java.util.*;
//Morris Traversal Algorithm
//Time complexity: O(n)
//Space complexity: O(1)
/*
 * 这里需要先创建一个dummy节点，根节点作为dummy的左孩子，设cur为当前节点，prev为前驱节点，cur从dummy开始遍历
 * 如果左孩子为空，那么cur变为cur的右孩子
 * 如果左孩子不为空，找到cur在中序遍历下的前驱节点prev：
 * 1)如果prev的右孩子为空，那么prev.right = cur, cur更新为cur.left;
 * 2)如果prev的右孩子为cur，那么倒序输出cur.left到prev之间的节点(事实上，这些节点形成一条斜率为负的直线)，cur更新为cur.right
 * */
public class Solution {
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		TreeNode dummy = new TreeNode(0);
		dummy.left = root;
		TreeNode cur = dummy, prev = null;
		while(cur!=null){
			if(cur.left == null){
				cur = cur.right;
			}else{
				prev = cur.left;
				while(prev.right!=null && prev.right!=cur)
					prev = prev.right;
				if(prev.right == null){
					prev.right = cur;
					cur = cur.left;
				}else{//this condition means now prev.right = cur
					reverse(res, cur.left, cur);
					prev.right = null;
					cur = cur.right;
				}
			}
		}
		return res;
    }
	
	public static void reverse(List<Integer> res, TreeNode from, TreeNode to){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if(from == to){
			res.add(from.val);
		}else{
		while(from!=to){
			temp.add(from.val);
			from = from.right;
		}
			for(int i=temp.size()-1;i>=0;i--){
				res.add(temp.get(i));
			}
		}
	}
	
	
	/*
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
             		while(root!=null || !stack.empty()){
			if(root!=null){
				stack.push(root);
				root = root.left;
			}else{
				TreeNode peekNode = stack.peek();
  				if(peekNode.right!=null && prev != peekNode.right){
  					//peekNode.right!=null && prev!=peekNode.right说明peekNode的右节点还没有被访问过 
  					//peekNode.right!=null && prev==peekNode.right说明peekNode的右节点已经被访问过
					root = peekNode.right;
				}else{
					stack.pop();
  					res.add(peekNode.val);
					prev = peekNode;
				}	
			}
		}
		return res;
	}*/
	
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
		 
		 TreeNode test = new TreeNode(5);
		 Solution s = new Solution();
		 List<Integer> res = postorderTraversal(test);
		 for(Integer i : res)
			 System.out.print(i+" ");
		 System.out.println();
	}
}
