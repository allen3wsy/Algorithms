package test;

public class RainFlowInTerrainHeight {

	public static void printMatrix(int[][] matrix) {
		int size = matrix.length;
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.printf("%4d", matrix[row][col]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] terrain = { { 11, 6, 7, 8 }, { 4, 5, 1, 7 }, { 5, 4, 3, 2 },
				{ 3, 1, 2, 1 } };
		// int[][] terrain = { { 5, 1 }, { 3, 2 } };

		printMatrix(terrain);
		System.out.println(terrainRainFlow(terrain));
	}

	public static int terrainRainFlow(int[][] terrain) {
		if (terrain == null || terrain.length == 0)
			return 0;
		boolean[][] canFlow = new boolean[terrain.length][terrain[0].length];
		int count = 0;

		count += traverseTopRight(canFlow, terrain);
		// EX: Don't forget to do this!!!
		// reset the divide (we choose to reset the whole matrix)
		canFlow = new boolean[terrain.length][terrain[0].length];
		count += traverseBottomLeft(canFlow, terrain);

		return count;
	}

	public static int traverseBottomLeft(boolean[][] canFlow, int[][] terrain) {
		int count = 0;
		// check whether it can flow from left to right
		for (int l = terrain.length; l > 0; l--) {
			for (int i = terrain.length - l, j = 0; j < l; i++, j++) {

				if (j < terrain.length - 1 && terrain[i][j] > terrain[i][j + 1]
						&& (canFlow[i][j + 1] || i == j)) { // Look Right
					canFlow[i][j] = true;
				}

				if (i > 0 && terrain[i][j] > terrain[i - 1][j]
						&& (canFlow[i - 1][j] || i == j)) { // Look Up
					canFlow[i][j] = true;
				}

				if (i != j && canFlow[i][j]) // except the divide
					count++;
			}
		}
		return count;
	}

	public static int traverseTopRight(boolean[][] canFlow, int[][] terrain) {

		int count = 0;
		// check whether it can flow from right to left
		for (int l = terrain.length; l > 0; l--) {
			for (int i = 0, j = terrain.length - l; i < l; i++, j++) {
				if (j > 0 && terrain[i][j] > terrain[i][j - 1]
						&& (canFlow[i][j - 1] || i == j)) { // Look Left
					canFlow[i][j] = true;
				}

				if (i < terrain.length - 1 && terrain[i][j] > terrain[i + 1][j]
						&& (canFlow[i + 1][j] || i == j)) { // Look Down
					canFlow[i][j] = true;
				}

				if (i != j && canFlow[i][j])
					count++;
			}
		}
		return count;
	}

}