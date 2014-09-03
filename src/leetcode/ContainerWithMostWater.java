package leetcode;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        
        int maxVolume = Math.min(height[i], height[j]) * (j - i);
        while(i < j)   {
            if(Math.min(height[i], height[j]) * (j - i) > maxVolume )   
                maxVolume = Math.min(height[i], height[j]) * (j - i);
            
            if(height[i] <= height[j])  // if height[i] is less than height[j], then this lower band should change,
                i++;         // otherwise the volumn will never be able to be bigger
            else
                j--;
        }
        
        return maxVolume;        
    }
}
