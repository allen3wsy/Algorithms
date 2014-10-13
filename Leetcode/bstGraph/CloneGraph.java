package bstGraph;

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

		// crucial point: everytime you add a node to the queue, check whether
		// the map contains the node. if not: map.put(node, node): in the
		// meantime, the new room for the node is also created
		queue.add(node);
		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		map.put(node, newHead);

		// BFS !!!
		while (!queue.isEmpty()) {
			UndirectedGraphNode oldNode = queue.poll();
			for (UndirectedGraphNode nei : oldNode.neighbors) {
				// crucial !!! see if neighbours are already in the map
				if (!map.containsKey(nei)) {
					queue.add(nei);
					map.put(nei, new UndirectedGraphNode(nei.label));
				}
				map.get(oldNode).neighbors.add(map.get(nei));
			}
		}
		return newHead;
	}
}
