package com.xk;
//微软面试题
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return head;
		RandomListNode node = head;
		//第一次循环，把新节点依次接在老节点的后面
		//原链表○->○->○->○->○
		//接入后：○->△->○->△->○->△->○->△->○->△
		while(node!=null){
			RandomListNode newNode = new RandomListNode(node.label);
			newNode.next= node.next;
			node.next = newNode;
			node = newNode.next;
		}
		//第二次循环是在把random指针赋给新节点
		//node.next是新节点,m
		node = head;
		while(node!=null){
			if(node.random!=null)//原链表可以有{1，#}，即随机指针为空的情况出现
				node.next.random = node.random.next;
			node = node.next.next;
		}
		//第三次循环是把一个链表拆成两个链表
		//○->△->○->△->○->△->○->△->○->△变为：
		//○->○->○->○->○ 和 △->△->△->△->△
		//这里需要注意的是，原链表也要恢复才可以
		node = head;
		RandomListNode newHead = node.next;
		while(node!=null){
			RandomListNode newNode = node.next;
			node.next = newNode.next;
			if(newNode.next!=null)//注意这里newNode.next可以为空，但是这里判断是因为要用newNode.next.next(这里newNode.next不能为空)
				newNode.next = newNode.next.next;
			node = node.next;
		}
		return newHead;
	}
}
