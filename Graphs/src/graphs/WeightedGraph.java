package graphs;

import java.util.ArrayList;
import java.util.List;

import main.UndirectedEdge;
import main.WeightNode;

public class WeightedGraph {

	public List<WeightNode> nodeList;
	public List<UndirectedEdge> undirectedEdgeList;

	public WeightedGraph(List<WeightNode> nodeList) {
		this.nodeList = nodeList;
		this.undirectedEdgeList = new ArrayList<>();
	}

	public void addDirectedWeightedEdge(int i, int j, int distance) {
		WeightNode first = this.nodeList.get(i);
		WeightNode second = this.nodeList.get(j);
		first.neighbors.add(second);
		first.weightMap.put(second, distance);
	}

	public void addUndirectedWeightedEdge(int i, int j, int distance) {
		WeightNode first = this.nodeList.get(i);
		WeightNode second = this.nodeList.get(j);
		first.neighbors.add(second);
		first.weightMap.put(second, distance);
		second.neighbors.add(first);
		second.weightMap.put(first, distance);
		// adding edge to edgeList
		UndirectedEdge edge = new UndirectedEdge(first, second, distance);
		undirectedEdgeList.add(edge);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name);
			List<WeightNode> neighbors = nodeList.get(i).neighbors;
			for (WeightNode j : neighbors) {
				s.append("-> " + j.name);
			}
			s.append("\n");
		}
		return s.toString();
	}

}
