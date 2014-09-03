package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class N_Queens {

	// current row:
	// http://rleetcode.blogspot.com/2014/02/leetcode-n-queens-puzzle-is-problem-of.html
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		if (n < 1)
			return result;

		String[] board = new String[n]; // String[] rows is a chessboard
										// String is one line !!! e.g. "..Q."
		int row = 0;
		solutions(row, n, board, result);
		return result;
	}

	// DFS soluve question
	private void solutions(int curRow, int n, String[] board,
			ArrayList<String[]> result) {
		if (curRow >= n) {
			result.add(board.clone()); // have to use clone here !!!!!! Or new
										// an ArrayList
			return;
		}

		// the For Loop is for the column !!! not for the rows: because right
		// after placing queen,
		// we recurse down to the next row.....
		for (int curCol = 0; curCol < n; curCol++) {
			if (!isValid(curCol, curRow, board)) { // if it is not valid, then
													// continue(skip)
				continue;
			}

			// isValid: then place the queen !!! Right after placing the queen,
			// recurse directly !!!!!
			char[] chars = new char[n]; // new
			Arrays.fill(chars, '.'); // Array.fill() fill this array with '.'
			chars[curCol] = 'Q';
			board[curRow] = String.copyValueOf(chars);

			solutions(curRow + 1, n, board, result); // recursion down to the
														// next row RIGHT after
														// placing a queen !!!
		}

	}

	/**
	 * EX: Critical part: isValid() only checks the above lines
	 */
	// check if current col has conflit with previous Q
	private boolean isValid(int curCol, int curRow, String[] board) {
		// checkColumn
		for (int i = 0; i < curRow; i++) { // only check all the rows above the
											// current rows!!!!!!!
			int qCol = board[i].indexOf("Q"); // returns -1 if not found; the
												// first time

			if (qCol == curCol) { // only compare the column, don't need to
									// compare the row...
				return false;
			}

			int rowDistance = Math.abs(curRow - i);
			int colDistance = Math.abs(curCol - qCol);
			if (rowDistance == colDistance) {
				return false;
			}
		}

		return true;
	}
}
