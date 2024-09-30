package single_source_shortest_path;

import java.util.List;
import java.util.PriorityQueue;

import graphs.WeightedGraph;
import main.WeightNode;

//First take all other distance as infinite except source vertex.
//then go on from source to neighbor vertex's and find the shortest distance from score to neighbors.
//Now take the vertex with shortest distance and mark it as calculated then again calculate the shortest path and so on.
//Dijkstra's Algorithm doesn't work for Negative weights.
//It can be used for both directed, undirected and weighted, unweighted
public class Dijkstra {

	private WeightedGraph weighedGraph;

	public Dijkstra(WeightedGraph graph) {
		this.weighedGraph = graph;
	}

	// TC -> O(V^2)
	// SC -> O(V)
	public void dijkstrasAlgo(WeightNode node) {
		List<WeightNode> nodeList = this.weighedGraph.nodeList;
		PriorityQueue<WeightNode> pq = new PriorityQueue<>();
		node.distance = 0;
		pq.addAll(nodeList);
		while (!pq.isEmpty()) {
			WeightNode currNode = pq.poll();
			for (WeightNode tmpNode : currNode.neighbors) {
				if (pq.contains(tmpNode)) {
					if (tmpNode.distance > currNode.distance + currNode.weightMap.get(tmpNode)) {
						tmpNode.distance = currNode.distance + currNode.weightMap.get(tmpNode);
						tmpNode.parent = currNode;
						pq.remove(tmpNode);
						pq.add(tmpNode);
					}
				}
			}
		}

		for (WeightNode nodes : nodeList) {
			System.out.print("Node " + nodes + " distance: " + nodes.distance + " path: ");
			pathPrint(nodes);
			System.out.println();
		}
	}

	private void pathPrint(WeightNode node) {
		if (node.parent != null) {
			pathPrint(node.parent);
			System.out.print(node.name + " ");
		}
	}

}
