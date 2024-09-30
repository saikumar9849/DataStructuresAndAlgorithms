package single_source_shortest_path;

import java.util.LinkedList;
import java.util.Queue;

import graphs.UndirectedAdjacencyListGraph;
import graphs.UndirectedAdjacencyMatrixGraph;
import main.GraphNodeList;
import main.GraphNodeMatrix;

//A Single source shortest path problem is about finding a path between a given vertex(called source) to all other vertices in a graph such that the total distance between them (source and destination) is minimum.

//BFS Algorithm will not work for Weighted Graph
//It only be used for both directed, undirected and unweighted.
//For weighted graphs this algo will not work
public class SSSPUsingBFS {

	private UndirectedAdjacencyListGraph undirectedAdjacencyListGraph;

	private UndirectedAdjacencyMatrixGraph undirectedAdjacencyMatrixGraph;

	public SSSPUsingBFS(UndirectedAdjacencyListGraph graph) {
		this.undirectedAdjacencyListGraph = graph;
	}

	public SSSPUsingBFS(UndirectedAdjacencyMatrixGraph graph) {
		this.undirectedAdjacencyMatrixGraph = graph;
	}

	// TC -> O(V^2)
	// SC -> O(E)
	public void adjacentListBFS(GraphNodeList node) {
		System.out.println("Single source shortest path Algorithm for AdjacencyList using BFS for Node " + node.name);
		Queue<GraphNodeList> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNodeList currNode = queue.poll();
			currNode.isVisited = true;
			System.out.print(node.name + ": ");
			pathPrintAdjacencyList(currNode);
			System.out.println();
			for (GraphNodeList tmpNode : currNode.neighbors) {
				if (!tmpNode.isVisited) {
					tmpNode.parent = currNode;
					tmpNode.isVisited = true;
					queue.add(tmpNode);
				}
			}
		}
	}

	private void pathPrintAdjacencyList(GraphNodeList node) {
		if (node.parent != null) {
			pathPrintAdjacencyList(node.parent);
			System.out.print("-> " + node.name);
		}
	}

	// TC -> O(V^2)
	// SC -> O(E)
	public void adjacentMatrixBFS(GraphNodeMatrix node) {
		System.out.println("Single source shortest path Algorithm for AdjacencyMatrix using BFS for Node " + node.name);
		Queue<GraphNodeMatrix> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNodeMatrix currNode = queue.poll();
			currNode.isVisited = true;
			System.out.print(node.name + ": ");
			pathPrintAdjacencyMatrix(currNode);
			System.out.println();
			for (GraphNodeMatrix tmpNode : this.undirectedAdjacencyMatrixGraph.getNeighbors(currNode)) {
				if (!tmpNode.isVisited) {
					tmpNode.parent = currNode;
					tmpNode.isVisited = true;
					queue.add(tmpNode);
				}
			}
		}
	}

	private void pathPrintAdjacencyMatrix(GraphNodeMatrix node) {
		if (node.parent != null) {
			pathPrintAdjacencyMatrix(node.parent);
			System.out.print("-> " + node.name);
		}
	}

}
