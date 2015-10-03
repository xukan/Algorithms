package com.xk;

import java.util.*;

public class Solution {
	public int countNodes(TreeNode root) {
//        if(root == null)
//            return 0;
//        int hl = 0, hr = 0;
//        TreeNode l = root, r = root;
//        while(l!= null){
//            hl++;
//            l = l.left;
//        }
//        while(r!=null){
//            hr++;
//            r = r.right;
//        }
//        if(hl == hr){
//            return (2<<(hl-1))-1;
//        }
//        int left = countNodes(root.left);
//        int right = countNodes(root.right);
//        return 1 + left + right; 
		
		if(root == null)
            return 0;
        TreeNode l = root, r = root;
        int hl =0, hr =0;
        while(l!=null){
            hl++;
            l=l.left;
        }
        while(r!=null){
            hr++;
            r=r.right;
        }
        if(hl == hr){
        	int res = (1<<hl)-1;
            return res;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
		
    }
	
	//levelorder solution, timeout
//	public int countNodes(TreeNode root) {
//        int count=0;
//        if(root == null)
//            return count;
//        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        int start =0, end =queue.size();
//        while(!queue.isEmpty()){
//            for(int i=start;i<end;i++){
//                TreeNode node = queue.poll();
//                count++;
//                if(node.left!=null)
//                    queue.offer(node.left);
//                if(node.right!=null)
//                    queue.offer(node.right);
//            }
//            end = queue.size();
//        }
//        return count;
//    }
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		//TreeNode node7 = new TreeNode(7);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		Solution s = new Solution();
		int res = s.countNodes(node1);
		System.out.println(res);
	}
}
