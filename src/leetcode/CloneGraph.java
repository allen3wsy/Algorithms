package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {

	public class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

		queue.add(node); // crucial point:
		map.put(node, newHead); // everytime you add a node to the queue, check
								// whether the map contains the node.
								// if not: map.put(node, node): in the meantime,
								// the new room for the node is also created

		while (!queue.isEmpty()) {
			UndirectedGraphNode curr = queue.poll();
			List<UndirectedGraphNode> currNeighbors = curr.neighbors;

			for (UndirectedGraphNode aNeighbor : currNeighbors) {
				if (!map.containsKey(aNeighbor)) {
					UndirectedGraphNode copy = new UndirectedGraphNode(
							aNeighbor.label);
					map.put(aNeighbor, copy);
					map.get(curr).neighbors.add(copy);
					queue.add(aNeighbor);
				} else {
					map.get(curr).neighbors.add(map.get(aNeighbor));
				}
			}

		}

		return newHead;
	}
}
