package interviewFLGT;
// you can also use imports, for example:
// import java.math.*;
import java.util.*;

class Tree	{
	int x;
	Tree l;
	Tree r;
	
}

class Solution_2 {
    public int solution(Tree T) {
        // write your code in Java SE 6
        
        if(T == null)
            return 0;
        
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(T.x);
        print(T, list);
        return list.size();
        
    }
    
    public void print(Tree T, ArrayList<Integer> list)    {
        if(T == null)
            return;
        if(T.l != null)    {
            if(T.l.x >= T.x)   {
                list.add(T.l.x);
            } else    {
             T.l.x = T.x;   
            }
                
            print(T.l, list);
        }
        
         if(T.r != null)    {
            if(T.r.x >= T.x)   {
                list.add(T.r.x);
            } else    {
             T.r.x = T.x;   
            }               
            print(T.r, list);
        }
        
        
    }
        
}