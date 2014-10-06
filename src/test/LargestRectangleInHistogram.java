package test;

import java.sql.Time;
import java.time.Clock;
import java.util.Stack;

public class LargestRectangleInHistogram {

	// http://www.tuicool.com/articles/7zUvmy
	// concept : 把資料分成一組一組的連續增加數組（波峰）然後去計算最大面
	// 複雜度O(n)原因是因為所有數字只會被掃一次，並且最多進入stack一次
	public static int largestRectangleArea(int[] height) {
		if (height.length == 0 || height == null)
			return 0;
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i <= height.length; i++) {
			// find an increasing seaquence: e.g: 2 1 2 0
			int curHeight = i == height.length ? 0 : height[i];
			if (stack.isEmpty() || curHeight >= height[stack.peek()])
				stack.push(i);
			else {
				// pop out current sequence(波峰) and calculate the max area
				int curIndex = stack.pop();
				max = Math.max(max, height[curIndex]
						* (stack.isEmpty() ? i : i - (stack.peek() + 1)));
				i--;
			}
		}
		return max;
	}

	static class Wrapper {
		static int num;
		public Wrapper(int n) {
			num = n;
		}
		
		synchronized void hello() throws InterruptedException {
			if(num < 49) {
				num++;
				this.wait();
			} 
			
			if(num == 49) this.notifyAll();
		}
	}
	
	public static void main(String[] args) {
		int[] A = { 2, 1, 2, 0 };
		System.out.println(largestRectangleArea(A));
		

		// 
		final Wrapper wrapper = new Wrapper(0);
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				try {
					wrapper.hello();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(System.currentTimeMillis());
			}
		};
		
		for (int i = 0; i < 50; i++) {
			new Thread(task).start();
		}
	}
	

}
