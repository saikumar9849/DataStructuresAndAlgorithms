package traversals;

import java.util.List;
import java.util.Stack;

import graphs.UndirectedAdjacencyListGraph;
import graphs.UndirectedAdjacencyMatrixGraph;
import main.GraphNodeList;
import main.GraphNodeMatrix;

public class DepthFirstSearch {

	private UndirectedAdjacencyMatrixGraph adjacencyMatrixGraph;

	private UndirectedAdjacencyListGraph adjacencyListGraph;

	public DepthFirstSearch(UndirectedAdjacencyMatrixGraph g) {
		this.adjacencyMatrixGraph = g;
	}

	public DepthFirstSearch(UndirectedAdjacencyListGraph g) {
		this.adjacencyListGraph = g;
	}

	// TC -> O(V+E)
	// SC -> O(V+E)
	public void adjacentMatrixDFS() {
		List<GraphNodeMatrix> nodeList = adjacencyMatrixGraph.nodeList;
		for (GraphNodeMatrix node : nodeList) {
			if (!node.isVisited) {
				adjacentMatrixtDFSVisit(node);
			}
		}
	}

	private void adjacentMatrixtDFSVisit(GraphNodeMatrix node) {
		Stack<GraphNodeMatrix> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			GraphNodeMatrix currNode = stack.pop();
			currNode.isVisited = true;
			System.out.print(currNode.name + " ");
			List<GraphNodeMatrix> neighbors = adjacencyMatrixGraph.getNeighbors(currNode);
			for (GraphNodeMatrix tmpNode : neighbors) {
				if (!tmpNode.isVisited) {
					stack.push(tmpNode);
					tmpNode.isVisited = true;
				}
			}
		}
	}

	// TC -> O(V+E)
	// SC -> O(V+E)
	public void adjacentListDFS() {
		List<GraphNodeList> nodeList = adjacencyListGraph.nodeList;
		for (GraphNodeList node : nodeList) {
			if (!node.isVisited) {
				adjacentListDFSVisit(node);
			}
		}
	}

	private void adjacentListDFSVisit(GraphNodeList node) {
		Stack<GraphNodeList> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			GraphNodeList currNode = stack.pop();
			currNode.isVisited = true;
			System.out.print(currNode.name + " ");
			List<GraphNodeList> neighbors = currNode.neighbors;
			for (GraphNodeList tmpNode : neighbors) {
				if (!tmpNode.isVisited) {
					stack.push(tmpNode);
					tmpNode.isVisited = true;
				}
			}
		}
	}

}
