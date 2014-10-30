package others;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	// http://blog.csdn.net/linhuanmars/article/details/22904855
	// http://blog.csdn.net/perfect8886/article/details/19430189
	// use BFS algorithm to solve the problem
	public static class Coordinate {
		int i;
		int j;

		public Coordinate(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;

		int rows = board.length;
		int cols = board[0].length;

		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O')
				bfsFill(board, i, 0); // start BFS
			if (board[i][cols - 1] == 'O')
				bfsFill(board, i, cols - 1); // start BFS
		}
		for (int j = 1; j < cols - 1; j++) {
			if (board[0][j] == 'O')
				bfsFill(board, 0, j); // start BFS
			if (board[rows - 1][j] == 'O')
				bfsFill(board, rows - 1, j); // start BFS
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
	private static void bfsFill(char[][] board, int i, int j) {
		int rows = board.length;
		int cols = board[0].length;
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();

		queue.add(new Coordinate(i, j));
		while (!queue.isEmpty()) {
			Coordinate coordinate = queue.poll();
			int row = coordinate.i;
			int col = coordinate.j;
			if (row >= 0 && row < rows && col >= 0 && col < cols
					&& board[row][col] == 'O') {
				board[row][col] = '#';
				queue.add(new Coordinate(row - 1, col));
				queue.add(new Coordinate(row + 1, col));
				queue.add(new Coordinate(row, col - 1));
				queue.add(new Coordinate(row, col + 1));
			}
		}
	}

	// print
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[][] board = { { 'O', 'X', 'X', 'O' }, { 'X', 'O', 'O', 'X' },
				{ 'X', 'O', 'O', 'X' }, { 'O', 'X', 'X', 'O' } };

		printBoard(board);
		System.out.println();
		
		
		solve(board);
		printBoard(board);
	}
}