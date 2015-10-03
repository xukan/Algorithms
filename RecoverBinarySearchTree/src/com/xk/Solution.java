package com.xk;

import java.util.Stack;
/*
 *             4
 *           /   \
 *          3     10
 *        /   \     \
 *       1     6     14
 *            / \    /
 *           8   7  13
 *   
 * 感觉这道题还是基于BST的性质，中序遍历是有序的，中序遍历就用传统的非递归或递归方法解
 * 创新之处在于这道题的查找，三个数如果是a>b>c,那么只需交换a,c就可满足c<b<a
 * 需要两个额外节点来查找记录出错的两个点
 * 用pre来记录root在中序遍历下的前面的点，如果pre.val>root.val那么pre,root就是一对错误的点，first.val = pre.val，
 * 同时second.val = root.val,
 * 之后如果又找到一对出错的点，只需要second.val = root.val即可，原理就是上面提到的a>b>c => c<b<a的变换
 * 非递归的方法需要一个额外的栈来帮助遍历
 * */
public class Solution {
	public TreeNode recoverTree(TreeNode root) {
		if(root == null)
            return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode nullNode = new TreeNode(-1);
        TreeNode pre=nullNode,first = nullNode, second = nullNode;
        TreeNode head = root;
        int count =0;
        while(head!=null || !stack.empty()){
            if(head!=null){
                stack.push(head);
                head = head.left;
            }else{
            	head = stack.pop();
                if(pre.val > head.val){
                    if(first.val == -1){
                        first = pre;
                        second = head;
                    }else{
                        second = head;
                    }
                }
                pre = head;    
                head = head.right;
            }
        } 
        swap(first, second);
        return root;
    }
    
    public void swap(TreeNode first, TreeNode second){
        int temp = first.val;
        first.val = second.val;
        second.val = temp; 
    }
    
    public void inorder(TreeNode root){
    	if(root!=null){
    		inorder(root.left);
    		System.out.print(root.val+" ");
    		inorder(root.right);
    	}
    }
    
    //recursion
//    TreeNode pre;
//    TreeNode first;
//    TreeNode second;
//    public TreeNode recoverTree(TreeNode root) {
//        if(root == null)
//            return root;
//        TreeNode nullNode = new TreeNode(-1);
//        pre = nullNode;
//        first = nullNode;
//        second = nullNode;
//        inorderSearch(root);
//        swap(first,second);
//        return root;
//    }
//    
//    public void inorderSearch(TreeNode root){
//    	if(root == null)
//    		return;
//        inorderSearch(root.left);
//        
//        if(pre.val > root.val){
//            if(first.val == -1)
//                first = pre;
//            second = root;
//        }
//        pre = root;
//        
//        inorderSearch(root.right);
//    }
//    public void swap(TreeNode node1, TreeNode node2){
//        int temp = node1.val;
//        node1.val = node2.val;
//        node2.val = temp;
//    }
    
    public static void main(String[] args){
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(14);
		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(7);
		TreeNode node9 = new TreeNode(13);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node5.left = node7;
		node5.right = node8;
		node6.left = node9;
//    	TreeNode node1 = new TreeNode(3);
//    	TreeNode node2 = new TreeNode(8);
//    	node1.left = node2;
		Solution s = new Solution();
		//s.inorder(node1);
		System.out.println();
		TreeNode res = s.recoverTree(node1);
		//s.inorder(res);
    }
}
