package com.learning.algorithm.linkedlist;

import java.util.HashSet;

public class SLL<T extends Comparable<T>> {

	public static void main(String[] args) {
		SLL<Integer> ll = new SLL<Integer>();

		// head node
		Node<Integer> head = new Node<Integer>(1);

		// insert nodes
		ll.insertNode(head, 2);
		ll.insertNode(head, 3);
		ll.insertNode(head, 4);
		ll.insertNode(head, 5);
		ll.insertNode(head, 6);
		ll.insertNode(head, 7);
		ll.insertNode(head, 8);
		ll.insertNode(head, 9);

		// print list
		ll.printSLL(head);
	}

	// find size
	int getSize(Node<T> head) {
		int size = 0;

		Node<T> curr = head;

		if (curr == null)
			return size;

		while (curr != null) {
			curr = curr.next;
			size++;
		}

		return size;
	}

	// some of two numbers with same number of digits using LL
	Node<Integer> calSum(Node<T> h1, Node<T> h2, Sum s) {
		int l = getSize(h1);
		int m = getSize(h2);

		Node<Integer> result = null;

		if (l == m) {
			result = calSumEqualLengthNumbers(h1, h2, s);
		} else
			return result; // TODO cal for diff len nums

		// add remaining carry
		if (s.carry != 0 && result != null) {
			Node<Integer> sumNode = new Node<Integer>(s.carry);

			sumNode.next = result;
			result = sumNode;
		}

		return result;
	}

	// calculate sum of two equal length numbers
	Node<Integer> calSumEqualLengthNumbers(Node<T> h1, Node<T> h2, Sum s) {
		// if one is null then other is also null
		if (h1 == null) {
			return null;
		}

		// result node for the sum
		Node<Integer> result = new Node<Integer>();

		result.next = calSumEqualLengthNumbers(h1.next, h2.next, s);

		// add sum to the result node and update carry
		int sum = (Integer) h1.key + (Integer) h2.key + s.carry;

		// calculate carry and sum
		s.carry = sum / 10;
		sum = sum % 10;

		// store sum to this node
		result.key = sum;

		return result;
	}

	// alternately join two LL
	// append remaining nodes at the end of the joined list in case two LL are of
	// different length
	Node<T> alternateJoin(Node<T> a, Node<T> b) {
		if (a == null || b == null) {
			return null;
		}

		// store current node pointers
		Node<T> currA = a;
		Node<T> currB = b;
		
		//store pointer to the last node of result list
		Node<T> last = a;

		// store next nodes pointers
		Node<T> nextA = a.next;
		Node<T> nextB = b.next;

		// loop through two LL till either one of them ends in case of different length or both ends in case of equal length case
		while (currA != null && currB != null) {
			// join
			currA.next = currB;
			currB.next = nextA;
			
			//update last node
			last = currB;

			// update current pointers
			currA = nextA;
			currB = nextB;

			// update next pointers
			if (currA != null)
				nextA = currA.next;
			if (currB != null)
				nextB = currB.next;
		}
		
		//extra nodes in list B
		if (currB != null) {
			//append extra nodes of B to list A
			last.next = currB;
		}
		
		//A is the result list
		return a;
	}
	
	//remove duplicate nodes from LL
	void removeDuplicates(Node<T> head) {
		if (head == null)
			return;

		Node<T> current = head;

		while (current.next != null) {
			// compare current node with next node
			if (current.key.compareTo(current.next.key) == 0) {
				Node<T> nextNext = current.next.next;

				// set next of next node to null
				current.next.next = null;

				// update current nodes next
				current.next = nextNext;
			} else {
				// advance current pointer
				current = current.next;
			}
		}
	}
	
	// hash based method
	boolean isLooped(Node<T> head) {
		if (head == null)
			return false;
		
		HashSet<Node<T>> map = new HashSet<Node<T>>();

		Node<T> p = head;

		while (p != null) {
			//duplicate node found
			if (map.contains(p)) {
				return true;
			}

			map.add(p);
			
			p = p.next;
		}

		return false;
	}
	
	//print loop start using slow and fast pointer strategy
	void printLoopStart(Node<T> head) {
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
		// count total number of nodes in the loop
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
	
	//iterative reverse
	Node<T> reverseSLL(Node<T> head) {
		if (head == null) {
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

	// recursive reverse
	Node<T> reverseSLLRecursive(Node<T> head) {
		if (head == null || head.next == null)
			return head;

		Node<T> first = head;
		Node<T> rest = head.next;

		head = reverseSLLRecursive(rest);
		
		first.next.next = first;
		first.next = null;

		return head;
	}

	Node<T> mergeSort(Node<T> head) {
		if (head == null || head.next == null)
			return head;

		Node<T> a = head;
		Node<T> b = null;

		Node<T> slow = head;
		Node<T> fast = head.next;

		// find middle node
		while (fast.next != null) {
			fast = fast.next;

			if (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}

		// get node after middle node
		b = slow.next;

		// split two SLL
		slow.next = null;

		a = mergeSort(a);
		b = mergeSort(b);

		return mergeSLL(a, b);
	}
	
	//merge two sorted LL
	Node<T> mergeSLL(Node<T> a, Node<T> b) {
		if (a == null && b == null) {
			return null;
		}

		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		if (a.key.compareTo(b.key) <= 0) {
			a.next = mergeSLL(a.next, b);
			return a;
		}

		b.next = mergeSLL(a, b.next);
		return b;
	}
	
	//check if a LL is palindrome or not
	boolean isPalindrome(Node<T> head) {
		if (head == null || head.next == null)
			return true;

		// get middle node of LL and split the LL
		Node<T> middle = getMiddleNode(head, true);

		// reverse linked list from middle element to rest
		Node<T> head2 = reverseSLL(middle);

		// check nodes from first list with second list one by one
		// if the values are not same LL is not palindrome
		Node<T> curr1 = head;
		Node<T> curr2 = head2;

		//middle node is at the last of second LL
		while (curr1 != null && curr2 != null) {
			// mismatch found
			if (curr1.key.compareTo(curr2.key) != 0) {
				return false;
			}

			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		// restore the LL
		head2 = reverseSLL(head2);

		curr1 = head;

		while (curr1.next != null) {
			curr1 = curr1.next;
		}

		// establish the link
		curr1.next = head2;

		return true;
	}
	
	//get middle node using slow and fast pointer strategy
	Node<T> getMiddleNode(Node<T> head, boolean split) {
		if (head == null)
			return head;

		Node<T> slow = head;
		Node<T> fast = slow.next;

		while (fast.next != null) {
			fast = fast.next;

			if (fast.next != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}

		Node<T> temp = slow.next;

		// if flag is true split the LL
		if (split) {
			slow.next = null;
		}

		return temp;
	}
	
	//add node at the end of the LL
	void insertNode(Node<T> head, T key) {
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

	//print LL
	void printSLL(Node<T> head) {
		Node<T> curr = head;
		
		while (curr != null) {
			System.out.print(curr.key + " ");

			curr = curr.next;
		}
	}

	static class Node<T extends Comparable<T>> {
		T key;
		Node<T> next;

		Node() {}

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
