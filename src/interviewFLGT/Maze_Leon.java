package interviewFLGT;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Maze_Leon {

	public Point findPointToAllTargets(int[][] maze) {

		HashMap<Point, Integer> map = new HashMap<Point, Integer>();
		// figure out how many targets inside and assign an agent to each target
		int totalTarget = 0;
		ArrayList<TargetAgent> agents = new ArrayList<TargetAgent>();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == -2) {
					totalTarget++;
					agents.add(new TargetAgent(new Point(i, j), maze));
				}
			}
		}

		// do BFS on all agents at the same time, step by step, if an agent has
		// traversed the maze, set it to rest.
		// if we've found the first point that all agents has been there, return
		// that point
		while (!agents.isEmpty()) {

			// BFS
			for (TargetAgent agent : agents) {

				if (agent.hasNext()) {

					ArrayList<Point> neibors = agent.next();

					for (Point neibor : neibors) {
						int visitTime = (map.containsKey(neibor) ? map
								.get(neibor) : 0) + 1;
						map.put(neibor, visitTime);
					}
				} else {
					// agent has done its job
					agents.remove(agent);
				}
			}

			Point start = null;
			int minDis = Integer.MAX_VALUE;
			for (Map.Entry<Point, Integer> entry : map.entrySet()) {

				if (entry.getValue() >= totalTarget) {
					// found the point!
					Point possible = entry.getKey();
					if (maze[possible.x][possible.y] < minDis) {
						start = possible;
						minDis = maze[possible.x][possible.y];
					}
				}
			}

			// found some possible solutions, pick the one with smallest dis to
			// return
			if (start != null) {
				maze[start.x][start.y] = 99;
				printMatrix(maze);
				return start;
			}
		}

		return null;
	}

	public class TargetAgent implements Iterator<ArrayList<Point>> {

		Queue<Point> queue;
		HashSet<Point> visited;
		int[][] maze;
		int depth = 1;
		ArrayList<Point> next;

		public TargetAgent(Point root, int[][] maze) {
			queue = new LinkedList<Point>();
			visited = new HashSet<Point>();
			this.maze = maze;
			queue.add(root);
			next = new ArrayList<Point>();
			next.add(root);
		}

		@Override
		public boolean hasNext() {
			return !next.isEmpty();
		}

		public int getDepth() {
			return depth;
		}

		@Override
		public ArrayList<Point> next() {

			int currentLevelSize = queue.size();
			ArrayList<Point> returned = new ArrayList<Point>(next);
			next.clear();
			for (int i = 0; i < currentLevelSize; i++) {
				Point current = queue.poll();
				next.add(current);
				visited.add(current);
				// add all unvisited neibors into the queue
				addNonWallNeibors(current);
			}
			depth++;
			return returned;
		}

		private void addNonWallNeibors(Point current) {
			Point leftTop = new Point(current.x - 1 >= 0 ? current.x - 1
					: current.x, current.y - 1 >= 0 ? current.y - 1 : current.y);
			Point rightBottom = new Point(
					current.x + 1 < maze.length ? current.x + 1 : current.x,
					current.y + 1 < maze[0].length ? current.y + 1 : current.y);

			for (int i = leftTop.x; i <= rightBottom.x; i++) {
				for (int j = leftTop.y; j <= rightBottom.y; j++) {
					Point neibor = new Point(i, j);
					// -1 means a wall
					if (!visited.contains(neibor) && !queue.contains(neibor)
							&& maze[i][j] != -1)
						queue.add(neibor);
				}
			}
		}
	}

	public void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%8d", matrix[i][j]));
			}
			System.out.println();
		}
	}

	// init the maze !!!
	public int[][] initMaze() {
		int rows = 7;
		int columns = 7;
		int[][] maze = new int[rows][columns];

		// init maze: -99 means walls
		maze[5][4] = maze[5][5] = maze[4][0] = maze[4][1] = maze[0][3] = maze[1][3] = -1;
		// init maze: -1 means targets
		maze[2][1] = maze[5][2] = maze[4][5] = -2;

		return maze;
	}
}
