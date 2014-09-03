package leetcode;

public class SudokuSolver {

	// This explanation is pretty awesome !!!       Backtracking !!!
    // http://blog.csdn.net/zxzxy1988/article/details/8586289  
    
    // should use is isValid(char[][] board, int i, int j) because if we use isValid(char[][] board), then
    // time limit exceeds....
    private boolean isValid(char[][] board, int i, int j)  {
        
        // row checker
        for(int k = 0; k < 9; k++)  {
            if(k != j && board[i][k]==board[i][j])  
                return false;  
        }  
        // column checker
        for(int k = 0; k < 9; k++)    {
            if(k != i && board[k][j] == board[i][j])  
                return false;  
        }    
        
        for(int row = i / 3 * 3; row < i / 3 * 3 + 3; row++)    {
            for(int col = j / 3 * 3; col < j / 3 * 3 + 3; col++)  {
                if((row != i || col != j) && board[row][col] == board[i][j])    // Important !!!
                    return false;  
            }  
        }  
        return true;  
    }  
    
    public boolean solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++)   {
            for(int j = 0; j < 9; j++)  {
                if(board[i][j] == '.')    {      // if board[i][j] == '.', then try all 9 solutions
                    for(int k = 1; k <= 9; k++)  {     
                        
                        board[i][j] = (char)('0' + k);          // EX:   (char)('0' + 1)
                        if(isValid(board, i, j) && solveSudoku(board))      
                            return true;
                        board[i][j] = '.';          // if not! Then put it back to '.' (Backtracking)
                    }
                    return false;
                }
            }
        }
        return true;        // then all the 9 * 9 positions are filled up, we should return true !!!
    }
}
