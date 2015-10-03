/*
 Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */


package com.xk;

import com.xk.ListNode;

public class intersectionofTwoLinkedLists {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
        	return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        int len1=0, len2=0;
        while(p1!=null){
        	len1++;
        	p1=p1.next;
        }
        while(p2!=null){
        	len2++;
        	p2 = p2.next;
        }
<<<<<<< HEAD
        if(p1.val != p2.val)//如果两链表结尾元素不相同，说明没有交集
        	return null;
=======
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
        p1=headA;
        p2=headB;
        int diff = Math.abs(len1-len2);
        if(len1>len2){
<<<<<<< HEAD
        	while(diff-->0)
        		p1=p1.next;
        }else if(len2 > len1){
        	while(diff-->0)
=======
        	for(int i=0;i<diff;i++)
        		p1=p1.next;
        }else if(len2 > len1){
        	for(int j=0;j<diff;j++)
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
        		p2=p2.next;
        }
        while(p1!=null&&p2!=null){
        	if(p1 == p2)
        		return p1;
        	else{
        		p1=p1.next;
        		p2=p2.next;
        	}
        }
        return null;
    }
    
	public static void main(String[] args){
		
<<<<<<< HEAD
=======
		
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode c1 = new ListNode(3);
		ListNode c2 = new ListNode(4);
		ListNode c3 = new ListNode(5);
		ListNode b1 = new ListNode(6);
		ListNode b2 = new ListNode(7);
		ListNode b3 = new ListNode(8);
		a1.next=a2;
		a2.next=c1;
		c1.next=c2;
		c2.next=c3;
		b1.next=b2;
		b2.next=b3;
		b3.next=c1;
		ListNode commonNode = getIntersectionNode(a1, b1);
		System.out.println(commonNode.val);
		
	}
}
