package com.xk;

public class Solution {
	
	//我的解法，比较慢
//	public ListNode reverseBetween(ListNode head, int m, int n) {
//		int gap = n - m;
//        if(head == null || head.next == null || gap == 0)
//            return head;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode slow = dummy;
//        ListNode fast = dummy;
//        for(int i=0;i<=gap;i++)
//            fast = fast.next;
//        for(int i=1;i<m;i++){ 
//            slow = slow.next;
//            fast = fast.next;
//        }
//        ListNode currhead = slow.next;
//        ListNode currtail = fast.next;
//        fast.next = null;
//        slow.next = reverse(currhead, currhead.next);
//        currhead.next = currtail;
//        if(m==1)
//            return slow.next;
//        else
//            return head;
//    }
//    
//    public ListNode reverse(ListNode first, ListNode second){
//        if(second == null)
//            return first;
//        ListNode newHead =reverse(second, second.next);
//        second.next = first;
//        first.next = null;
//        return newHead;
//    }
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
	    if(head == null)
	        return null;
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode preNode = dummy;
	    int i=1;
	    while(preNode.next!=null && i<m)
	    {
	        preNode = preNode.next;
	        i++;
	    }
	    if(i<m)
	        return head;
	    ListNode mNode = preNode.next;
	    ListNode cur = mNode.next;
	    while(cur!=null && i<n) 
	    {
	        ListNode next = cur.next;
	        cur.next = preNode.next;
	        preNode.next = cur;
	        mNode.next = next;
	        cur = next;
	        i++;
	    }
	    return dummy.next;
	}
    
    public static void main(String[] args){
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(1);
		//head = reverseList(head);
		Solution s = new Solution();
		head = s.reverseBetween(head, 1,2);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}	
