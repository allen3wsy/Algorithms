package two_Dimensional_DP;
import java.util.*;

import javax.print.attribute.HashPrintJobAttributeSet;

/**
 * For the graph traversing algorithm.
 */
public class Solution {
  
  	/**
	 * A node in a graph
	 */
	private static class Node {
		private final Set<Node> neighbors;

		Node() {
			this.neighbors = new HashSet<>();
		}
	}
	
	
	/** @return a map from degree to number of nodes of that degree */
	private static Map<Integer, Integer> calculateDegreeCount(Node node) {
        // YOUR CODE HERE
		// error case:
		if(node == null) 
			return null;
		
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        Set<Node> visited = new HashSet<Node>();
        
        queue.add(node);
        visited.add(node);
        
        while(!queue.isEmpty()) {
        	Node currentNode = queue.poll();
        	int degree = currentNode.neighbors.size();
        	
        	// add this node to the result
        	if(result.containsKey(degree)) {
        		result.put(degree, result.get(degree) + 1);
        	} else {
				result.put(degree, 1);
			}
        	
        	// put its neighbours to the queue
        	for(Node nei : currentNode.neighbors) {
        		if(!visited.contains(nei)) {
        			visited.add(nei);
        			queue.add(nei);
        		}
        	}
        }
        
        return result;
	}
	
}
