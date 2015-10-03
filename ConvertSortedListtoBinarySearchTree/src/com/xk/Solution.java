package com.xk;

import java.util.ArrayList;
/*
 * 我们需要取中点作为当前函数的根。这里的问题是对于一个链表我们是不能常量时间访问它的中间元素的。这时候就要利用到树的中序遍历了，
 * 按照递归中序遍历的顺序对链表结点一个个进行访问，而我们要构造的二分查找树正是按照链表的顺序来的。思路就是先对左子树进行递归，然后将当前结点作为根，
 * 迭代到下一个链表结点，最后在递归求出右子树即可。整体过程就是一次中序遍历，时间复杂度是O(n)，空间复杂度是栈空间O(logn)。
 * 这道题是不错的题目，不过这种构造的方式比较绕，因为一般来说我们都是对于存在的树进行遍历，这里是模拟一个中序遍历的过程把树从无到有地构造出来。
 * */
/*
 * 本题例子中的树为：
 *            5
 *          /   \
 *         1     9
 *          \   / \
 *           3 7  11  
 * */

public class Solution {
//	public TreeNode sortedListToBST(ListNode head) {  
//	    if(head == null)  
//	        return null;  
//	    ListNode cur = head;  
//	    int count = 0;  
//	    while(cur!=null)  
//	    {  
//	        cur = cur.next;  
//	        count++;  
//	    }  
//	    ArrayList<ListNode> list = new ArrayList<ListNode>();  
//	    list.add(head);  
//	    return helper(list,0,count-1);  
//	}
//	
//	public TreeNode helper(ArrayList<ListNode> list, int l, int r)  
//	{  
//	    if(l>r)  
//	        return null;  
//	    int m = (l+r)/2;  
//	    TreeNode left = helper(list,l,m-1);  
//	    TreeNode root = new TreeNode(list.get(0).val);  
//	    root.left = left;  
//	    list.set(0,list.get(0).next);  
//	    root.right = helper(list,m+1,r);  
//	    return root;  
//	}
	
	public static TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        int count =0;
        ListNode node = head;
        while(node!=null){
            count++;
            node = node.next;
        }
        return helper(list, 0, count-1);
    }
    
    public static TreeNode helper(ArrayList<ListNode> list, int l, int r){
        if(l>r)
            return null;
        int m = (l+r)/2;
        TreeNode left = helper(list, l, m-1);
        TreeNode root = new TreeNode(list.get(0).val);
        root.left = left;
        list.set(0, list.get(0).next);
        root.right = helper(list, m+1, r);
        return root;
    }
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
//    	ListNode node2 = new ListNode(3);
//    	ListNode node3 = new ListNode(5);
//    	ListNode node4 = new ListNode(7);
//    	ListNode node5 = new ListNode(9);
//    	ListNode node6 = new ListNode(11);
//    	node1.next = node2;
//    	node2.next = node3;
//    	node3.next = node4;
//    	node4.next = node5;
//    	node5.next = node6;
    	//node6.next = node1;
    	Solution s = new Solution();
    	TreeNode res = s.sortedListToBST(node1);
    	System.out.println(res.val);
	}
}
