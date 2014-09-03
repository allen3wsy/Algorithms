package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	// http://blog.csdn.net/linhuanmars/article/details/22904855
    // http://blog.csdn.net/perfect8886/article/details/19430189
    // use BFS algorithm to solve the problem
	public class Coordinate {
		int i;
		int j;

		Coordinate(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	private int rows;
	private int cols;

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;

		rows = board.length;
		cols = board[0].length;
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		for (int i = 0; i < rows; ++i) {
			if (board[i][0] == 'O') {
				queue.add(new Coordinate(i, 0));		// add one to the queue then start BFS
				bfsFill(queue, board);					
			}
			if (board[i][cols - 1] == 'O') {
				queue.add(new Coordinate(i, cols - 1)); // add one to the queue then start BFS
				bfsFill(queue, board);
			}
		}
		for (int j = 1; j < cols - 1; ++j) {
			if (board[0][j] == 'O') {
				queue.add(new Coordinate(0, j));		// add one to the queue then start BFS
				bfsFill(queue, board);					
			}
			if (board[rows - 1][j] == 'O') {
				queue.add(new Coordinate(rows - 1, j)); // add one to the queue then start BFS
				bfsFill(queue, board);
			}
		}
		
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	// the queue has at least one <Coordinate> when starting this algorithm
	private void bfsFill(Queue<Coordinate> queue, char[][] board) {
		while (!queue.isEmpty()) {
			Coordinate coordinate = queue.poll();
			int i = coordinate.i;
			int j = coordinate.j;
			if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
				continue;
			}
			board[i][j] = '#';
			queue.add(new Coordinate(i - 1, j));
			queue.add(new Coordinate(i + 1, j));
			queue.add(new Coordinate(i, j - 1));
			queue.add(new Coordinate(i, j + 1));
		}
	}
	
	public static void main(String[] args) {
		
	}
}