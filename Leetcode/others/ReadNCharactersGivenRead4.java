package others;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 */
public class ReadNCharactersGivenRead4 extends Reader4 {

	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		int count = 0;
		char[] mybuf = new char[4];
		while (count < n) {
			int num = read4(mybuf);
			if (num == 0)
				break;
			int index = 0;
			while (index < num && count < n) {
				buf[count++] = mybuf[index++];
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println("asdf");
	}
}

/**
 * fake one...
 */
abstract class Reader4 {
	int read4(char[] buf) {
		return 0;
	}
}