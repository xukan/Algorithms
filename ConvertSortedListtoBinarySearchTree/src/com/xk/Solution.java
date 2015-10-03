package com.xk;

import java.util.ArrayList;
/*
 * ������Ҫȡ�е���Ϊ��ǰ�����ĸ�������������Ƕ���һ�����������ǲ��ܳ���ʱ����������м�Ԫ�صġ���ʱ���Ҫ���õ�������������ˣ�
 * ���յݹ����������˳���������һ�������з��ʣ�������Ҫ����Ķ��ֲ��������ǰ��������˳�����ġ�˼·�����ȶ����������еݹ飬Ȼ�󽫵�ǰ�����Ϊ����
 * ��������һ�������㣬����ڵݹ�������������ɡ�������̾���һ�����������ʱ�临�Ӷ���O(n)���ռ临�Ӷ���ջ�ռ�O(logn)��
 * ������ǲ������Ŀ���������ֹ���ķ�ʽ�Ƚ��ƣ���Ϊһ����˵���Ƕ��Ƕ��ڴ��ڵ������б�����������ģ��һ����������Ĺ��̰������޵��еع��������
 * */
/*
 * ���������е���Ϊ��
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
