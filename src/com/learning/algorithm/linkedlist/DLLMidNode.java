package com.learning.algorithm.linkedlist;

public class DLLMidNode<T extends Comparable<T>> {
	// track of total number of nodes in the list
	static int count = 0;

	// mid node reference
	Node<T> mid = null;

	private void printList(Node<T> head) {
		System.out.println();

		if (head == null)
			return;

		while (head != null) {
			System.out.print(head.key + " ");

			head = head.next;
		}

		System.out.println();
	}

	Node<T> insert(Node<T> head, T key) {
		Node<T> newNode = new Node<T>(key);

		if (head == null) {
			// insert first node
			head = newNode;

			// assign mid node
			// first node in the list. mid points to head node
			mid = head;

			count++;

			return head;
		}

		newNode.next = head;
		head.prev = newNode;

		head = newNode;

		count++;

		// if count is odd mid points to middle element
		// shifts mid left one position
		if (count % 2 != 0) {
			mid = mid.prev;
		}

		return head;
	}

	Node<T> pop(Node<T> head) {
		if (head == null)
			return head;

		Node<T> popNode = head;
		head = popNode.next;

		if (head != null)
			head.prev = null;

		popNode.next = null;

		count--;

		if (count == 0) {
			mid = null;
		} else if (count % 2 == 0) {
			// move to right
			mid = mid.next;
		}

		return head;
	}

	void printTotalNodes(Node<T> head) {
		System.out.println();

		if (head == null)
			System.out.println("There are no nodes.");

		int count = 0;

		while (head != null) {
			count++;

			head = head.next;
		}

		System.out.println("Total number of nodes: " + count);
	}

	static class Node<T> {
		T key;
		Node<T> next;
		Node<T> prev;

		Node() {

		}

		Node(T key) {
			this.key = key;
			this.next = null;
			this.prev = null;
		}
	}

	public static void main(String[] args) {
		DLLMidNode<Integer> dll = new DLLMidNode<Integer>();

		Node<Integer> head = null;

		// insert nodes
		head = dll.insert(head, 100);
		head = dll.insert(head, 200);
		head = dll.insert(head, 300);
		head = dll.insert(head, 400);
		head = dll.insert(head, 500);
		head = dll.insert(head, 600);

		// print mid
		System.out.println("Mid: " + dll.mid.key);

		// printList
		dll.printList(head);

		head = dll.pop(head);

		System.out.println("Mid: " + dll.mid.key);

		// printList
		dll.printList(head);
	}

}
