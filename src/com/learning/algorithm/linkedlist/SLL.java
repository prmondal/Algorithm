package com.learning.algorithm.linkedlist;

import java.util.HashSet;

public class SLL<T extends Comparable<T>> {

	public static void main(String[] args) {
		SLL<Integer> sll = new SLL<Integer>();

		// head node
		Node<Integer> head = new Node<Integer>(1);

		// insert nodes
		sll.insertNode(head, 2);
		sll.insertNode(head, 3);
		sll.insertNode(head, 4);
		sll.insertNode(head, 5);
		sll.insertNode(head, 5);
		sll.insertNode(head, 5);
		sll.insertNode(head, 6);
		sll.insertNode(head, 7);
		sll.insertNode(head, 8);
		sll.insertNode(head, 9);

		// print list
		sll.printSLL(head);

		System.out.println();

		// print reverse linked list
		head = sll.reverseSLL(head);
		
		sll.printSLL(head);

		// head node
		/*head = new Node<Integer>(1);

		// create looped linked list
		// insert nodes
		sll.insertNode(head, 2);
		sll.insertNode(head, 3);
		sll.insertNode(head, 4);
		sll.insertNode(head, 5);
		sll.insertNode(head, 6);

		head.next.next.next.next.next.next = head.next;

		// System.out.println(sll.isLooped(head));

		sll.printLoopStart(head);*/

		// merge sort of two sorted linked list
		System.out.println("\nMerge sort of two sorted list");

		Node<Integer> h1 = new Node<Integer>(10);
		Node<Integer> h2 = new Node<Integer>(200);

		// insert nodes
		sll.insertNode(h1, 20);
		sll.insertNode(h1, 30);
		sll.insertNode(h1, 40);
		sll.insertNode(h1, 50);
		sll.insertNode(h1, 60);

		System.out.println("List 1: ");
		sll.printSLL(h1);
		System.out.println();

		sll.insertNode(h2, 210);
		sll.insertNode(h2, 220);
		sll.insertNode(h2, 230);
		sll.insertNode(h2, 240);
		sll.insertNode(h2, 250);
		sll.insertNode(h2, 300);

		System.out.println("List 2: ");
		sll.printSLL(h2);

		System.out.println("\nSorted list: ");
		sll.printSLL(sll.mergeSLL(h1, h2));
		
		//remove duplicates
		sll.removeDuplicates(head);
		
		//print after removing duplicate
		System.out.println("\nAfter duplicate removed.");
		sll.printSLL(head);
		
		//merge sort
		Node<Integer> h3 = new Node<Integer>(100);

		// insert nodes
		sll.insertNode(h3, 25);
		sll.insertNode(h3, 5);
		sll.insertNode(h3, 45);
		sll.insertNode(h3, 40);
		sll.insertNode(h3, 35);
		sll.insertNode(h3, 35);
		sll.insertNode(h3, 35);
		
		System.out.println();
		sll.printSLL(sll.mergeSort(h3));
		
		//join two list alternatively
		Node<Integer> a = new Node<Integer>(100);

		// insert nodes
		sll.insertNode(a, 200);
		sll.insertNode(a, 300);
		sll.insertNode(a, 400);
		sll.insertNode(a, 500);
		sll.insertNode(a, 600);
		sll.insertNode(a, 700);
		sll.insertNode(a, 800);
		
		//join two list alternatively
		Node<Integer> b = new Node<Integer>(10);

		// insert nodes
		sll.insertNode(b, 20);
		sll.insertNode(b, 30);
		sll.insertNode(b, 40);
		sll.insertNode(b, 50);
		sll.insertNode(b, 60);
		sll.insertNode(b, 70);
		sll.insertNode(b, 80);
		sll.insertNode(b, 90);
		sll.insertNode(b, 100);
		
		System.out.println("\n === Reverse using recursion === ");
		b = sll.reverseSLLRecursive(b);
		sll.printSLL(b);
		
		//join two ll
		b = sll.alternateJoin(a, b);
		System.out.println("\nFirst list: ");
		sll.printSLL(a);
		
		System.out.println("\nSecond list: ");
		sll.printSLL(b);
		
		//add numbers
		Node<Integer> aa = new Node<Integer>(9);
		Node<Integer> bb = new Node<Integer>(9);
		
		sll.insertNode(aa, 9);
		sll.insertNode(aa, 9);
		
		sll.insertNode(bb, 9);
		sll.insertNode(bb, 9);
		
		Node<Integer> sumHead = sll.getSum(aa, bb, new Sum());
		
		//print sum
		System.out.println("\nSum of 999 and 999: ");
		sll.printSLL(sumHead);
		
		//check palindrome
		System.out.println("\n === Check Palindrome === ");
		Node<Integer> h4 = new Node<Integer>(1);

		// insert nodes
		sll.insertNode(h4, 2);
		sll.insertNode(h4, 3);
		//sll.insertNode(h4, 4);
		sll.insertNode(h4, 3);
		sll.insertNode(h4, 2);
		sll.insertNode(h4, 1);
		
		//print list
		System.out.println(" === Original LL === ");
		sll.printSLL(h4);
		
		if(sll.isPalindrome(h4)) {
			System.out.println("\nThe LL is a palindrome.");
		} else {
			System.out.println("\nThe LL is not a palindrome.");
		}
		
		System.out.println(" === LL is restored === ");
		sll.printSLL(h4);
	}
	
