package graphs;

import java.util.ArrayList;
import java.util.List;

import main.GraphNodeList;

public class UndirectedAdjacencyListGraph {

	public List<GraphNodeList> nodeList = new ArrayList<>();

	public UndirectedAdjacencyListGraph(List<GraphNodeList> nodeList) {
		this.nodeList = nodeList;
	}

	public void addUndirectedEdge(int i, int j) {
		GraphNodeList first = nodeList.get(i);
		GraphNodeList second = nodeList.get(j);
		first.neighbors.add(second);
		second.neighbors.add(first);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name);
			List<GraphNodeList> neighbors = nodeList.get(i).neighbors;
			for (GraphNodeList j : neighbors) {
				s.append("-> " + j.name);
			}
			s.append("\n");
		}
		return s.toString();
	}

}
