package com.practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindMedian {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}

		int pInd = partition(0, ar.length - 1, ar);
			
		int mid = ar.length >> 1;
		//System.out.println(pInd + " " + mid);
		//printArray(ar);
		if(pInd == mid) {
			System.out.println(ar[pInd]);
			return;
		}
		
		//System.out.println(pInd + " " + mid);
		
		//printArray(ar);
		/*int k = Math.abs(pInd - mid);
		
		//find kth max
		if(pInd > mid) {
			printKthMax(ar, 0, pInd - 1, k);
		} else if(pInd < mid) {
			printKthMin(ar, pInd + 1, ar.length - 1, k);
			//printKthMax(ar, pInd + 1, ar.length - 1, ar.length - k);
		}*/
		
		
		int firstPind = pInd;
		
		if(firstPind > mid) {
			pInd = partition(0, firstPind - 1, ar);
		} else if(firstPind < mid) {
			pInd = partition(firstPind + 1, ar.length - 1, ar);
		}
		
		while(true) {
			if(pInd > mid) {
				if(pInd > firstPind) {
					pInd = partition(firstPind + 1, pInd - 1, ar);
				} else if(pInd < firstPind) {
					pInd = partition(pInd + 1, firstPind - 1, ar);
				}
				
			} else if(pInd < mid) {
				if(pInd > firstPind) {
					pInd = partition(pInd + 1, ar.length - 1, ar);
				} else if(pInd < firstPind) {
					pInd = partition(pInd + 1, firstPind - 1, ar);
				}
			}
			
			if(pInd == mid) {
				System.out.println(ar[pInd]);
				
				break;
			}
		}
	}

	private static void printKthMax(int[] ar, int low, int high, int k) {
		int max = Integer.MIN_VALUE;
		int lastMax = Integer.MAX_VALUE;
		int lastIndx = 0;
		
		int i = 1;
		
		while(i <= k) {
			for(int j = low; j <= high; j++) {
				if(lastMax == ar[j]) {
					if(lastIndx - 1 == j - 1) {
						continue;
					}
					
					i++;
					lastIndx = j;
					break;
				}
				
				if(ar[j] >= max && ar[j] < lastMax) {
					max = ar[j];
					lastIndx = j;
					System.out.println("max: " + max + " ," + "lastMax: " + lastMax);
				}
			}
			
			i++;
			lastIndx = 0;
			
			lastMax = max;
			max = Integer.MIN_VALUE;
		}
		
		System.out.println(lastMax);
	}
	
	private static void printKthMin(int[] ar, int low, int high, int k) {
		int min = Integer.MAX_VALUE;
		int lastMin = Integer.MIN_VALUE;
		
		int i = 1;
		
		while(i <= k) {
			for(int j = low; j <= high; j++) {
				if(lastMin == ar[j]) {
					i++;
					
					break;
				}
				
				
				if(ar[j] <= min && ar[j] > lastMin) {
					min = ar[j];
					System.out.println("min: " + min + " ," + "lastMin: " + lastMin + "k: " + k);
				}
			}
			
			i++;
			lastMin = min;
			min = Integer.MAX_VALUE;
		}
		
		System.out.println(lastMin);
	}

	static int partition(int low, int high, int[] a) {
		int pivotIdx;
		
		if((high + 1 - low) % 2 == 0) {
			pivotIdx = (high + 1 - low) / 2;
		} else {
			pivotIdx = low + (high - low) >> 1;
		}
		
		int pivot = a[pivotIdx];
		//System.out.println("pivotindex: " + pivotIdx);
		int i = low;
		int j = high;
		
		while(i <= j) {
			while(pivot > a[i]) {
				i++;
			}
			
			while(pivot < a[j]) {
				j--;
			}
			
			if(i <= j) {
				if(pivotIdx == i) {
					pivotIdx = j;
				} else if(pivotIdx == j) {
					pivotIdx = i;
				}
				
				swap(a, i, j);
				//printArray(a);
				i++;
				j--;
			}
		}
		
		//System.out.println("pivotIdx: " + pivotIdx);
		return pivotIdx;
	}

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;

	}
	
	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}