	//linked list size
	private int getSize(Node<T> head) {
		int size = 0;
		
		if(head == null)
			return size;
		
		while(head != null) {
			head = head.next;
			size++;
		}
		
		return size;
	}
	
	private Node<Integer> getSum(Node<T> h1, Node<T> h2, Sum s) {
		int l = getSize(h1);
		int m = getSize(h2);
		
		Node<Integer> result = null;
		
		if(l == m) {
			result = getSameSum(h1, h2, s);
		}
			
		if(s.carry != 0 && result != null) {
			Node<Integer> _new = new Node<Integer>(s.carry);
			
			_new.next = result;
			result = _new;
		} 
		
		return result;
	}

	//get sum of equal length numbers
	private Node<Integer> getSameSum(Node<T> h1, Node<T> h2, Sum s) {
		if(h1 == null) {
			return null;
		}
		
		Node<Integer> result = new Node<Integer>();
		
		result.next = getSameSum(h1.next, h2.next, s);
		
		//add sum to the result node and update carry
		int sum = (Integer) h1.key + (Integer) h2.key + s.carry;
		
		s.carry = sum / 10;
		sum = sum % 10;
		
		result.key = sum;
		
		return result;
	}

	private Node<T> alternateJoin(Node<T> a, Node<T> b) {
		if(a == null || b == null) {
			return b;
		}
		
		//store current node pointers
		Node<T> currA = a;
		Node<T> currB = b;
		
		//store next nodes pointers
		Node<T> nextA = a.next;
		Node<T> nextB = b.next;
		
		//loop through first till either first list ends of second list ends earlier
		while(currA != null && currB != null) {
			//join
			currA.next = currB;
			currB.next = nextA;
			
			//update current pointers
			currA = nextA;
			currB = nextB;
			
			//update next pointers
			if(currA != null) nextA = currA.next;
			if(currB != null) nextB = currB.next;
		}
		
		if(currB != null) {
			//update head pointer of second list
			b = currB;
		}
		
		return b;
	}

	private void removeDuplicates(Node<T> head) {
		if(head == null) 
			return;
		
		Node<T> current = head;
		
		while(current.next != null) {
			//duplicate found comparing current node with next node
			if(current.key.compareTo(current.next.key) == 0) {
				Node<T> nextNext = current.next.next;
				
				//set next of next node to null
				current.next.next = null;
				
				//link to next to next node with current node
				current.next = nextNext;
			} else {
				//advance current pointer
				current = current.next;
			}
		}
	}

	private boolean isLooped(Node<T> head) {
		System.out.println();

		if (head == null)
			return false;

		// hash based
		HashSet<Node<T>> map = new HashSet<Node<T>>();

		Node<T> p = head;

		while (p != null) {
			if (map.contains(p)) {
				return true;
			}

			map.add(p);

			p = p.next;
		}

		return false;
	}

	private void printLoopStart(Node<T> head) {
		System.out.println();

		if (head == null || head.next == null) {
			return;
		}

		Node<T> slow = head;
		Node<T> fast = head.next;

		while (fast != null) {
			if (slow == fast) {
				System.out.println("Loop detected.");
				break;
			}

			slow = slow.next;
			fast = fast.next;

			if (fast.next != null) {
				fast = fast.next;
			} else {
				System.out.println("No loop detected.");
				break;
			}
		}

		// find loop start
		// count total number os nodes in the loop
		int count = 0;

		Node<T> p = slow.next;
		
		count++;

		while (p != slow) {
			p = p.next;
			count++;
		}

		System.out.println("Loop length is " + count);

		// find loop start
		// get (count + 1)th nodes from head
		p = head;

		while (count > 0) {
			count--;

			p = p.next;
		}

		// move two pointers one from head and one from current location
		// increment by one and they meet at the loop start
		Node<T> q = head;

		while (q != p) {
			q = q.next;
			p = p.next;
		}

		System.out.println("Loop start is " + p.key);
	}

