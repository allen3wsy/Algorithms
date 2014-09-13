package others;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {

	public static int ladderLength(String start, String end, Set<String> dict) {
		if (dict.size() == 0)
			return 0;
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

		wordQueue.add(start);
		distanceQueue.add(1);

		while (!wordQueue.isEmpty()) {
			String currWord = wordQueue.poll();
			Integer currDistance = distanceQueue.poll();

			if (currWord.equals(end)) {
				return currDistance;
			}

			for (int i = 0; i < currWord.length(); i++) {
				char[] currCharArray = currWord.toCharArray();

				for (char c = 'a'; c <= 'z'; c++) { // this for loop is extremly
													// important !!!
					currCharArray[i] = c;

					String newWord = new String(currCharArray);
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						dict.remove(newWord); // don't forget to remove this
												// !!!!!
					}
				}
			}
		}
		return 0; // if wordQueue is empty and still didn't return the result,
					// then 0 means NOT FOUND
	}
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("dag");	// should contained !!!
//		dict.add("dog");   // start
		dict.add("dig");   // end
		
		System.out.println(ladderLength("dog", "dig", dict));
	}
}
