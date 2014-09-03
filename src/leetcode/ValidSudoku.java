package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        
        // EX: Use Character to maintain not only Integer, but also Character like '.'
        Set<Character> set = new HashSet<Character>();      // only need to declare once...
        // Check for each row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && set.contains(board[i][j]))
                    return false;
                
                set.add(board[i][j]);
            }
            set.clear();
        }
        
        // Check for each column
        for(int j = 0; j < 9; j++)  {
            for(int i = 0; i < 9; i++)  {
                if(board[i][j] != '.' && set.contains(board[i][j])) 
                    return false;
                
                set.add(board[i][j]);
            }
            set.clear();
        }
        
        // Check for each sub-grid
        for (int k = 0; k < 9; k++) {       // there are (k = 9) blocks
            for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {           // i = k / 3 * 3
                for (int j = k % 3 * 3; j < k % 3 * 3 + 3; j++) {       // j = k % 3 * 3
                    if (board[i][j] != '.' && set.contains(board[i][j]))
                        return false;
                   
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
     
        return true; 
    }
}
