package others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
       
        for(int i = 0; i <= numbers.length - 1; i++)    {
            if(map.containsKey(target - numbers[i]))	{
            	result[0] = map.get(target - numbers[i]);
            	result[1] = i + 1;		// note that we havn't put this into map yet
            } else {
            	map.put(numbers[i], i + 1);
            }
        }
        
        return result;
    }
}