	private void insertNode(Node<T> head, T key) {
		if (head == null) {
			return;
		}

		Node<T> _new = new Node<T>(key);

		// if the second node is null
		if (head.next == null) {
			head.next = _new;
			return;
		}

		Node<T> p = head;

		// traverse till end
		while (p.next != null) {
			p = p.next;
		}

		p.next = _new;
	}

	void printSLL(Node<T> head) {
		while (head != null) {
			System.out.print(head.key + " ");

			head = head.next;
		}
	}

	Node<T> reverseSLL(Node<T> head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		Node<T> p = head;
		Node<T> q = p.next;
		Node<T> r = q.next;

		p.next = null;

		while (r != null) {
			q.next = p;
			p = q;
			q = r;
			r = r.next;
		}

		q.next = p;

		return q;
	}
	
	//recursive reverse
	Node<T> reverseSLLRecursive(Node<T> head) {
		if(head == null)
			return head;
		
		Node<T> first;
		Node<T> rest;
		
		first = head;
		rest = head.next;
		
		if(rest == null)
			return first;
		
		head = reverseSLLRecursive(rest);
		
		first.next.next = first;
		first.next = null;
		
		return head;
	}
	
	Node<T> mergeSort(Node<T> head) {
		if(head == null || head.next == null)
			return head;
		
		Node<T> a = head;
		Node<T> b = null;
		
		Node<T> slow = head;
		Node<T> fast = head.next;
		
		//find middle node
		while(fast.next != null) {
			fast = fast.next;
			
			if(fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		
		//get element after middle element
		b = slow.next;
		
		//split two SLL
		slow.next = null;
		
		a = mergeSort(a);
		b = mergeSort(b);
		
		return mergeSLL(a, b);
	}

	private Node<T> mergeSLL(Node<T> a, Node<T> b) {
		if(a == null && b == null) {
			return null;
		}
		
		if(a == null) {
			return b;
		}
		
		if(b == null) {
			return a;
		}
		
		Node<T> result = null;
		
		if(a.key.compareTo(b.key) <= 0) {
			//result = a;
			a.next = mergeSLL(a.next, b);
			return a;
		} else if(a.key.compareTo(b.key) > 0) {
			//result = b;
			b.next = mergeSLL(a, b.next);
			return b;
		}
		
		return result;
	}
	
	private boolean isPalindrome(Node<T> head) {
		if(head == null || head.next == null)
			return true;
		
		//get middle node of LL
		Node<T> middle = getMiddleNode(head, true);
		
		//reverse linked list from middle element to rest
		Node<T> head2 = reverseSLL(middle);
		
		//check nodes from first list with second list
		//if the values are not same LL is not palindrome
		Node<T> curr1 = head;
		Node<T> curr2 = head2;
		
		//when both list has data
		//second list may have middle element at last. In case of odd length LL last element of second list is not checked
		while(curr1 != null && curr2 != null) {
			//mismatch found
			if(curr1.key.compareTo(curr2.key) != 0) {
				return false;
			}
			
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		
		//restore the LL
		head2 = reverseSLL(head2);
		
		curr1 = head;
		
		while(curr1.next != null) {
			curr1 = curr1.next;
		}
		
		//establish the link
		curr1.next = head2;
		
		return true;
	}
	
	private Node<T> getMiddleNode(Node<T> head, boolean split) {
		if(head == null)
			return head;
		
		Node<T> slow = head;
		Node<T> fast = slow.next;
		
		while(fast.next != null) {
			fast = fast.next;
			
			if(fast.next != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		
		Node<T> temp = slow.next;
		
		//if flag is true split the LL
		if(split) {
			slow.next = null;
		}
		
		return temp;
	}
	
	static class Node<T extends Comparable<T>> {
		T key;
		Node<T> next;

		Node() {

		}

		Node(T key) {
			this.key = key;
			this.next = null;
		}
	}
	
	static class Sum {
		int carry = 0;
		int sum = 0;
	}
}


