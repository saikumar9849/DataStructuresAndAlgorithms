package graphs;

import java.util.ArrayList;
import java.util.List;

import main.GraphNodeMatrix;

public class UndirectedAdjacencyMatrixGraph {

	public List<GraphNodeMatrix> nodeList = new ArrayList<>();
	public int[][] adjacencyMatrix;

	public UndirectedAdjacencyMatrixGraph(List<GraphNodeMatrix> nodeList) {
		this.nodeList = nodeList;
		this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}

	public void addUndirectedEdge(int i, int j) {
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
	}

	public List<GraphNodeMatrix> getNeighbors(GraphNodeMatrix node) {
		List<GraphNodeMatrix> neighbors = new ArrayList<>();
		for (int j = 0; j < this.adjacencyMatrix.length; j++) {
			if (this.adjacencyMatrix[node.index][j] == 1) {
				neighbors.add(nodeList.get(j));
			}
		}
		return neighbors;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("  ");
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name + " ");
		}

		for (int i = 0; i < nodeList.size(); i++) {
			s.append("\n");
			s.append(nodeList.get(i).name);
			for (int j : adjacencyMatrix[i]) {
				s.append(" " + j);
			}
		}
		s.append("\n");
		return s.toString();
	}
}
