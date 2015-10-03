package com.xk;

import java.util.*;
<<<<<<< HEAD
/*
 *                5
 *              /   \
 *             4     8
 *            /    /   \  
 *           11   13    4 
 *          /  \       / \
 *         7    2     5   1
 *         
 * 也是很熟悉的解题思路了，是backtracking那一类的
 * similar problems: Combinations， CombinationsII
 * */
public class PathSum {
//	public List<List<Integer>> pathSum(TreeNode root, int sum){
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		if(root == null){
//			return result;
//		}
//		ArrayList<Integer> current = new ArrayList<Integer>();
//		buildResult(root, sum, current, result);
//		return result;
//	}
//	
//	public void buildResult(TreeNode root, int sum, ArrayList<Integer> current, List<List<Integer>> result){
//		if(root == null)
//			return;
//		int currentVal = root.val;
//		current.add(currentVal);
//		if(root.left == null && root.right == null){
//			if(sum - currentVal == 0){
//				ArrayList<Integer> temp = new ArrayList<Integer>(current);
//				result.add(temp);
//			}
//		}
//		buildResult(root.left, sum-currentVal, current, result);
//		buildResult(root.right, sum-currentVal, current, result);
//		current.remove(current.size()-1);
//	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        List<Integer> temp = new ArrayList<Integer>();
        helper(res,temp, root, 0, sum);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> temp, TreeNode node, int value, int sum){
    	if(node== null)
            return;
    	value+=node.val;
        temp.add(node.val);
    	if(node.left == null && node.right == null && value == sum){
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        
        helper(res, temp, node.left, value, sum);
        helper(res, temp, node.right, value, sum);
        temp.remove(temp.size()-1);
    }
	
=======

public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		ArrayList<Integer> current = new ArrayList<Integer>();
		buildResult(root, sum, current, result);
		return result;
	}
	
	public void buildResult(TreeNode root, int sum, ArrayList<Integer> current, List<List<Integer>> result){
		if(root == null)
			return;
		int currentVal = root.val;
		current.add(currentVal);
		if(root.left == null && root.right == null){
			if(sum - currentVal == 0){
				ArrayList<Integer> temp = new ArrayList<Integer>(current);
				result.add(temp);
			}
		}
		buildResult(root.left, sum-currentVal, current, result);
		buildResult(root.right, sum-currentVal, current, result);
		current.remove(current.size()-1);
	}
	
//	public List<List<Integer>> pathSum(TreeNode root, int sum) {
//		List<List<Integer>> result = new ArrayList<List<Integer>>();  
//		//List<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
//     
//	if (root==null){
//		return result;
//	}
//	 
//	ArrayList<Integer> current=new ArrayList<Integer>();
//	buildResult(root, sum, current, result);
//	 
//	return result;
//}
//	
//	public void buildResult(TreeNode root,int sum, ArrayList<Integer> current, List<List<Integer>> result){ 
//		if (root==null){
//		    return;
//		}
//	 
//		int currentVal=root.val;
//		current.add(currentVal);
//		if (root.left==null && root.right==null){
//		    if (sum-currentVal==0){
//		        ArrayList<Integer> temp=new ArrayList<Integer> (current);
//		        result.add(temp);
//		    }
//		}
//		
//		buildResult(root.left, sum-currentVal, current, result);
//		buildResult(root.right, sum-currentVal, current, result);
//	 
//		current.remove(current.size()-1);
//	}
	
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
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
		 int sum = 22;
		 PathSum ps = new PathSum();
		 List<List<Integer>> res = ps.pathSum(root, sum);
<<<<<<< HEAD
		 for(List<Integer> it : res){
			 for(int i : it)
				 System.out.print(i+ " ");
			 System.out.println();
		 }
=======
		 for(List<Integer> it : res)
			 for(int i : it)
				 System.out.println(i);
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
	 }	
}

