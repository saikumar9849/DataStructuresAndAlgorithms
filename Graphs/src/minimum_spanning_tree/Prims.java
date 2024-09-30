package minimum_spanning_tree;

import java.util.PriorityQueue;

import graphs.WeightedGraph;
import main.WeightNode;

//Prim’s Algorithm:
//This algorithm always starts with a single node and moves through several adjacent nodes, in order to explore all of the connected edges along the way.
//It is a greedy Algorithm
//Steps for finding MST using Prim’s algorithm:
//1.Take any vertex as source set it's weight to zero and all other vertice's weight to infinity
//2.For every adjacent vertice's if the current weight is more than current edge then we set it to current edge.
//3.Then we mark current vertex as visited
//4.Repeat the above steps for all vertice's in increasing order of weight.

//This algo has some similarities with the Dijkstra Algo(Similar implementation).
public class Prims {
	private WeightedGraph weightedGraph;

	public Prims(WeightedGraph weightedGraph) {
		this.weightedGraph = weightedGraph;
	}

	// TC -> O(V^2)
	// SC -> O(V)
	public void PrimsAlgo(WeightNode node) {
		for (WeightNode weightedNode : this.weightedGraph.nodeList) {
			weightedNode.distance = Integer.MAX_VALUE;
		}
		node.distance = 0;
		PriorityQueue<WeightNode> pq = new PriorityQueue<>();
		pq.addAll(this.weightedGraph.nodeList);
		while (!pq.isEmpty()) {
			WeightNode currNode = pq.poll();
			for (WeightNode neighbor : currNode.neighbors) {
				if (pq.contains(neighbor)) {
					if (neighbor.distance > currNode.weightMap.get(neighbor)) {
						neighbor.distance = currNode.weightMap.get(neighbor);
						neighbor.parent = currNode;
						pq.remove(neighbor);
						pq.add(neighbor);
					}
				}
			}
		}
		int cost = 0;

		for (WeightNode nodes : this.weightedGraph.nodeList) {
			System.out.println("Node " + nodes + ", key " + nodes.distance + "parent: " + nodes.parent);
			cost += nodes.distance;
		}
		System.out.println("Total cost:" + cost);
	}

}
