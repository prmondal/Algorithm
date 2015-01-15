package com.practice.hackerrank;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Scanner;

public class EvenForest {
	static int count = 0;
	static int branchCut = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		Graph g = new Graph(N);

		for (int i = 1; i <= M; i++) {
			g.addEdge(sc.nextInt() - 1, sc.nextInt() - 1);
		}

		makeEvenForest(g, 0);

		System.out.println(branchCut);
	}
	
	static void printChild(ArrayList<Integer> list) {
		for(int i : list) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}

	/*private static int makeEvenForest(Graph g, int root) {
		ArrayList<Integer> child = g.getAdj(root);
		//System.out.println("=========");
		//printChild(child);
		
		int size = child.size();
		//System.out.println("Child size: " + size);
		for (int i = 0; i <= size - 1; i++) {
			if (root == 0) {
				//System.out.println("Root:: c - " + count);
				if (count != 0) {
					if(count % 2 == 0) {
						//System.out.println("Cut branch");
						//System.out.println("BranchCut: " + branchCut);
						// cut the branch
						branchCut++;
						
						//System.out.println("Cut: " + root + " - " + i);
						
						//System.out.println("BranchCut: " + branchCut);
					}
					
					count = 0;
				}
			}
			
			count++;
			//System.out.println("c: " + count + " | " + child.get(i));
			makeEvenForest(g, child.get(i));
		}
		
		//check for last child of the root
		if(root == 0) {
			if(count > 0 && count % 2 == 0) {
				//System.out.println("Cut branch");
				//System.out.println("BranchCut: " + branchCut);
				// cut the branch
				branchCut++;
				
				//System.out.println("Cut: " + root + " - " + child.get(size - 1));
				
				count = 0;
				
				//System.out.println("BranchCut: " + branchCut);
			}
		}
		
		return count;
	}*/
	
	private static int makeEvenForest(Graph g, int root) {
		//System.out.println("=========");
		//System.out.println("Current child: " + root);
		
		ArrayList<Integer> child = g.getAdj(root);
		int size = child.size();
		
		int numberChild = 0;
		
		for (int i = 0; i < size; i++) {
			/*if(root == 0) {
				count = 0;
				numberChild = 0;
			}*/
			
			
			int count = makeEvenForest(g, child.get(i));
			
			//System.out.println("Count:" + count);
			
			if(count > 0 && count % 2 == 0) {
				//System.out.println("Branch cut!");
				branchCut++;
				
				//numberChild -= count;
			}
			
			if(root != 0)
				numberChild += count;
			
			//System.out.println("Number of child: " + numberChild);
		}
		
		//System.out.println("End node:" + root);
		
		return ++numberChild;
	}

	static class Graph {
		ArrayList<Integer>[] adj;

		@SuppressWarnings("unchecked")
		Graph(int v) {
			adj = (ArrayList<Integer>[]) new ArrayList[v];

			for (int i = 0; i < v; i++) {
				adj[i] = new ArrayList<Integer>();
			}
		}

		void addEdge(int v, int w) {
			if(v > w) {
				adj[w].add(v);
			} else {
				adj[v].add(w);
			}
		}

		ArrayList<Integer> getAdj(int v) {
			return adj[v];
		}
	}

}
