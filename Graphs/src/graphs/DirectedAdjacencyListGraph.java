package graphs;

import java.util.List;

import main.GraphNodeList;

public class DirectedAdjacencyListGraph {

	public List<GraphNodeList> nodeList;

	public DirectedAdjacencyListGraph(List<GraphNodeList> nodeList) {
		this.nodeList = nodeList;
	}

	public void addDirectedEdge(int i, int j) {
		GraphNodeList first = nodeList.get(i);
		GraphNodeList second = nodeList.get(j);
		first.neighbors.add(second);
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
