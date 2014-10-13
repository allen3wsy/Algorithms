package others;

public class WordSearch {

	// http://rleetcode.blogspot.com/2014/01/leetcode-world-search-java.html
    // similar to paint color (cc 9.7)
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        // this boolean checker array is used to determine if a position has been traversed !!    
        boolean[][] checker = new boolean[board.length][board[0].length];
       
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // always starts from index 0 for [row, col] !!!
                if (isFind(checker, board, word, 0, row, col)) 
                    return true;
            }
        }
        return false;
    }
    
    public boolean isFind(boolean[][] checker, char[][] board, String word, int i, int row, int col) {
        
        if (board[row][col] != word.charAt(i) || checker[row][col]) // if "traversed", then return "false"
            return false;
        
        checker[row][col] = true;       // set it to true: meaning traversed
        if (i == word.length() - 1)    // if length == word.length, then FINISHED
            return true;
        
        // go up: (row - 1 >= 0) should be put ahead
        if (row - 1 >= 0 && isFind(checker, board, word, i + 1, row - 1, col)) 
            return true;
        // go down: (row + 1 <= board.length - 1) should be put ahead
        if (row + 1 <= board.length - 1 && isFind(checker, board, word, i + 1, row + 1, col))
            return true;
        // go left: (col - 1 >= 0) should be put ahead
        if (col - 1 >= 0 && isFind(checker, board, word, i + 1, row, col - 1)) 
            return true;
        // go right: (col + 1 <= board[0].length - 1) should be put ahead
        if (col + 1 <= board[0].length - 1 && isFind(checker, board, word, i + 1, row, col + 1))
            return true;
        
        checker[row][col] = false;   // set it to false: meaning even after 4 directions still not found
		return false;
	}
}
