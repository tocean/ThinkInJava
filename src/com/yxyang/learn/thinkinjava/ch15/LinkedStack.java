package com.yxyang.learn.thinkinjava.ch15;

/**
 * 链表实现堆栈, 使用泛型的例子
 * @author yxyang
 *
 */
public class LinkedStack <T> {
	//静态内部类, 表示节点
	private static class Node<U> {
		U item;
		Node<U> next;
		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}
		
		Node() {
			item = null;
			next = null;
		}
		boolean end() {
			return item == null && next == null;
		}
	}
	//链表首部元素
	private Node<T> top = new Node<T>();
	
	//放到链表最前面
	public void push(T item) {
		top = new Node<T>(item, top);
	}
	
	//从链表最前面取,取出之后把链表首部向后移动
	public T pop() {
		T item = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return item;
	}
}
