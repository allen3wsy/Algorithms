package leetcode;

public class UniquePaths2 {

	// http://blog.csdn.net/u010500263/article/details/18853041
    // this approach requires no space: just the original O(n 2) space:
    // change 1 to -1 so that it will cause no conflict!!! 
    
    // my method needs O(N 2) space
    // O(n 2) space and time
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid == null) 
            return 0;  
        
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1 || obstacleGrid[0][0] == 1)
            return 0;   
        
        int[][] path = new int[obstacleGrid.length][obstacleGrid[0].length];
          
        for(int i = 0; i < obstacleGrid[0].length; i++) {  
            if(obstacleGrid[0][i] != 1) 
                path[0][i] = 1;  
            else                   // otherwise: it is an obstacle, then cannot pass it, all paths right
                break;             // would be 0
        }  
          
        for(int i = 0; i < obstacleGrid.length; i++) {  
            if(obstacleGrid[i][0] != 1) 
                path[i][0] = 1;  
            else                   // otherwise: it is an obstacle, then cannot pass it, all paths down
                break;             // would be 0
        }  
          
        for(int i = 1; i < obstacleGrid.length; i++)    {  
            for(int j = 1; j < obstacleGrid[0].length; j++)  {  
                if(obstacleGrid[i][j] == 0)  {  
                    if(obstacleGrid[i - 1][j] == 0) 
                        path[i][j] += path[i - 1][j];  
                    if(obstacleGrid[i][j - 1] == 0) 
                        path[i][j] += path[i][j - 1];  
                }  
            }  
        }  
          
        return path[path.length - 1][path[0].length - 1];  
    }
}
