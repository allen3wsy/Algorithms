package interviewFLGT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Algo details are found here
// https://courses.cs.washington.edu/courses/cse326/03wi/lectures/RaoLect20.pdf
// Used data structure:
// Queue, HashMap(for inDegree array), ArrayList(serves as the adjacency List)
public class TopologicalSort {

	public static class Node {
		public char val;
		public ArrayList<Node> neighbors = new ArrayList<Node>();

		public Node(char value) {
			this.val = value;
		}

		public void addNeighbors(Node nei) {
			this.neighbors.add(nei);
		}
	}

	public static ArrayList<Node> topologicalSort(ArrayList<Node> input) {

		ArrayList<Node> result = new ArrayList<>();
		Map<Node, Integer> inDegreeMap = new HashMap<Node, Integer>();
		Queue<Node> queue = new LinkedList<Node>();

		for (Node node : input) { // init all to 0
			inDegreeMap.put(node, 0);
		}
		for (Node node : input) { // initialize the inDegree values
			for (Node nei : node.neighbors) {
				inDegreeMap.put(nei, inDegreeMap.get(nei) + 1);
			}
		}

		// init the queue
		for (Map.Entry<Node, Integer> entry : inDegreeMap.entrySet()) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			result.add(temp);
			// I can choose whether I can set temp.neighbours to null
			for (Node nei : temp.neighbors) {
				inDegreeMap.put(nei, inDegreeMap.get(nei) - 1); // inDegree -= 1
				if (inDegreeMap.get(nei) == 0) {
					queue.add(nei);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		Node d = new Node('D');
		Node e = new Node('E');
		Node f = new Node('F');
		a.addNeighbors(b);
		a.addNeighbors(d);
		b.addNeighbors(c);
		c.addNeighbors(d);
		c.addNeighbors(e);
		d.addNeighbors(e);

		ArrayList<Node> input = new ArrayList<Node>(Arrays.asList(a, b, c, d,
				e, f));

		// sort them
		ArrayList<Node> sortedList = topologicalSort(input);
		for (Node node : sortedList) {
			System.out.println(node.val);
		}
	}
}
