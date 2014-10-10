package others;

public class SudokuSolver {

	// This explanation is pretty awesome !!! Backtracking !!!
	// http://blog.csdn.net/zxzxy1988/article/details/8586289

	// should use is isValid(char[][] board, int i, int j) because if we use
	// isValid(char[][] board), then time limit exceeds....
	private boolean isValid(char[][] board, int i, int j) {

		for (int k = 0; k < 9; k++) { // row checker
			if (k != j && board[i][k] == board[i][j])
				return false;
		}
		for (int k = 0; k < 9; k++) { // column checker
			if (k != i && board[k][j] == board[i][j])
				return false;
		}
		for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) { // block checker
			for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
				if ((row != i || col != j) && board[row][col] == board[i][j]) // Important!!!
					return false;
			}
		}
		return true;
	}

	public boolean solveSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') { // if it is '.', then try 9 solutions
					for (int k = 1; k <= 9; k++) {
						board[i][j] = (char) ('0' + k); // EX: (char)('0' + 1)
						if (isValid(board, i, j) && solveSudoku(board))
							return true;
						board[i][j] = '.'; // back to '.' (Backtracking)
					}
					return false; // board[i][j] must be set to '.' before false
				}
			}
		}
		return true; // meaning 9 * 9 positions are numbers, should return true!
	}
}
