package com.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NearestGuard {
	static final int M = 4, N = 5;
	static boolean[][] visited = new boolean[M][N];
	static int[][] len = new int[M][N];
	static char[][] grid = {
			  {'G', '#', '.', '.', 'G'},  
			  {'.', '.', '#', '.', '.'},  
			  {'.', '.', '.', '.', '.'},  
			  {'.', '.', '#', '.', '.'}
			};

	public static void main(String[] args) {
		for(int i = 0; i < M; i++)
			Arrays.fill(len[i], Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j] == 'G') {
					BFS(i, j);
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j] == '.') {
					System.out.print(len[i][j]); 
				} else
					System.out.print(grid[i][j]);
			}
			
			System.out.println();
		}
	}

	static void BFS(int x, int y) {
		visited = new boolean[M][N];
		Queue<Cell> q = new LinkedList<Cell>();
		q.add(new Cell(x, y));

		visited[x][y] = true;
		
		int dist = 1;
		int size = q.size();
		
		while (!q.isEmpty()) {
			Cell top = q.poll();
			
			ArrayList<Cell> cells = getAdjacentCells(top.x, top.y);

			for (Cell cell : cells) {
				int posX = cell.x;
				int posY = cell.y;

				visited[posX][posY] = true;
				q.add(cell);

				if (len[posX][posY] > dist) {
					len[posX][posY] = dist;
				}
			}			
			
			size--;
			
			if (size == 0) {
				size = q.size();
				dist++;
			}
		}
	}

	private static ArrayList<Cell> getAdjacentCells(int x, int y) {
		ArrayList<Cell> list = new ArrayList<Cell>();

		if (x >= M || x < 0 || y >= N || y < 0)
			return list;

		if(x + 1 < M) {
			if(grid[x + 1][y] == '.' && !visited[x + 1][y]) {
				list.add(new Cell(x + 1, y));
			}
		}
		
		if(x - 1 >= 0) {
			if (grid[x - 1][y] == '.' && !visited[x - 1][y]) {
				list.add(new Cell(x - 1, y));
			}
		}
		
		if(y - 1 >= 0) {
			if (grid[x][y - 1] == '.' && !visited[x][y - 1]) {
				list.add(new Cell(x, y - 1));
			}
		}
		
		if(y + 1 < N) {
			if (grid[x][y + 1] == '.' && !visited[x][y + 1]) {
				list.add(new Cell(x, y + 1));
			}
		}

		return list;

	}

	static class Cell {
		int x;
		int y;

		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
