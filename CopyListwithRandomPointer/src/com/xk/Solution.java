package com.xk;
//΢��������
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return head;
		RandomListNode node = head;
		//��һ��ѭ�������½ڵ����ν����Ͻڵ�ĺ���
		//ԭ�����->��->��->��->��
		//����󣺡�->��->��->��->��->��->��->��->��->��
		while(node!=null){
			RandomListNode newNode = new RandomListNode(node.label);
			newNode.next= node.next;
			node.next = newNode;
			node = newNode.next;
		}
		//�ڶ���ѭ�����ڰ�randomָ�븳���½ڵ�
		//node.next���½ڵ�,m
		node = head;
		while(node!=null){
			if(node.random!=null)//ԭ���������{1��#}�������ָ��Ϊ�յ��������
				node.next.random = node.random.next;
			node = node.next.next;
		}
		//������ѭ���ǰ�һ����������������
		//��->��->��->��->��->��->��->��->��->����Ϊ��
		//��->��->��->��->�� �� ��->��->��->��->��
		//������Ҫע����ǣ�ԭ����ҲҪ�ָ��ſ���
		node = head;
		RandomListNode newHead = node.next;
		while(node!=null){
			RandomListNode newNode = node.next;
			node.next = newNode.next;
			if(newNode.next!=null)//ע������newNode.next����Ϊ�գ����������ж�����ΪҪ��newNode.next.next(����newNode.next����Ϊ��)
				newNode.next = newNode.next.next;
			node = node.next;
		}
		return newHead;
	}
}
