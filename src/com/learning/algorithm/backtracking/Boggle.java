package com.learning.algorithm.backtracking;

import java.util.HashSet;

public class Boggle {
	static HashSet<String> dictionary = new HashSet<String>();

	public static void main(String[] args) {
		String[] words = { "I", "LOVE", "YOU" };
		
		Character[][] grid = {
				{'O', 'I', 'L'},
				{'Y', 'V', 'O'},
				{'O', 'U', 'E'}
		};
		
		//build dictionary
		buildDictionary(words);
		
		//find words in the grid
		findWords(grid);
	}

	private static void findWords(Character[][] grid) {
		int M = grid.length;
		int N = grid[0].length;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				boolean[][] visited = new boolean[M][N];
				
				findWordsUtil(grid, i, j, M, N, visited, new String());
			}
		}
	}

	private static void findWordsUtil(Character[][] grid, int i, int j, int M, int N, boolean[][] visited, String result) {
		if(i < 0 || i >= M || j < 0 || j >= N)
			return;
		
		if(visited[i][j])
			return;
		
		visited[i][j] = true;
		
		//update result
		result += grid[i][j];
		
		//if valid word found print and return
		if(dictContains(result)) {
			System.out.println(result);
		}
		
		//call recur from adjacent cells
		//cell can have at most 8 adjacent cells
		findWordsUtil(grid, i, j - 1, M, N, visited, result);
		findWordsUtil(grid, i, j + 1, M, N, visited, result);
		
		findWordsUtil(grid, i + 1, j, M, N, visited, result);
		findWordsUtil(grid, i - 1, j, M, N, visited, result);
		
		findWordsUtil(grid, i - 1, j - 1, M, N, visited, result);
		findWordsUtil(grid, i - 1, j + 1, M, N, visited, result);
		findWordsUtil(grid, i + 1, j - 1, M, N, visited, result);
		findWordsUtil(grid, i + 1, j + 1, M, N, visited, result);
		
		visited[i][j] = false;
		
		//remove last character from string
		result = result.substring(0, result.length() - 1);
	}

	private static boolean dictContains(String test) {
		return dictionary.contains(test);
	}

	private static void buildDictionary(String[] words) {
		for (String w : words) {
			dictionary.add(w);
		}
	}
}
