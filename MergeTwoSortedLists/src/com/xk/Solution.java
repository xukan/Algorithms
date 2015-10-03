package com.xk;

public class Solution {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null)
//            return l2;
//        if(l2 == null)
//            return l1;
//        if(l1.val>l2.val){
//        	ListNode temp = l2;
//        	l2 = l1;
//        	l1 = temp;
//        }
//        ListNode temp1 = l1, walker1 = temp1.next,temp2 = l2;
//        while(walker1!=null){
//            if(temp1.val <= temp2.val&&walker1.val>temp2.val){
//                ListNode curr1 = temp1;
//                temp1 = walker1;
//                walker1 = walker1.next;
//                ListNode curr2 = temp2;
//                ListNode walker2 = temp2;
//                temp2 = temp2.next;
//                while(temp2!=null&&temp2.val<=walker1.val){
//                	walker2 =walker2.next;
//                	temp2 = temp2.next;
//                }
//                curr1.next = curr2;
//                walker2.next = temp1;
//                if(temp2 == null)
//                	break;
//            }else{
//            	temp1 = walker1;
//            	walker1 = walker1.next;
//            }
//        }
//        if(temp2!=null)
//            temp1.next= temp2;
//        return l1;
		
		ListNode helper = new ListNode(0);  
	    ListNode pre = helper;  
	    helper.next = l1;  
	    while(l1!=null && l2 != null)  
	    {  
	        if(l1.val>l2.val)  
	        {  
	            ListNode next = l2.next;  
	            l2.next = pre.next;  
	            pre.next = l2;  
	            l2 = next;  
	        }  
	        else  
	        {  
	            l1 = l1.next;  
	        }  
	        pre = pre.next;
	    }  
	    if(l2!=null)  
	    {  
	        pre.next = l2;  
	    }  
	    return helper.next;
	}
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(5);
    	ListNode node2 = new ListNode(15);
    	ListNode node3 = new ListNode(25);
    	ListNode node4 = new ListNode(27);
    	ListNode node5 = new ListNode(35);
    	ListNode node6 = new ListNode(51);
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = node6; 
    	ListNode node10 = new ListNode(2);
    	ListNode node11 = new ListNode(7);
    	ListNode node22 = new ListNode(8);
//    	ListNode node33 = new ListNode(15);
//    	ListNode node44 = new ListNode(17);
//    	ListNode node55 = new ListNode(25);
//    	ListNode node66 = new ListNode(1);
    	node10.next = node11;
    	node11.next = node22;
//    	node22.next = node33;
//    	node33.next = node44;
//    	node44.next = node55;
//    	node55.next = node66; 
    	ListNode head = mergeTwoLists(node1, node10);
    	while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
