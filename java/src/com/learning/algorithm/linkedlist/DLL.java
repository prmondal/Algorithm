package com.learning.algorithm.linkedlist;

public class DLL<T extends Comparable<T>> {
	private int size = 0;
	private int MAX_SIZE = 100;
	private Node<T> head = null;
	private Node<T> tail = null;

	public void insertFront(T k) {
		if(size >= MAX_SIZE) {
			return;
		}
		
		if (head == null) {
			head = tail = new Node<T>(k);
			size++;

			return;
		}

		Node<T> _new = new Node<T>(k);

		_new.next = head;
		_new.next.prev = _new;

		head = _new;

		size++;
	}

	public void insertBack(T k) {
		if(size >= MAX_SIZE) {
			return;
		}
		
		if (tail == null) {
			tail = head = new Node<T>(k);
			size++;

			return;
		}

		Node<T> _new = new Node<T>(k);

		tail.next = _new;
		_new.prev = tail;

		tail = _new;

		size++;
	}

	public Node<T> removeFront() {
		if (head == null) {
			return null;
		}

		Node<T> front = head;

		head = front.next;
		head.prev = null;
		front.next = null;

		size--;

		return front;
	}

	public Node<T> removeBack() {
		if (tail == null) {
			return null;
		}

		Node<T> back = tail;
		System.out.println(back.prev.key);
		tail = back.prev;
		tail.next = null;
		back.prev = null;

		size--;

		return back;
	}
	
	public void remove(Node<T> n) {
		if(head == null) return;
		
		n.prev.next = n.next;
		n.next.prev = n.prev;
		
		n.prev = null;
		n.next = null;
		
		size--;
	}
	
	public Node<T> peekFirst() {
		if(head == null) return null;
		
		return head;
	}
	
	public Node<T> peekLast() {
		if(tail == null) return null;
		
		return tail;
	}

	public void print() {
		Node<T> curr = head;

		while (curr != null) {
			System.out.print(curr.key + " ");

			curr = curr.next;
		}

		/*curr = tail;

		while (curr != null) {
			System.out.print(curr.key + " ");

			curr = curr.prev;
		}*/
	}

	static class Node<T> {
		T key;
		Node<T> next = null;
		Node<T> prev = null;

		Node() {

		}

		Node(T key) {
			this.key = key;
		}
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static void main(String[] args) {
		DLL<String> dll = new DLL<String>();

		dll.insertFront("z");
		dll.insertFront("y");
		dll.insertBack("x");

		dll.print();
		System.out.println("\nSize: " + dll.getSize());

		//Node<String> back = dll.removeFront();
		//System.out.println("\nRemove from front: " + back.key);

		//dll.print();
		//System.out.println("\nSize: " + dll.getSize());
	}

	public int getMAX_SIZE() {
		return MAX_SIZE;
	}

	public void setMAX_SIZE(int mAX_SIZE) {
		MAX_SIZE = mAX_SIZE;
	}
}
