package others;

import java.util.Arrays;

public class Three3SumClosest {

	public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int diff = num[0] + num[1] + num[2] - target;       // make the Math.abs(diff) as small as possible
        
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;
            
            while (start < end) {
                int d = num[i] + num[start] + num[end] - target;   
                if(Math.abs(d) < Math.abs(diff))    {
                    diff = d;
                }
                if(d == 0)  {
                    return target;
                } else if(d < 0)   {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return diff + target;
    }
}
