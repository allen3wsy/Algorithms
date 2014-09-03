package leetcode;

import java.util.Arrays;

public class N_Queens2 {

	// current row:
    // http://rleetcode.blogspot.com/2014/02/leetcode-n-queens-puzzle-is-problem-of.html
    public int totalNQueens(int n) {
        if (n < 1) 
            return 0;
        
        String[] rows = new String[n];      // String[] rows is a chessboard
                                            // String is one line !!!  e.g.   "..Q."
        int row = 0; 
        int[] total = new int[1];           // total number:
        
        solutions(row, n, rows, total);
        return total[0];
    }
    
    // DFS soluve question
    private void solutions(int curRow, int n, String[] rows, int[] total) {
        if (curRow >= n) {
            total[0]++;        
            return;
        }
        
        // the For Loop is for the column !!! not for the rows: because right after placing queen,
        // we recurse down to the next row.....
        for(int curCol = 0; curCol < n; curCol++)    {
            if (!isValid(curCol, curRow,  rows))    {       // if it is not valid, then continue(skip)
                continue;
            }
            
            // isValid: then place the queen !!!  Right after placing the queen, recurse directly !!!!!
            char[] chars = new char[n];     // new 
            Arrays.fill(chars, '.');        // Array.fill()   fill this array with '.'
            chars[curCol] = 'Q';
            rows[curRow] = String.copyValueOf(chars);
            
            solutions(curRow + 1, n, rows, total);          // recursion down to the next row RIGHT after placing a queen !!!
        }
        
    }
    
    /**
     * EX:
     * Critical part: isValid() only checks the above lines
     */ 
    // check if current col has conflit with previous Q
    private boolean isValid(int curCol, int curRow, String[] rows){
        // checkColumn
        for (int i = 0; i < curRow; i++)     {          // only check all the rows above the current rows!!!!!!!
            int qCol = rows[i].indexOf("Q");            // returns -1 if not found;  the first time

            if (qCol == curCol)    {                    // only compare the column, don't need to compare the row...
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
