package com.xk;
//ע������⣬X���Բ�������������
public class Solution {
	public static ListNode partition(ListNode head, int x) {
		
	
		if(head == null || head.next ==null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(fast.next!=null){
            if(fast.next.val<x){
                if(slow!=fast){
                    ListNode fastnext = fast.next;
                    ListNode slownext = slow.next;
                    fast.next = fastnext.next;
                    slow.next = fastnext;
                    fastnext.next = slownext;
                }else{
                    fast = fast.next;
                }
                slow = slow.next;//���һ�����������Ҫִ�У��Եڶ����������{1,2},3
            }else
                fast = fast.next;
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args){
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(4);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(2);
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head = reverseList(head);
		head = partition(head,3);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
