package com.practice.hackerrank;

import java.util.Scanner;

public class numbergame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.valueOf(sc.nextLine());

		for (int t = 1; t <= T; t++) {
			calculateValue(Long.valueOf(sc.nextLine()));
		}
	}

	private static void calculateValue(long A) {
		int i = 1;
		
		while(true) {
			long number = A * i;
			
			if(number > 4 && !(number % 4 == 0 || number % 4 == 4)) { 
				i++;
				continue;
			}
			
			int count = getCount(number);
			
			if(count == -1) {
				i++;
				
				continue;
			} else {
				System.out.println(count);
				break;
			}
		}
	}

	private static int getCount(long number) {
		if(number < 10 && number % 10 != 4)
			return -1;
		
		int zeros = 0;
		int fours = 0;
		
		long prev = -1;
		
		while (number > 0) {
		    long current = number % 10;
		    
		    if(prev == -1) {
		    	prev = current;
		    	number = number / 10;
		    	
		    	if(current == 0) {
		    		zeros++;
		    	} else if(current == 4) {
		    		fours++;
		    	}
		    	
		    	continue;
		    }
		    	
		    if((prev == 4 && current == 4) || (prev == 0 && current == 4) || (prev == 0 && current == 0)) {
		    	//update count
		    	if(current == 0) {
		    		zeros++;
		    	} else if(current == 4) {
		    		fours++;
		    	}
		    	
		    	prev = current;
		    	number = number / 10;
		    } else {
		    	return -1;
		    }
		}
		    
		return (2 * fours + zeros);
	}

}
