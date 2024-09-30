package all_pairs_shortest_path;

import java.util.Arrays;
import java.util.List;

import graphs.WeightedGraph;
import main.WeightNode;

//The Floyd Warshall Algorithm is an all pair shortest path algorithm. This algorithm works for both the directed and undirected weighted graphs. But, it does not work for the graphs with negative cycles (where the sum of the edges in a cycle is negative). It follows Dynamic Programming approach to check every possible path going via every possible node in order to calculate shortest distance between every pair of nodes.

//Floyd Warshall Algorithm Steps:
//Initialize the solution matrix with all diagonal  values to zero and neighbor elements as the weights given accordingly the edges and if their is no edge b/w the node take max value.
//Then update the solution matrix by considering all vertices as an intermediate vertex. 
//The idea is to pick all vertices one by one and updates all shortest paths which include the picked vertex as an intermediate vertex in the shortest path. 
//When we pick vertex number k as an intermediate vertex, we already have considered vertices {0, 1, 2, .. k-1} as intermediate vertices. 
//For every pair (i, j) of the source and destination vertices respectively, there are two possible cases. 
//k is not an intermediate vertex in shortest path from i to j. We keep the value of dist[i][j] as it is. 
//k is an intermediate vertex in shortest path from i to j. We update the value of dist[i][j] as dist[i][k] + dist[k][j], if dist[i][j] > dist[i][k] + dist[k][j]
public class FloydWarshall {
	private WeightedGraph weightedGraph;

	public FloydWarshall(WeightedGraph weightedGraph) {
		this.weightedGraph = weightedGraph;
	}

	public void floydWarshallAlgo() {
		List<WeightNode> nodeList = this.weightedGraph.nodeList;
		int size = nodeList.size();
		int[][] v = new int[size][size];

		// initialization of matrix
		for (int i = 0; i < size; i++) {
			Arrays.fill(v[i], Integer.MAX_VALUE / 10);
			v[i][i] = 0;
		}
		for (WeightNode node : nodeList) {
			for (WeightNode neighbor : node.neighbors) {
				v[node.index][neighbor.index] = node.weightMap.get(neighbor);
			}
		}

		// Floyd Warshall Algorithm
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					v[i][j] = Math.min(v[i][j], v[i][k] + v[k][j]);
				}
			}
		}

		// printing the matrix
		System.out.print("  ");
		for (int i = 0; i < size; i++) {
			System.out.print(nodeList.get(i).name + " ");
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(nodeList.get(i).name + " ");
			for (int j = 0; j < size; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}

}
