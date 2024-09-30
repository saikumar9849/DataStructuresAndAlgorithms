package traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graphs.UndirectedAdjacencyListGraph;
import graphs.UndirectedAdjacencyMatrixGraph;
import main.GraphNodeList;
import main.GraphNodeMatrix;

public class BreadthFirstSearch {

	private UndirectedAdjacencyMatrixGraph adjacencyMatrixGraph;

	private UndirectedAdjacencyListGraph adjacencyListGraph;

	public BreadthFirstSearch(UndirectedAdjacencyMatrixGraph g) {
		this.adjacencyMatrixGraph = g;
	}

	public BreadthFirstSearch(UndirectedAdjacencyListGraph g) {
		this.adjacencyListGraph = g;
	}

	// TC -> O(V+E)
	// SC -> O(V+E)
	public void adjacentMatrixBFS() {
		List<GraphNodeMatrix> nodeList = adjacencyMatrixGraph.nodeList;
		for (GraphNodeMatrix node : nodeList) {
			if (!node.isVisited) {
				adjacentMatrixBFSVisit(node);
			}
		}
	}

	private void adjacentMatrixBFSVisit(GraphNodeMatrix node) {
		Queue<GraphNodeMatrix> q = new LinkedList<GraphNodeMatrix>();
		q.add(node);
		while (!q.isEmpty()) {
			GraphNodeMatrix currNode = q.poll();
			currNode.isVisited = true;
			System.out.print(currNode.name + " ");
			List<GraphNodeMatrix> neighbors = adjacencyMatrixGraph.getNeighbors(currNode);
			for (GraphNodeMatrix tmpNode : neighbors) {
				if (!tmpNode.isVisited) {
					q.add(tmpNode);
					tmpNode.isVisited = true;
				}
			}
		}
	}

	// TC -> O(V+E)
	// SC -> O(V+E)
	public void adjacentListBFS() {
		List<GraphNodeList> nodeList = adjacencyListGraph.nodeList;
		for (GraphNodeList node : nodeList) {
			if (!node.isVisited) {
				adjacentListBFSVisit(node);
			}
		}
	}

	private void adjacentListBFSVisit(GraphNodeList node) {
		Queue<GraphNodeList> q = new LinkedList<GraphNodeList>();
		q.add(node);
		while (!q.isEmpty()) {
			GraphNodeList currNode = q.poll();
			currNode.isVisited = true;
			System.out.print(currNode.name + " ");
			List<GraphNodeList> neighbors = currNode.neighbors;
			for (GraphNodeList tmpNode : neighbors) {
				if (!tmpNode.isVisited) {
					q.add(tmpNode);
					tmpNode.isVisited = true;
				}
			}
		}
	}
}
