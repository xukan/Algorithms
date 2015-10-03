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
 * �о�����⻹�ǻ���BST�����ʣ��������������ģ�����������ô�ͳ�ķǵݹ��ݹ鷽����
 * ����֮�����������Ĳ��ң������������a>b>c,��ôֻ�轻��a,c�Ϳ�����c<b<a
 * ��Ҫ��������ڵ������Ҽ�¼�����������
 * ��pre����¼root����������µ�ǰ��ĵ㣬���pre.val>root.val��ôpre,root����һ�Դ���ĵ㣬first.val = pre.val��
 * ͬʱsecond.val = root.val,
 * ֮��������ҵ�һ�Գ���ĵ㣬ֻ��Ҫsecond.val = root.val���ɣ�ԭ����������ᵽ��a>b>c => c<b<a�ı任
 * �ǵݹ�ķ�����Ҫһ�������ջ����������
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
