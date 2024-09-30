package minimum_spanning_tree;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import graphs.WeightedGraph;
import main.DisjointSet;
import main.UndirectedEdge;
import main.WeightNode;

//Minimum Spanning Tree (MST)
//A spanning tree is a subset of the edges of the graph that forms a tree (acyclic) where every node of the graph is a part of the tree.
//A minimum spanning tree (MST) is defined as a spanning tree that has the minimum weight among all the possible spanning trees
//Properties of a Spanning Tree:
//1.The number of vertices (V) in the graph and the spanning tree is the same.
//2.There is a fixed number of edges in the spanning tree which is equal to one less than the total number of vertices ( E = V-1 ).
//3.The spanning tree should not be disconnected and should be acyclic.
//Algorithms to find MST: Kruskal's and Prim's

//Kruskal’s Algorithm:
//In Kruskal’s algorithm, sort all edges of the given graph in increasing order. Then it keeps on adding new edges and nodes in the MST if the newly added edge does not form a cycle.
//It is a greedy Algorithm
//Steps for finding MST using Kruskal’s algorithm:
//1.Sort all the edges in non-decreasing order of their weight.
//2.Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If the cycle is not formed, include this edge. Else, discard it.
//3.Repeat step#2 until there are (V-1) edges in the spanning tree.
public class Kruskal {
	private WeightedGraph weightedGraph;

	public Kruskal(WeightedGraph weightedGraph) {
		this.weightedGraph = weightedGraph;
	}

	// TC -> O(E * logE) or O(E * logV)
	// SC -> O(V + E)
	public void KruskalAlgo() {
		List<WeightNode> nodeList = this.weightedGraph.nodeList;
		DisjointSet.makeSets(nodeList);
		List<UndirectedEdge> edgeList = this.weightedGraph.undirectedEdgeList;
//		Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
//			@Override
//			public int compare(UndirectedEdge o1, UndirectedEdge o2) {
//				return o1.weight-o2.weight;
//			}
//		};
//		Collections.sort(edgeList, comparator);

		Collections.sort(edgeList, (Comparator<UndirectedEdge>) (UndirectedEdge o1, UndirectedEdge o2) -> {
			return o1.weight - o2.weight;
		});

		int cost = 0;
		for (UndirectedEdge edge : edgeList) {
			if (!DisjointSet.findSet(edge.firstNode).equals(DisjointSet.findSet(edge.secondNode))) {
				DisjointSet.union(edge.firstNode, edge.secondNode);
				cost += edge.weight;
				System.out.println("Taken Edge: " + edge);
			}
		}
		System.out.println("Total cost:" + cost);
	}
}
