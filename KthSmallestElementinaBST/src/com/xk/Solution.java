package com.xk;

public class Solution {
	private TreeNode root;
	//Morris Traversal, inorder
	public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        TreeNode cur = root, prev=null;
        int count=0;
        while(cur!=null){
            if(cur.left == null){
                count++;
                if(count==k)
                    return cur.val;
                cur=cur.right;
            }else{
                prev = cur.left;
                while(prev.right !=null && prev.right != cur)
                    prev = prev.right;
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }else{
                    prev.right = null;
                    count++;
                    if(count==k)
                        return cur.val;
                    cur = cur.right;
                }
            }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		node1.left = node2;
		node1.right=node3;
		node2.right=node4;
		Solution s = new Solution();
		int res = s.kthSmallest(node1, 1);
		System.out.println(res);
		
	}
}
