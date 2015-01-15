package com.learning.algorithm.array;

public class LongSequence {

	public static void main(String[] args) {
		int[] seq = new int[]{1,0,1,0};//{0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1};//
		
		System.out.println(printIndex(seq, seq.length));
	}

	private static int printIndex(int[] seq, int length) {
		int startIdx = -1;
		int endIdx = -1;
		int preVal = seq[0];
		
		int maxLength = Integer.MIN_VALUE;
		int maxIdx = -1;
		int tempMaxIdx = -1;
		
		
		for(int i = 1; i < length; i++) {
			System.out.println("Index: " + i);
			//no transition
			if(seq[i] == preVal) {
				System.out.println("PreVal matched with current value: " + preVal + "|" + seq[i]);
				//reset start index
				//startIdx = -1;
				
				preVal = seq[i];
				
				if(startIdx != -1 && preVal == 0) {
					startIdx = -1;
				}
				
				System.out.println("StartIdx : " + startIdx);
				
				//if reaches the end
				if(i == length - 1) {
					if(seq[i] == 1) {
						
					}else {
						
					}
				}
				
				
				
				continue;
			}
			
			//transition 1-0-1
			if(i > 1 && seq[i] == 1 && seq[i - 1] == 0 && seq[i - 2] == 1) {
				System.out.println("1-0-1");
				
				tempMaxIdx = i - 1;
				preVal = seq[i];
				
				System.out.println("Temp max index: " + tempMaxIdx);
				
				//last index
				if(i == length - 1) {
					endIdx = i;
					
					if(endIdx - startIdx + 1 >= maxLength) {
						if(tempMaxIdx == -1) {
							maxLength = endIdx - startIdx + 1;
							
							maxIdx = startIdx;
							
							System.out.println("current max length: " + maxLength);
							System.out.println("Current max idx: " + maxIdx);
						} else {
							maxLength = endIdx - startIdx;
							
							maxIdx = tempMaxIdx;
							tempMaxIdx = -1;
							
							System.out.println("current max length: " + maxLength);
							System.out.println("Current max idx: " + maxIdx);
							System.out.println("Current start idx: " + startIdx);
						}
					}
				}
			} else //transition from 0 to 1
				if(seq[i] == 1 && seq[i] != preVal) {
					System.out.println("0-1");
					
					//transition with two or more 0's
					if(startIdx == -1) {
						//include previous 0
						startIdx = i - 1;
						System.out.println("Start Idx: " + startIdx);
					}
					
					System.out.println("Start Idx: " + startIdx);
					
					//update previous value
					preVal = 1;
					
					if(i == length - 1) {
						endIdx = i;
						
						if(endIdx - startIdx + 1 >= maxLength) {
							maxLength = endIdx - startIdx + 1;
							System.out.println("Max: " + maxLength);
							maxIdx = startIdx;
							tempMaxIdx = -1;
						}
					}
					
				}
			
			
			//transition from 1 to 0
			if(seq[i] == 0 && seq[i] != preVal) {
				System.out.println("1-0");
				//update previous value
				preVal = 0;
				
				if(seq[0] == 1 && i == 1) {//first element is zero and checking on 2nd element (1-0)
					startIdx = 0;
					//endIdx = 1;
					
					maxIdx = 1;
					
					maxLength = 2;
					
					System.out.println("Current Max length: " + maxLength);
					System.out.println("Current max idx: " + maxIdx);
					
					//preVal = 0;
					
					continue;
				}
				
				
				endIdx = i - 1; //exclude next 0
				System.out.println("EndIdx: " + endIdx);
				
				//new max sequence found
				//replacing 0 in before or after the sequence provides same length
				if(endIdx - startIdx + 1 >= maxLength) {
					if(tempMaxIdx == -1) {
						maxLength = endIdx - startIdx + 1;
						
						maxIdx = startIdx;
						
						System.out.println("current max length: " + maxLength);
						System.out.println("Current max idx: " + maxIdx);
					} else {
						if(startIdx == 0) {//found 1-0-1 for the first three elements
							maxLength = endIdx - startIdx + 1;
						} else {
							maxLength = endIdx - startIdx;
						}
						
						maxIdx = tempMaxIdx;
						tempMaxIdx = -1;
						
						System.out.println("current max length: " + maxLength);
						System.out.println("Current max idx: " + maxIdx);
					}
				}
			}
		}
		
		System.out.println("Length: " + maxLength);
		
		return maxIdx;
	}

}
