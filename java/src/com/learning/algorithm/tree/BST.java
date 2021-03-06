package com.learning.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BST<T extends Comparable<T>> {
	static int sum = 0;
	
	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>();

		// root node
		Node<Integer> root = new Node<Integer>(60);

		// insert nodes
		tree.insertNode(root, 20);
		tree.insertNode(root, 10);
		tree.insertNode(root, 9);
		tree.insertNode(root, 8);
		tree.insertNode(root, 12);
		tree.insertNode(root, 30);
		tree.insertNode(root, 70);
		tree.insertNode(root, 100);

		// traversal
		tree.printInOrder(root);
		System.out.println();

		tree.printPreOrder(root);
		System.out.println();

		tree.printPostOrder(root);
		System.out.println();

		// print inorder
		tree.printInOrderUsingStack(root);

		// print post order using stack
		tree.printPostOrderUsingStack(root);

		// print pre order using stack
		tree.printPreOrderUsingStack(root);

		// print min/max
		System.out.println("Min : " + tree.getMin(root) + " , Max : "
				+ tree.getMax(root));

		// wrong BST
		Node<Integer> root1 = new Node<Integer>(50);
		root1.right = new Node<Integer>(60);
		root1.right.right = new Node<Integer>(45);

		// check isBST
		System.out.println("isBST: " + tree.isBST(root1, new Node<Integer>()));

		// height
		System.out.println("Tree Height: " + tree.height(root));

		// print level order in a line
		tree.printLevelOrder(root);

		// print level order line by line
		tree.printLevelOrderLinebyLine(root);

		tree.printZigZag(root);

		// lca
		System.out.println("LCA of 70 and 100 is "
				+ tree.lcaBinaryTree(root, 70, 100).key);

		// print leafs
		tree.printLeafs(root);

		// print sibling
		tree.printSibling(root, 160);

		// print all paths to leaf
		tree.printAllPathsToLeafRec(root, new ArrayList<Integer>(), 0);

		// path sum exists
		System.out.println("Path sum exists with sum 230: "
				+ tree.pathSumExists(root, 230));

		// print mirror tree
		tree.printInOrder(tree.mirror(root));

		// undo mirror
		tree.mirror(root);

		System.out.println();

		// duplicate left child
		// tree.printInOrder(tree.duplicateLeftNode(root));

		// to DLL
		// tree.printDLL(tree.toDLL(root));

		// print vertical order
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

		tree.traverseInVerticalOrder(root, map, 0);
		tree.printMap(map);

		// root node
		Node<Integer> rootalt = new Node<Integer>(60);

		// insert nodes
		tree.insertNode(rootalt, 20);
		tree.insertNode(rootalt, 22);
		tree.insertNode(rootalt, 8);
		tree.insertNode(rootalt, 9);
		tree.insertNode(rootalt, 21);

		map = new TreeMap<Integer, ArrayList<Integer>>();

		tree.traverseInVerticalOrder(rootalt, map, 0);

		System.out.println("\n=== Bottom view === ");
		tree.printBottomView(map);

		System.out.println("\n=== Top View === ");
		tree.printTopView(map);

		System.out.println(tree.isSibling(rootalt, 8, 9));

		// is same check
		// root node
		Node<Integer> root11 = new Node<Integer>(60);

		// insert nodes
		tree.insertNode(root11, 20);
		tree.insertNode(root11, 10);
		tree.insertNode(root11, 30);
		tree.insertNode(root11, 70);
		tree.insertNode(root11, 100);

		System.out.println(tree.isSame(root, root11));

		// root node
		Node<Integer> root12 = new Node<Integer>(100);

		// insert nodes
		tree.insertNode(root12, 50);
		tree.insertNode(root12, 20);
		tree.insertNode(root12, 60);
		tree.insertNode(root12, 200);
		tree.insertNode(root12, 150);
		tree.insertNode(root12, 300);

		System.out.println();
		tree.toSumTree(root12);
		tree.printInOrder(root12);

		// array to BST
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Node<Integer> r = tree.arrayToBST(arr, 0, arr.length - 1);

		tree.printInOrder(r);

		Node<Integer> root22 = new Node<Integer>(100);

		// insert nodes
		tree.insertNode(root22, 50);
		tree.insertNode(root22, 20);
		tree.insertNode(root22, 60);
		tree.insertNode(root22, 200);
		tree.insertNode(root22, 150);
		tree.insertNode(root22, 300);

		/*
		 * 100 50 200 20 60 150 300
		 */

		// print left view
		System.out.println("\nLeft view: ");
		tree.printLeftView(root22, new Level(), 0);
		tree.printLeftView(root22);

		// System.out.println("\nisSibling: " + tree.isSibling(root22, 50,
		// 200));
		System.out.println("\nisCousin: " + tree.isCousinNode(root22, 50, 60));

		// successor/predecessor
		Integer[] result = new Integer[2];
		Arrays.fill(result, 0);

		tree.getSuccPred(root22, 150, result);

		if (result[0] != 0) {
			System.out.println("Predecessor is " + result[0]);
		} else {
			System.out.println("No Predecessor found!");
		}

		if (result[1] != 0) {
			System.out.println("Successor is " + result[1]);
		} else {
			System.out.println("No successor found!");
		}

		// print minimum sum path
		System.out.println("\n==== Minimum Sum Path ====");
		Node<Integer> root23 = new Node<Integer>(50);

		// insert nodes
		tree.insertNode(root23, 40);
		tree.insertNode(root23, 90);
		tree.insertNode(root23, 30);
		tree.insertNode(root23, 10);
		tree.insertNode(root23, 45);

		Level l = new Level();
		tree.printMinimumSumPath(root23, 130, l, 0, new ArrayList<Integer>());
		System.out.println("\nMinimum path length: "
				+ ((l.minPathLength != Integer.MAX_VALUE) ? l.minPathLength
						: "No path found!"));

		// order statistics
		System.out.println("\n === Order statistics ===");
		Node<Integer> root24 = new Node<Integer>(20);

		// insert node
		tree.insertNode(root24, 8);
		tree.insertNode(root24, 4);
		tree.insertNode(root24, 12);
		tree.insertNode(root24, 10);
		tree.insertNode(root24, 14);
		tree.insertNode(root24, 30);
		tree.insertNode(root24, 25);
		tree.insertNode(root24, 40);

		// print kth largest
		tree.printKthLargest(root24, 7, new Count());

		// print kth smallest
		tree.printKthSmallest(root24, 5, new Count());

		// remove single child nodes
		System.out.println("\n === Remove single child nodes ===");
		Node<Integer> r1 = new Node<Integer>(20);

		// insert node
		tree.insertNode(r1, 30);
		tree.insertNode(r1, 40);
		tree.insertNode(r1, 8);
		tree.insertNode(r1, 4);
		tree.insertNode(r1, 10);

		r1 = tree.removeSingleChildNodes(r1);

		tree.printInOrder(r1);

		// get minimum node in right sub tree
		System.out.println("\n === Print minimum node in right sub-tree ===");
		Node<Integer> r2 = new Node<Integer>(20);

		// insert node
		tree.insertNode(r2, 30);
		tree.insertNode(r2, 35);
		tree.insertNode(r2, 40);

		System.out.println(tree.getMinNodeRightSubTree(r2.right).key);

		// delete node from tree
		System.out.println("\n === Delete node from tree ===");
		Node<Integer> r3 = new Node<Integer>(8);

		// insert node
		tree.insertNode(r3, 4);
		tree.insertNode(r3, 2);
		tree.insertNode(r3, 6);
		tree.insertNode(r3, 12);
		tree.insertNode(r3, 10);
		tree.insertNode(r3, 14);
		tree.insertNode(r3, 11);
		tree.insertNode(r3, 13);

		tree.printInOrder(tree.deleteNode(r3, 4));

		System.out.println("\n === To Sum Tree With Greater Key === ");
		Node<Integer> r4 = new Node<Integer>(5);
		tree.insertNode(r4, 2);
		tree.insertNode(r4, 13);
		tree.insertNode(r4, 10);

		tree.toSumTreeWithGreaterKeys(r4);

		tree.printInOrder(r4);

		// print kdistance node
		Node<Integer> r5 = new Node<Integer>(8);

		// insert node
		tree.insertNode(r5, 4);
		tree.insertNode(r5, 2);
		tree.insertNode(r5, 6);
		tree.insertNode(r5, 20);
		tree.insertNode(r5, 10);
		tree.insertNode(r5, 30);

		System.out.println("\n === Print K-dist nodes down === ");
		tree.printKDistNode(r5, 4, 2);
		
		System.out.println("\n" + tree.getSuccessor(r5, 10).key);
		
		System.out.println("\n Ceil: " + tree.ceil(r5, 39));
		
		//Build BST from preorder
		Node<Integer> rootPre = tree.buildTree(new int[] {5,4,3,2,1});
		tree.printInOrder(rootPre);
		
		// root node
		Node<Integer> r6 = new Node<Integer>(100);

		// insert nodes
		tree.insertNode(r6, 10);
		tree.insertNode(r6, 200);
		tree.insertNode(r6, 8);
		tree.insertNode(r6, 20);
		tree.insertNode(r6, 150);
		tree.insertNode(r6, 300);
		tree.insertNode(r6, 6);
		tree.insertNode(r6, 9);
		tree.insertNode(r6, 15);
		tree.insertNode(r6, 25);
		tree.insertNode(r6, 130);
		tree.insertNode(r6, 180);
		tree.insertNode(r6, 250);
		
		tree.printZigZagIterative(r6);
		
		//DLL to BST
		Node<Integer> r7 = new Node<Integer>(6);
		
		tree.insertNode(r7, 4);
		tree.insertNode(r7, 5);
		tree.insertNode(r7, 2);
		tree.insertNode(r7, 1);
		tree.insertNode(r7, 3);
		tree.insertNode(r7, 8);
		tree.insertNode(r7, 7);
		tree.insertNode(r7, 10);
		tree.insertNode(r7, 9);
		tree.insertNode(r7, 11);
		
		tree.printInOrder(r7);
		Node<Integer> head = tree.toDLL(r7);
		
		tree.printDLL(head);
		
		DLLNode<Integer> dllHead = new DLLNode<Integer>(head);
		
		System.out.println("\nDLL to BST");
		tree.printInOrder(tree.convertDLLToBST(dllHead, tree.getLLSize(head)));
	}

	void printDLL(Node<T> head) {
		Node<T> current = head;

		Node<T> tail = null;

		System.out.print("\nDLL forward: ");

		for (; current.right != null; current = current.right) {
			System.out.print(current.key + " ");
		}

		System.out.print(current.key);

		tail = current;

		System.out.print("\nDLL backward: ");

		for (; tail.left != null; tail = tail.left) {
			System.out.print(tail.key + " ");
		}

		System.out.print(tail.key);
	}
	
	//count size of LL
	int getLLSize(Node<T> head) {
		int size = 0;
		
		while(head != null) {
			head = head.right;
			size++;
		}
		
		return size;
	}

	void insertNode(Node<T> root, T key) {
		if (root == null)
			return;

		Node<T> _new = createNode(key);

		if (key.compareTo(root.key) < 0) {
			if (root.left == null) {
				root.left = _new;
			} else {
				insertNode(root.left, key);
			}
		} else {
			if (root.right == null) {
				root.right = _new;
			} else {
				insertNode(root.right, key);
			}
		}
	}

	Node<T> createNode(T key) {
		return new Node<T>(key);
	}

	void printInOrder(Node<T> root) {
		if (root == null)
			return;

		if (root.left != null)
			printInOrder(root.left);

		System.out.print(root.key + " ");

		if (root.right != null)
			printInOrder(root.right);
	}

	void printPreOrder(Node<T> root) {
		if (root == null)
			return;

		System.out.print(root.key + " ");

		if (root.left != null)
			printPreOrder(root.left);

		if (root.right != null)
			printPreOrder(root.right);
	}

	void printPostOrder(Node<T> root) {
		if (root == null)
			return;

		if (root.left != null)
			printPostOrder(root.left);

		if (root.right != null)
			printPostOrder(root.right);

		System.out.print(root.key + " ");
	}

	boolean isBST(Node<T> root, Node<T> prev) {
		if (root == null)
			return true;

		if (!isBST(root.left, prev))
			return false;

		if (prev != null && prev.key != null
				&& prev.key.compareTo(root.key) >= 0) {
			return false;
		}

		prev.key = root.key;

		return isBST(root.right, prev);
	}

	T getMin(Node<T> root) {
		if (root == null)
			return null;

		if (root.left == null)
			return root.key;

		return getMin(root.left);
	}

	T getMax(Node<T> root) {
		if (root == null)
			return null;

		if (root.right == null)
			return root.key;

		return getMax(root.right);
	}

	int height(Node<T> root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		return max(height(root.left), height(root.right)) + 1;
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	void printLevelOrder(Node<T> root) {
		if (root == null)
			return;

		Queue<Node<T>> Q = new LinkedList<Node<T>>();

		Q.add(root);

		while (!Q.isEmpty()) {
			Node<T> front = Q.poll();

			System.out.print(front.key + " ");

			if (front.left != null)
				Q.add(front.left);

			if (front.right != null)
				Q.add(front.right);
		}
	}

	void printLevelOrderLinebyLine(Node<T> root) {
		System.out.println("\nPrint line by line");

		if (root == null)
			return;

		int count = 0;

		Queue<Node<T>> Q = new LinkedList<Node<T>>();

		Q.add(root);

		while (true) {
			count = Q.size();

			if (count == 0)
				break;

			while (count > 0) {
				Node<T> front = Q.poll();

				System.out.print(front.key + " ");

				if (front.right != null)
					Q.add(front.right);

				if (front.left != null)
					Q.add(front.left);

				count--;
			}

			System.out.println();
		}
	}
	
	//recursive
	void printZigZag(Node<T> root) {
		System.out.println("\n ===== ZigZag print ======");

		if (root == null)
			return;

		int h = height(root);
		boolean leftToRight = true;

		for (int i = 1; i <= h; i++) {
			printLevel(root, i, leftToRight);

			leftToRight = !leftToRight;

			System.out.println("\n");
		}
	}
	
	void printZigZagIterative(Node<T> root) {
		if(root == null)
			return;
		
		System.out.println("\n ===== ZigZag print ======");
		Stack<Node<T>> left = new Stack<Node<T>>();
		Stack<Node<T>> right = new Stack<Node<T>>();
		
		left.push(root);
		
		while(!(left.isEmpty() && left.isEmpty())) {
			while(!left.isEmpty()) {
				Node<T> top = left.pop();
				System.out.print(top.key + " ");
				
				if(top.left != null) {
					right.push(top.left);
				}
				
				if(top.right != null) {
					right.push(top.right);
				}
			}
			
			System.out.println();
			
			while(!right.isEmpty()) {
				Node<T> top = right.pop();
				System.out.print(top.key + " ");
				
				if(top.right != null) {
					left.push(top.right);
				}
				
				if(top.left != null) {
					left.push(top.left);
				}
			}
			
			System.out.println();
		}
	}

	void printLevel(Node<T> root, int i, boolean leftToRight) {
		if (root == null)
			return;

		if (i == 0)
			return;

		if (i == 1) {
			System.out.print(root.key + " ");
			return;
		}

		if (leftToRight) {
			printLevel(root.left, i - 1, leftToRight);
			printLevel(root.right, i - 1, leftToRight);
		} else {
			printLevel(root.right, i - 1, leftToRight);
			printLevel(root.left, i - 1, leftToRight);
		}
	}

	T lca(Node<T> root, T k1, T k2) {
		if (root == null)
			return null;

		if (root.key.compareTo(k1) > 0 && root.key.compareTo(k2) > 0) {
			return lca(root.left, k1, k2);
		}

		if (root.key.compareTo(k1) < 0 && root.key.compareTo(k2) < 0) {
			return lca(root.right, k1, k2);
		}

		return root.key;
	}

	Node<T> lcaBinaryTree(Node<T> root, T a, T b) {
		if (root == null)
			return null;

		if (root.key.compareTo(a) == 0 || root.key.compareTo(b) == 0) {
			return root;
		}

		Node<T> l = lcaBinaryTree(root.left, a, b);
		Node<T> r = lcaBinaryTree(root.right, a, b);

		if (l != null && r != null) {
			return root;
		}

		return (l != null) ? l : r;
	}

	void printLeafs(Node<T> root) {
		if (root == null)
			return;

		Queue<Node<T>> Q = new LinkedList<Node<T>>();

		Q.add(root);

		while (!Q.isEmpty()) {
			Node<T> front = Q.poll();

			if (front.left == null && front.right == null) {
				System.out.print(front.key + " ");
			}

			if (front.left != null)
				Q.add(front.left);

			if (front.right != null)
				Q.add(front.right);
		}

		System.out.println();
	}

	void printSibling(Node<T> root, T key) {
		if (root == null)
			return;

		if (root.key.compareTo(key) == 0) {
			System.out.println("No sibling found :(");
			return;
		}

		while (root != null) {
			if (root.key.compareTo(key) > 0) {
				if (root.left != null && root.left.key.compareTo(key) == 0) {
					if (root.right != null) {
						System.out.println("Sibling of " + key + " is "
								+ root.right.key);
						break;
					} else {
						System.out.println("No sibling found :(");
						break;
					}
				} else {
					root = root.left;
				}
			} else {
				if (root.right != null && root.right.key.compareTo(key) == 0) {
					if (root.left != null) {
						System.out.println("Sibling of " + key + " is "
								+ root.left.key);
						break;
					} else {
						System.out.println("No sibling found :(");
						break;
					}
				} else {
					root = root.right;
				}
			}
		}
	}

	public void printInOrderUsingStack(Node<T> root) {
		if (root == null)
			return;

		Stack<Node<T>> stack = new Stack<Node<T>>();

		Node<T> current = root;

		boolean done = false;

		System.out.println("\n === In order traversal using stack === ");

		while (!done) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				if (!stack.isEmpty()) {
					Node<T> top = stack.pop();

					System.out.print(top.key + " ");
					current = top.right;
				} else {
					done = true;
				}
			}
		}

		System.out.println();
	}

	void printStack(Stack<Node<T>> S) {
		System.out.println("\n=====");
		for (Node<T> n : S) {
			System.out.println(n.key);
		}
	}

	public void printPostOrderUsingStack(Node<T> root) {
		if (root == null)
			return;

		Stack<Node<T>> first = new Stack<Node<T>>();
		Stack<Node<T>> second = new Stack<Node<T>>();

		first.push(root);

		System.out.println("Post order traversal using stack:");

		while (!first.isEmpty()) {
			Node<T> top = first.peek();

			second.push(top);

			first.pop();

			if (top.left != null)
				first.push(top.left);

			if (top.right != null)
				first.push(top.right);
		}

		for (int i = second.size() - 1; i >= 0; i--) {
			System.out.print(second.get(i).key + " ");
		}

		System.out.println();
	}

	public void printPreOrderUsingStack(Node<T> root) {
		if (root == null)
			return;

		Stack<Node<T>> S = new Stack<Node<T>>();

		S.push(root);

		System.out.println("Pre order traversal using stack:");

		while (!S.isEmpty()) {
			Node<T> top = S.peek();

			S.pop();

			System.out.print(top.key + " ");

			if (top.right != null)
				S.push(top.right);

			if (top.left != null)
				S.push(top.left);
		}

		System.out.println();
	}

	// recursive implementation print path to leaf
	void printAllPathsToLeafRec(Node<T> root, ArrayList<T> list, int pathLength) {
		if (root == null) {
			return;
		}

		list.add(pathLength, root.key);

		pathLength++;

		if (root.left == null && root.right == null) {
			printPathList(list, pathLength);
		} else {
			printAllPathsToLeafRec(root.left, list, pathLength);
			printAllPathsToLeafRec(root.right, list, pathLength);
		}
	}

	void printPathList(ArrayList<T> list, int pathLength) {
		System.out.println();

		for (int i = 0; i < pathLength; i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	boolean pathSumExists(Node<T> root, int sum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			if (root.key instanceof Integer) {
				if ((Integer) root.key == sum)
					return true;
			} else {
				return false;
			}
		}

		sum = sum - (Integer) root.key;

		return pathSumExists(root.left, sum) || pathSumExists(root.right, sum);
	}

	// non recursive path to leaf
	// TODO
	void printAllPathsToLeaf(Node<T> root) {
		if (root == null) {
			return;
		}

		Stack<Node<T>> S = new Stack<Node<T>>();
		ArrayList<T> path = new ArrayList<T>();

		S.add(root);
		path.add(root.key);

		Node<T> top;

		while (!S.isEmpty()) {
			top = S.peek();

			if (top.left != null) {
				S.push(top.left);

				path.add(top.left.key);
				continue;
			}

			if (top.left == null && top.right == null) {
				printPath(path);
				path.remove(path.size() - 1);

				S.pop();
			}

			if (!S.isEmpty()) {
				top = S.peek();

				S.pop();
			}

			if (top.right != null) {
				S.push(top.right);

				path.add(top.right.key);
			}
		}
	}

	void printPath(ArrayList<T> path) {
		System.out.println();

		for (T k : path) {
			System.out.print(k + " ");
		}
	}

	Node<T> mirror(Node<T> root) {
		if (root == null)
			return null;

		Node<T> t = root.left;
		root.left = root.right;
		root.right = t;

		mirror(root.left);
		mirror(root.right);

		return root;
	}

	Node<T> duplicateLeftNode(Node<T> root) {
		if (root == null)
			return null;

		Node<T> t = root.left;

		Node<T> _new = new Node<T>(root.key);

		root.left = _new;
		_new.left = t;

		duplicateLeftNode(_new.left);
		duplicateLeftNode(root.right);

		return root;
	}

	Node<T> toDLL(Node<T> root) {
		if (root == null)
			return null;

		// convert left subtree to list
		if (root.left != null) {
			Node<T> l = toDLL(root.left);

			// get inorder predecessor of root
			for (; l.right != null; l = l.right);

			l.right = root;
			root.left = l;
		}

		// convert right sub tree to list
		if (root.right != null) {
			Node<T> r = toDLL(root.right);

			// get inorder successor of root
			for (; r.left != null; r = r.left);

			r.left = root;
			root.right = r;
		}

		return getLeftMostNode(root);
	}
	
	Node<T> convertDLLToBST(DLLNode<T> dllHead, int n) {
		if(n <= 0) return null;
		
		Node<T> left = convertDLLToBST(dllHead, n / 2);
		
		Node<T> root = dllHead.head;
		
		root.left = left;
		
		dllHead.head = dllHead.head.right;
		
		root.right = convertDLLToBST(dllHead, n - n / 2 - 1);
		
		return root;
	}

	Node<T> getLeftMostNode(Node<T> root) {
		for (; root.left != null; root = root.left);

		return root;
	}

	// Hash Map based
	void traverseInVerticalOrder(Node<T> root,
			TreeMap<Integer, ArrayList<T>> map, int depth) {
		if (root == null)
			return;

		if (map.containsKey(depth)) {
			// System.out.println("Map contains key: " + depth);
			map.get(depth).add(root.key);
			// System.out.println("Added: " + root.key + "//");
		} else {
			// System.out.println("Map does not: " + depth);
			ArrayList<T> _new = new ArrayList<T>();
			// System.out.println("Added: " + root.key + "//");
			_new.add(root.key);
			map.put(depth, _new);
		}

		traverseInVerticalOrder(root.left, map, depth - 1);
		traverseInVerticalOrder(root.right, map, depth + 1);
	}

	// print contents of TreeMap of lists
	void printMap(TreeMap<Integer, ArrayList<T>> map) {
		System.out.println();

		for (ArrayList<T> list : map.values()) {
			for (T k : list) {
				System.out.print(k + " ");
			}

			System.out.println();
		}
	}

	// print contents of TreeMap of lists
	void printBottomView(TreeMap<Integer, ArrayList<T>> map) {
		System.out.println();

		for (ArrayList<T> list : map.values()) {
			System.out.print(list.get(list.size() - 1) + " ");
		}
	}

	// print top view
	void printTopView(TreeMap<Integer, ArrayList<T>> map) {
		System.out.println();

		for (ArrayList<T> list : map.values()) {
			System.out.print(list.get(0) + " ");
		}
	}

	// check two tree are same or not
	boolean isSame(Node<T> root1, Node<T> root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 != null && root2 != null
				&& root1.key.compareTo(root2.key) == 0) {
			return isSame(root1.left, root2.left)
					&& isSame(root1.right, root2.right);
		}

		return false;
	}

	// left view of tree
	// recursive
	void printLeftView(Node<T> root, Level l, int currLevel) {
		if (root == null)
			return;

		if (l.maxLevel < currLevel) {
			l.maxLevel = currLevel;

			System.out.print(root.key + " ");
		}

		// recur to left and right subtrees
		printLeftView(root.left, l, currLevel + 1);
		printLeftView(root.right, l, currLevel + 1);
	}

	// non recursive
	void printLeftView(Node<T> root) {
		if (root == null) {
			return;
		}

		Queue<Node<T>> queue = new LinkedList<Node<T>>();

		queue.add(root);
		queue.add(null); // sentinel node

		System.out.print(root.key + " ");

		// while sentinel node found next node is left node in that level if the
		// queue is not empty
		while (!queue.isEmpty()) {
			Node<T> front = queue.poll();

			// sentinel node found
			if (front == null) {
				if (queue.isEmpty())
					break;

				queue.add(null);
				System.out.print(queue.peek().key + " ");
			} else {
				if (front.left != null)
					queue.add(front.left);

				if (front.right != null)
					queue.add(front.right);
			}
		}
	}

	int toSumTree(Node<Integer> root) {
		if (root == null)
			return 0;

		int l = (Integer) toSumTree(root.left);
		int r = (Integer) toSumTree(root.right);
		int old = root.key;

		root.key = l + r;
		return root.key + old;
	}

	void toSumTreeWithGreaterKeys(Node<Integer> root) {
		if (root == null)
			return;

		toSumTreeWithGreaterKeys(root.right);

		sum += root.key;

		root.key = sum;

		toSumTreeWithGreaterKeys(root.left);
	}

	Node<Integer> arrayToBST(int[] array, int l, int h) {
		if (array.length == 0 || l > h)
			return null;

		int mid = l + (h - l) / 2;

		Node<Integer> root = new Node<Integer>(array[mid]);

		root.left = arrayToBST(array, l, mid - 1);
		root.right = arrayToBST(array, mid + 1, h);

		return root;
	}

	boolean isCousinNode(Node<T> root, T a, T b) {
		if (root == null)
			return false;

		int la = getLevel(root, a, 0);
		int lb = getLevel(root, b, 0);

		// not at same level
		if (la == lb && !isSibling(root, a, b)) {
			return true;
		}

		return false;
	}

	boolean isSibling(Node<T> root, T a, T b) {
		if (root == null)
			return false;

		if ((root.left != null && root.left.key.compareTo(a) == 0
				&& root.right != null && root.right.key.compareTo(b) == 0)
				|| (root.left != null && root.left.key.compareTo(b) == 0
						&& root.right != null && root.right.key.compareTo(a) == 0))
			return true;

		return isSibling(root.left, a, b) || isSibling(root.right, a, b);
	}

	int getLevel(Node<T> root, T n, int level) {
		if (root == null)
			return -1;

		if (root.key.compareTo(n) == 0) {
			return level;
		}

		return Math.max(getLevel(root.left, n, level + 1),
				getLevel(root.right, n, level + 1));
	}

	void getSuccPred(Node<T> root, T n, T[] result) {
		if (root == null)
			return;

		Node<T> current = null;

		// if root is equal to n
		if (root.key.compareTo(n) == 0) {
			// get rightmost node of left sub tree
			if (root.left != null) {
				current = root.left;

				for (; current.right != null; current = current.right)
					;

				// store predecessor
				result[0] = current.key;
			}

			// get leftmost node of right subtree
			if (root.right != null) {
				current = root.right;

				for (; current.left != null; current = current.left)
					;

				// store succesor
				result[1] = current.key;
			}

			return;
		}

		// if the key is less than root
		if (root.key.compareTo(n) > 0) {
			// set successor to root
			result[1] = root.key;

			// recur for left subtree
			getSuccPred(root.left, n, result);
		} else {
			// set predecessor to root
			result[0] = root.key;

			// recur for right subtree
			getSuccPred(root.right, n, result);
		}
	}

	// print minimum sum path
	void printMinimumSumPath(Node<T> root, int sum, Level l, int pathLength,
			ArrayList<T> list) {
		// root is null
		// root value is greater than sum
		// root value is same as sum and non leaf node
		if (root == null
				|| (Integer) root.key > sum
				|| ((root.left != null || root.right != null) && (Integer) root.key == sum)) {
			return;
		}

		// add to list
		list.add(root.key);

		// increase path length
		pathLength++;

		// leaf node found
		if (root.left == null && root.right == null) {
			// if path found with the sum
			if ((Integer) root.key == sum) {
				// update minimum
				if (l.minPathLength > pathLength) {
					l.minPathLength = pathLength;

					// print path
					printPathList(list, pathLength);
				}

				return;
			}
		}

		// update remaining sum
		sum = sum - (Integer) root.key;

		// if right node key is greater than remaining sum
		// recur to left
		if (root.right != null && (Integer) root.right.key > sum) {
			// if left key is less than current sum
			if (root.left != null && (Integer) root.left.key <= sum) {
				printMinimumSumPath(root.left, sum, l, pathLength, list);
			}
		} else {
			// recur both
			printMinimumSumPath(root.left, sum, l, pathLength, list);
			printMinimumSumPath(root.right, sum, l, pathLength, list);
		}
	}

	// k-th largest in BST
	void printKthLargest(Node<T> root, int k, Count count) {
		if (root == null || k < 0)
			return;

		printKthLargest(root.right, k, count);

		// increment count
		count.c++;

		// current node is kth largest. Print and return
		if (k == count.c) {
			System.out.println("kth largest key is " + root.key);

			return;
		}

		printKthLargest(root.left, k, count);
	}

	// k-th smallest in BST
	void printKthSmallest(Node<T> root, int k, Count count) {
		if (root == null || k < 0)
			return;

		printKthSmallest(root.left, k, count);

		// increment count
		count.c++;

		// current node is kth largest. Print and return
		if (k == count.c) {
			System.out.println("kth largest key is " + root.key);

			return;
		}

		printKthSmallest(root.right, k, count);
	}

	void printKDistNodesDown(Node<Integer> root, int k) {
		if (root == null || k < 0)
			return;

		if (k == 0) {
			System.out.print(root.key + " ");
			return;
		}

		printKDistNodesDown(root.left, k - 1);
		printKDistNodesDown(root.right, k - 1);
	}

	int printKDistNode(Node<Integer> root, Integer t, int k) {
		if (root == null || k < 0)
			return -1;

		// print k-distance node down
		if (root.key.compareTo(t) == 0) {
			printKDistNodesDown(root, k);
			return 0;
		}

		// distance between left node and target
		int dl = printKDistNode(root.left, t, k);

		if (dl != -1) {
			// current node is at k distance from target
			if (1 + dl == k) {
				System.out.print(root.key + " ");
			} else {
				printKDistNodesDown(root.right, k - dl - 2);
			}

			return 1 + dl;
		}

		// same for right tree
		int dr = printKDistNode(root.right, t, k);

		if (dr != -1) {
			// current node is at k distance from target
			if (1 + dr == k) {
				System.out.print(root.key + " ");
			} else {
				printKDistNodesDown(root.left, k - dr - 2);
			}

			return 1 + dr;
		}

		return -1;
	}

	// do post order traversal and remove nodes with single child
	Node<T> removeSingleChildNodes(Node<T> root) {
		if (root == null)
			return null;

		root.left = removeSingleChildNodes(root.left);
		root.right = removeSingleChildNodes(root.right);

		// do not remove leaf nodes
		if (root.left == null && root.right == null)
			return root;

		// node with child found
		// single child node found
		if (root.right == null) {
			Node<T> left = root.left;
			root.left = null;
			root = left;
		} else if (root.left == null) {
			Node<T> right = root.right;
			root.right = null;
			root = right;
		}

		return root;
	}

	Node<T> deleteNode(Node<T> root, int d) {
		if (root == null)
			return root;

		if ((Integer) root.key > d) {
			root.left = deleteNode(root.left, d);
		} else if ((Integer) root.key < d) {
			root.right = deleteNode(root.right, d);
		} else {
			// candidate node is root
			// case 1: it is leaf node
			if (root.left == null && root.right == null) {
				return null;
			}

			// case 2: it has single child
			if (root.left == null) {
				Node<T> temp = root.right;
				root.right = null;

				return temp;
			}

			if (root.right == null) {
				Node<T> temp = root.left;
				root.left = null;

				return temp;
			}

			// case 3: it has two children
			Node<T> minNode = getMinNodeRightSubTree(root.right);

			// assign min node value to root node
			root.key = minNode.key;

			// delete min node
			root.right = deleteNode(root.right, (Integer) minNode.key);
		}

		return root;
	}

	// utility function to get the minimum value node in the tree
	Node<T> getMinNodeRightSubTree(Node<T> root) {
		if (root == null) {
			return root;
		}
		
		Node<T> curr = root;

		// if root does not have left child
		if (root.left == null) {
			return root;
		}

		// go to extreme left
		for (; curr.left != null; curr = curr.left)
			;

		return curr;
	}

	Node<T> getSuccessor(Node<T> root, T n) {
		if (root == null) {
			return root;
		}

		Node<T> curr = root, succ = null;

		while (curr != null) {
			if(curr.key.compareTo(n) == 0) {
				//if the node has right child return minimum in the right tree
				if(curr.right != null) {
					return getMinNodeRightSubTree(curr.right);
				}
				
				break;
			}
			
			if(curr.key.compareTo(n) > 0) {
				succ = curr;
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

		return succ;
	}
	
	T ceil(Node<T> root, T k) {
		if(root == null) return null;
		
		if(root.key.compareTo(k) == 0) {
			return root.key;
		}
		
		if(root.key.compareTo(k) < 0) {
			return ceil(root.right, k);
		}
		
		T key = ceil(root.left, k);
		
		return (key != null) ? key : root.key;
	}
	
	//build BST from preorder
	/*
	 1. Create an empty stack.

	 2. Make the first value as root. Push it to the stack.

     3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value. Make this value as the right child of the last popped node. Push the new node to the stack.

     4. If the next value is less than the stack’s top value, make this value as the left child of the stack’s top node. Push the new node to the stack.

     5. Repeat steps 2 and 3 until there are items remaining in pre[].
	 */
	Node<Integer> buildTree(int[] pre) {
		int l = pre.length;
		
		if(l == 0) return null;
		
		Node<Integer> root = new Node<Integer>(pre[0]);
		
		if(l == 1) return root;
		
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		
		stack.push(root);
		
		for(int i = 1; i < l; i++) {
			Node<Integer> top = stack.peek();
			
			if(pre[i] < top.key) {
				Node<Integer> _new = new Node<Integer>(pre[i]);
				top.left = _new;
				stack.push(_new);
			} else {
				Node<Integer> lastNode = null;
				
				while(!stack.isEmpty() && stack.peek().key < pre[i]) {
					lastNode = stack.pop();
				}
				
				Node<Integer> _new = new Node<Integer>(pre[i]);
				if(lastNode != null) lastNode.right = _new;
				stack.push(_new);
			}
		}
		
		return root;
	}

	static class Node<T extends Comparable<T>> {
		T key;

		Node<T> left;
		Node<T> right;

		Node() {

		}

		Node(T key) {
			this.key = key;

			this.left = null;
			this.right = null;
		}
	}

	static class Level {
		int maxLevel = Integer.MIN_VALUE;
		int minPathLength = Integer.MAX_VALUE;
	}

	static class Count {
		int c = 0;

		Count() {
			c = 0;
		}
	}
	
	static class DLLNode <T extends Comparable<T>> {
		Node<T> head;
		
		DLLNode(Node<T> head) {
			this.head = head;
		}
	}
}
