package com.xk;

public class insertionSortList {
	public ListNode insertionSortList(ListNode head) {
<<<<<<< HEAD
        if(head == null || head.next == null)
        	return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head, fast = head;
        while(fast!=null){
        	slow = head;//ÿ��fastǰ��һ����slow��Ҫ�ص�����ͷ����ɨ�裬��仰��õ�����ǵ������м䲿���ź����fastǰ��һ������ʱ
        	            //��Ҫslow�ص�����ͷ��һһ�ȶ�
        	while(slow!=fast){
        		if(slow.val>fast.val){
        			int temp = slow.val;
        			slow.val = fast.val;
        			fast.val = temp;
        		}
        		slow = slow.next;//slow��fast����ȵ�ʱ��һ����fast��ǰ�������ƶ�slow��һһ�Ƚ�
        	}
        	fast = fast.next;
        }
        return dummy.next;
=======
        if( head==null || head.next==null )
            return head;
        ListNode current = head;
        ListNode insertionPointer = head;
   
        while(current != null){
            insertionPointer = head;
            while(insertionPointer != current){
                if(insertionPointer.val > current.val){
                //   ListNode temp= new ListNode(insertionPointer.val);
                    int temp = current.val;
                    current.val = insertionPointer.val;
                    insertionPointer.val = temp;
                   insertionPointer = insertionPointer.next;
                }else{
                   insertionPointer = insertionPointer.next;
                }
            }
            current = current.next;
        }
        return head;
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
    }
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		insertionSortList insertsl = new insertionSortList();
		node1 = insertsl.insertionSortList(node1);
		while(node1!=null){
<<<<<<< HEAD
			System.out.print(node1.val+" ");
=======
			System.out.println(node1.val);
>>>>>>> 213090bf72ac5b91d4fd204862c5d7e9d55c0353
			node1=node1.next;
		}  
	}
}
