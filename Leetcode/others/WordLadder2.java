package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder2 {

	// http://blog.csdn.net/muscler/article/details/22906533
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (start == null || end == null)
			return result;
		ArrayList<String> tmpList = new ArrayList<String>();

		// if start is equal to end, then return it (edge case)
		if (start.equals(end)) {
			tmpList.add(start);
			tmpList.add(end);
			result.add(tmpList);
			return result;
		}

		// create another hashmap，保存每个节点的所有前驱。
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		map.put(end, new ArrayList<String>());
		map.put(start, new ArrayList<String>());
		for (String s : dict) {
			map.put(s, new ArrayList<String>());
		}

		// 利用bfs 层序遍历 如果队列中有end 那么结束遍历（到最短的一层就结束）
		Queue<String> queue = new LinkedList<String>();
		ArrayList<String> currentlevel = new ArrayList<String>();

		queue.offer(start);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			currentlevel.clear();
			for (int i = 0; i < levelSize; i++) {
				String top = queue.poll(); // pop it, then remove from dict
				if (dict.contains(top))
					dict.remove(top); // Don't forget to remove it
				currentlevel.add(top);
			}

			// 循环每个String的每个char 从a到z，在dict里面找是否有
			for (String currWord : currentlevel) {
				for (int i = 0; i < currWord.length(); ++i) {
					for (char c = 'a'; c <= 'z'; ++c) {
						char[] currCharArray = currWord.toCharArray();
						currCharArray[i] = c;
						String newWord = new String(currCharArray);

						if (!currWord.equals(start) && newWord.equals(end)) {
							map.get(end).add(currWord);
							queue.offer(newWord);
						} else if (!newWord.equals(currWord)
								&& dict.contains(newWord)) {
							if (!queue.contains(newWord)) // linear O(N)
								queue.offer(newWord);
							map.get(newWord).add(currWord); // add 前驅
						} // else: dict doesn't contain tempStr: do nothing
					}
				}
			} // after the whole pass, check whether the queue contains "end"
			if (queue.contains(end)) // EX: if "end" is in the queue, BREAK !!!
				break;
		}

		tmpList.add(end); // now tmpList only has "end"
		buildpath(start, end, map, tmpList, result);
		return result;
	}

	// depending on preList, find the route from backwards! (DFS) !
	public void buildpath(String start, String end,
			HashMap<String, ArrayList<String>> map, ArrayList<String> tempList,
			ArrayList<ArrayList<String>> result) {

		ArrayList<String> preList = map.get(end);

		if (end.equals(start)) { // base case: found a route
			ArrayList<String> tempList2 = new ArrayList<String>(tempList);
			Collections.reverse(tempList2); // reverse it !!
			result.add(tempList2);
			return;
		}
		for (String s : preList) {
			tempList.add(s);
			buildpath(start, s, map, tempList, result); // s will be the end
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {

	}
}
