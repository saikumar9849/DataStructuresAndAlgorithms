package topologicalsort;

import java.util.Stack;

import graphs.DirectedAdjacencyListGraph;
import graphs.DirectedAdjacencyMatrixGraph;
import main.GraphNodeList;
import main.GraphNodeMatrix;

public class TopologicalSort {

	private DirectedAdjacencyMatrixGraph adjacencyMatrixGraph;

	private DirectedAdjacencyListGraph adjacencyListGraph;

	public TopologicalSort(DirectedAdjacencyListGraph graph) {
		this.adjacencyListGraph = graph;
	}

	public TopologicalSort(DirectedAdjacencyMatrixGraph graph) {
		this.adjacencyMatrixGraph = graph;
	}

	// TC -> O(V+E)
	// SC -> O(V+E)
	public void topologicalSortingUsingDirectedAdjacencyListGraph() {
		Stack<GraphNodeList> stack = new Stack<>();
		for (GraphNodeList node : this.adjacencyListGraph.nodeList) {
			if (!node.isVisited) {
				topologicalSortUsingDirectedAdjacencyListGraphVisit(stack, node);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().name + " ");
		}
	}

	private void topologicalSortUsingDirectedAdjacencyListGraphVisit(Stack<GraphNodeList> stack, GraphNodeList node) {
		for (GraphNodeList currNode : node.neighbors) {
			if (!currNode.isVisited) {
				topologicalSortUsingDirectedAdjacencyListGraphVisit(stack, currNode);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}

	// TC -> O(V+E)
	// SC -> O(V+E)
	public void topologicalSortingUsingDirectedAdjacencyMatrixGraph() {
		Stack<GraphNodeMatrix> stack = new Stack<>();
		for (GraphNodeMatrix node : this.adjacencyMatrixGraph.nodeList) {
			if (!node.isVisited) {
				topologicalSortUsingDirectedAdjacencyMatrixGraphVisit(stack, node);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().name + " ");
		}
	}

	private void topologicalSortUsingDirectedAdjacencyMatrixGraphVisit(Stack<GraphNodeMatrix> stack,
			GraphNodeMatrix node) {
		for (GraphNodeMatrix currNode : this.adjacencyMatrixGraph.getNeighbors(node)) {
			if (!currNode.isVisited) {
				topologicalSortUsingDirectedAdjacencyMatrixGraphVisit(stack, currNode);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}
}
