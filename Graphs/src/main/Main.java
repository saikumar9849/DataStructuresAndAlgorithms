package main;

import java.util.ArrayList;

import all_pairs_shortest_path.FloydWarshall;
import graphs.DirectedAdjacencyListGraph;
import graphs.DirectedAdjacencyMatrixGraph;
import graphs.UndirectedAdjacencyListGraph;
import graphs.UndirectedAdjacencyMatrixGraph;
import graphs.WeightedGraph;
import minimum_spanning_tree.Kruskal;
import minimum_spanning_tree.Prims;
import single_source_shortest_path.BellmanFord;
import single_source_shortest_path.Dijkstra;
import single_source_shortest_path.SSSPUsingBFS;
import topologicalsort.TopologicalSort;
import traversals.BreadthFirstSearch;
import traversals.DepthFirstSearch;

public class Main {

	public static void main(String args[]) {

		System.out.println("\n\n<!-- Undirected Graph implementation using AdjacencyMatrix -->");
		ArrayList<GraphNodeMatrix> nodeList = new ArrayList<>();
		nodeList.add(new GraphNodeMatrix("A", 0));
		nodeList.add(new GraphNodeMatrix("B", 1));
		nodeList.add(new GraphNodeMatrix("C", 2));
		nodeList.add(new GraphNodeMatrix("D", 3));
		nodeList.add(new GraphNodeMatrix("E", 4));
		UndirectedAdjacencyMatrixGraph uAG = new UndirectedAdjacencyMatrixGraph(nodeList);
		uAG.addUndirectedEdge(0, 1);
		uAG.addUndirectedEdge(0, 2);
		uAG.addUndirectedEdge(0, 3);
		uAG.addUndirectedEdge(1, 4);
		uAG.addUndirectedEdge(2, 3);
		uAG.addUndirectedEdge(3, 4);
		System.out.println(uAG);
//		BreadthFirstSearch bfsM = new BreadthFirstSearch(uAG);
//		bfsM.adjacentMatrixBFS();
//		System.out.println();
//		DepthFirstSearch dfsM = new DepthFirstSearch(uAG);
//		dfsM.adjacentMatrixDFS();
		SSSPUsingBFS sSSPUsingBFSM = new SSSPUsingBFS(uAG);
		sSSPUsingBFSM.adjacentMatrixBFS(nodeList.get(0));

		System.out.println("\n\n<!-- Undirected Graph implementation using AdjacencyList -->");
		ArrayList<GraphNodeList> nodeList1 = new ArrayList<>();
		nodeList1.add(new GraphNodeList("A", 0));
		nodeList1.add(new GraphNodeList("B", 1));
		nodeList1.add(new GraphNodeList("C", 2));
		nodeList1.add(new GraphNodeList("D", 3));
		nodeList1.add(new GraphNodeList("E", 4));
		UndirectedAdjacencyListGraph uAL = new UndirectedAdjacencyListGraph(nodeList1);
		uAL.addUndirectedEdge(0, 1);
		uAL.addUndirectedEdge(0, 2);
		uAL.addUndirectedEdge(0, 3);
		uAL.addUndirectedEdge(1, 4);
		uAL.addUndirectedEdge(2, 3);
		uAL.addUndirectedEdge(3, 4);
		System.out.println(uAL);
//		BreadthFirstSearch bfsL = new BreadthFirstSearch(uAL);
//		bfsL.adjacentListBFS();
//		System.out.println();
//		DepthFirstSearch dfsL = new DepthFirstSearch(uAL);
//		dfsL.adjacentListDFS();
		SSSPUsingBFS sSSPUsingBFSL = new SSSPUsingBFS(uAL);
		sSSPUsingBFSL.adjacentListBFS(nodeList1.get(0));

		System.out.println("\n\n<!-- Directed Graph implementation using AdjacencyList -->");
		ArrayList<GraphNodeList> nodeListdl = new ArrayList<>();
		nodeListdl.add(new GraphNodeList("A", 0));
		nodeListdl.add(new GraphNodeList("B", 1));
		nodeListdl.add(new GraphNodeList("C", 2));
		nodeListdl.add(new GraphNodeList("D", 3));
		nodeListdl.add(new GraphNodeList("E", 4));
		nodeListdl.add(new GraphNodeList("F", 5));
		nodeListdl.add(new GraphNodeList("G", 6));
		nodeListdl.add(new GraphNodeList("H", 7));
		DirectedAdjacencyListGraph dAL = new DirectedAdjacencyListGraph(nodeListdl);
		dAL.addDirectedEdge(0, 2);
		dAL.addDirectedEdge(2, 4);
		dAL.addDirectedEdge(4, 7);
		dAL.addDirectedEdge(4, 5);
		dAL.addDirectedEdge(5, 6);
		dAL.addDirectedEdge(1, 2);
		dAL.addDirectedEdge(1, 3);
		dAL.addDirectedEdge(3, 5);
		System.out.println(dAL);
		TopologicalSort tsort = new TopologicalSort(dAL);
		tsort.topologicalSortingUsingDirectedAdjacencyListGraph();

		System.out.println("\n\n<!-- Directed Graph implementation using AdjacencyMatrix -->");
		ArrayList<GraphNodeMatrix> nodeListdm = new ArrayList<>();
		nodeListdm.add(new GraphNodeMatrix("A", 0));
		nodeListdm.add(new GraphNodeMatrix("B", 1));
		nodeListdm.add(new GraphNodeMatrix("C", 2));
		nodeListdm.add(new GraphNodeMatrix("D", 3));
		nodeListdm.add(new GraphNodeMatrix("E", 4));
		nodeListdm.add(new GraphNodeMatrix("F", 5));
		nodeListdm.add(new GraphNodeMatrix("G", 6));
		nodeListdm.add(new GraphNodeMatrix("H", 7));
		DirectedAdjacencyMatrixGraph dAM = new DirectedAdjacencyMatrixGraph(nodeListdm);
		dAM.addDirectedEdge(0, 2);
		dAM.addDirectedEdge(2, 4);
		dAM.addDirectedEdge(4, 7);
		dAM.addDirectedEdge(4, 5);
		dAM.addDirectedEdge(5, 6);
		dAM.addDirectedEdge(1, 2);
		dAM.addDirectedEdge(1, 3);
		dAM.addDirectedEdge(3, 5);
		System.out.println(dAM);
		TopologicalSort tsortM = new TopologicalSort(dAM);
		tsortM.topologicalSortingUsingDirectedAdjacencyMatrixGraph();

		System.out.println(
				"\n\n<!-- Weighted Graph implementation Single source shortest path, All pairs shortest path, Mimimum spanning tree Algorithms (BFS, Dijkstra's, BellmanFord, FloydWarshall, Kruskal's, Prim's)-->");
		ArrayList<WeightNode> nodeListWeightedNodes = new ArrayList<>();
		nodeListWeightedNodes.add(new WeightNode("A", 0));
		nodeListWeightedNodes.add(new WeightNode("B", 1));
		nodeListWeightedNodes.add(new WeightNode("C", 2));
		nodeListWeightedNodes.add(new WeightNode("D", 3));
		nodeListWeightedNodes.add(new WeightNode("E", 4));
		nodeListWeightedNodes.add(new WeightNode("F", 5));
		nodeListWeightedNodes.add(new WeightNode("G", 6));
		WeightedGraph weightedGraph = new WeightedGraph(nodeListWeightedNodes);
//		weightedGraph.addDirectedWeightedEdge(0, 1, 2);
//		weightedGraph.addDirectedWeightedEdge(0, 2, 5);
//		weightedGraph.addDirectedWeightedEdge(1, 3, 1);
//		weightedGraph.addDirectedWeightedEdge(1, 4, 3);
//		weightedGraph.addDirectedWeightedEdge(3, 4, 4);
//		weightedGraph.addDirectedWeightedEdge(2, 5, 8);
//		weightedGraph.addDirectedWeightedEdge(1, 2, 6);
//		weightedGraph.addDirectedWeightedEdge(5, 6, 7);
//		weightedGraph.addDirectedWeightedEdge(4, 6, 9);
		weightedGraph.addUndirectedWeightedEdge(0, 1, 2);
		weightedGraph.addUndirectedWeightedEdge(0, 2, 5);
		weightedGraph.addUndirectedWeightedEdge(1, 3, 1);
		weightedGraph.addUndirectedWeightedEdge(1, 4, 3);
		weightedGraph.addUndirectedWeightedEdge(3, 4, 4);
		weightedGraph.addUndirectedWeightedEdge(2, 5, 8);
		weightedGraph.addUndirectedWeightedEdge(1, 2, 6);
		weightedGraph.addUndirectedWeightedEdge(5, 6, 7);
		weightedGraph.addUndirectedWeightedEdge(4, 6, 9);
		System.out.println(weightedGraph);
		System.out.println("Dijkstra Algorithm");
		Dijkstra dijkstra = new Dijkstra(weightedGraph);
		dijkstra.dijkstrasAlgo(nodeListWeightedNodes.get(0));
		System.out.println("\nBellman Ford Algorithm");
		BellmanFord bellmanFord = new BellmanFord(weightedGraph);
		bellmanFord.bellmanFordAlgo(nodeListWeightedNodes.get(0));
		System.out.println("\nFloyd Warshall Algorithm");
		FloydWarshall floydWarshall = new FloydWarshall(weightedGraph);
		floydWarshall.floydWarshallAlgo();
		System.out.println("\nKruskal Algorithm");
		Kruskal kruskal = new Kruskal(weightedGraph);
		kruskal.KruskalAlgo();
		System.out.println("\nPrims Algorithm");
		Prims prims = new Prims(weightedGraph);
		prims.PrimsAlgo(nodeListWeightedNodes.get(0));

		System.out.println("\n\n<!-- Disjoint set -->");
		ArrayList<WeightNode> nodeListForDisjointSet = new ArrayList<>();
		nodeListForDisjointSet.add(new WeightNode("A", 0));
		nodeListForDisjointSet.add(new WeightNode("B", 1));
		nodeListForDisjointSet.add(new WeightNode("C", 2));
		nodeListForDisjointSet.add(new WeightNode("D", 3));
		DisjointSet.makeSets(nodeListForDisjointSet);
		WeightNode setNode1 = nodeListForDisjointSet.get(0);
		WeightNode setNode2 = nodeListForDisjointSet.get(1);
		DisjointSet findSet = DisjointSet.findSet(setNode2);
		findSet.printAllNodesOfThisSet();
		DisjointSet unionOutput = DisjointSet.union(setNode1, setNode2);
		unionOutput.printAllNodesOfThisSet();
	}

}
