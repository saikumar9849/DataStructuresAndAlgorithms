package single_source_shortest_path;

import java.util.List;

import graphs.WeightedGraph;
import main.WeightNode;

//Bellman-Ford is based on “Principle of Relaxation“.
//In this Algo for the graph having N vertices, all the edges should be relaxed N-1 times to compute the single source shortest path.
//relaxation means - if(d[v]>d[u]+c(u,v)) then d[v] = d[u]+cd(u,v)
//we iterate N-1 times because, In the worst-case scenario, a shortest path between two vertices can have at most N-1 edges, where N is the number of vertices.
//BellmanFord algorithm useful for negatives weights but it will not work if their is a negative cycle present in the graph. But it will detect the negative cycle in nth iteration.
public class BellmanFord {
	private WeightedGraph weightedGraph;

	public BellmanFord(WeightedGraph weightedGraph) {
		this.weightedGraph = weightedGraph;
	}

	// TC -> O(VE)
	// SC -> O(V)
	public void bellmanFordAlgo(WeightNode node) {
		List<WeightNode> nodeList = this.weightedGraph.nodeList;
		// Iterating n-1 times all the edges
		for (int i = 1; i < nodeList.size(); i++) {
			for (WeightNode currentNode : nodeList) {
				for (WeightNode neighbor : currentNode.neighbors) {
					// Relaxation of edges
					if (neighbor.distance > (currentNode.distance + currentNode.weightMap.get(neighbor))) {
						neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
						neighbor.parent = currentNode;
					}
				}
			}
		}
		System.out.println("Checking for the Negative cycle...");
		// to check whether the negative cycle(eg:- 7,7,-15) is present or not we relax
		// all the edges one more time if their is any change in distance then we can
		// conclude that the negative cycle is present.
		for (WeightNode currentNode : nodeList) {
			for (WeightNode neighbor : currentNode.neighbors) {
				if (neighbor.distance > (currentNode.distance + currentNode.weightMap.get(neighbor))) {
					System.out.println("Negative cycle found at: ");
					System.out.print("vertex name " + neighbor.name);
					System.out.print(" with old cost: " + neighbor.distance);
					System.out
							.print(" and new cost is: " + (currentNode.distance + currentNode.weightMap.get(neighbor)));
					return;
				}
			}
		}

		System.out.println("Negative cycle not found");
		for (WeightNode currNode : nodeList) {
			System.out.print("Node " + currNode.name + " distance " + currNode.distance + " Path: ");
			pathPrint(currNode);
			System.out.println();
		}

	}

	private void pathPrint(WeightNode node) {
		if (node.parent == null) {
			return;
		}
		pathPrint(node.parent);
		System.out.print(node.name + " ");
	}
}
