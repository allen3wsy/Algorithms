package others;

public class SingleNumber2 {

	public static int singleNumber(int[] A) {
        int result = 0;
        
        // O(32*N) time
        // there are 32 bits in total, (starting from right to left !!!)
        // 1 is 00000000000000000000000000000001, so move every single number right shift
        for (int i = 0; i <= 31; i++) {
            int countPerBit = 0;
            
            for(int j = 0; j < A.length; j++) {
                countPerBit += ((A[j] >> i) & 1); // 统计每一位的个数, move right first
            }
            result |= ((countPerBit % 3) << i);   // 取余放回result, then move them left back
        }
        return result;
    }

	public static void main(String[] args) {
		int[] array = {2, 2, 2, 3, 10, 10, 10};
		System.out.println(singleNumber(array));
	}
}
