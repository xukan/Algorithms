package com.xk;

public class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
//        int carry =0;
//        ListNode res = new ListNode(0);
//        ListNode cur1 = l1, cur2 = l2, head=res;
//        while(cur1!=null || cur2!=null){
//            if(cur1!=null){
//                carry+=cur1.val;
//                cur1=cur1.next;
//            }
//            if(cur2!=null){
//                carry+=cur2.val;
//                cur2=cur2.next;
//            }
//            head.next=new ListNode(carry%10);
//            head=head.next;
//            carry/=10;
//        }
//        if(carry!=0) head.next=new ListNode(carry);
//        return res.next;
		
		//我的解法，空间复杂度是O(1),时间复杂度是O(n)(n=较长的链表的长度)
		ListNode run1 = l1, run2 = l2;
        int len1 = 1, len2 = 1;
        while(run1.next!=null){
            run1=run1.next;
            len1++;
        }
        while(run2.next!=null){
            run2 = run2.next;
            len2++;
        }
        ListNode node1 = len1>=len2?l1:l2;
        ListNode node2 = node1==l1?l2:l1;
        ListNode pre1 = node1, pre2 = node2, res = node1;
        int carry = 0;
        while(node1!=null && node2!=null){
            int sum = node1.val + node2.val + carry;
            node1.val = sum %10;
            carry = sum/10;
            pre1=node1;
            pre2=node2;
            node1=node1.next;
            node2=node2.next;
        }
        if(len1 == len2){
            if(carry!=0)
                pre1.next = new ListNode(carry);
        }else {
            while(node1!=null){
                int sum = node1.val+carry;
                node1.val = sum%10;
                carry = sum/10;
                pre1 = node1;
                node1=node1.next;
            }
            if(carry!=0)
                pre1.next = new ListNode(carry);
        }
        return res;
    } 
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(9);
//		l1.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		//l2.next.next = new ListNode(4);
		//head = reverseList(head);
		ListNode res = addTwoNumbers(l1, l2);
		while(res!=null){
			System.out.print(res.val+" ");
			res = res.next;
		}
	}
}
