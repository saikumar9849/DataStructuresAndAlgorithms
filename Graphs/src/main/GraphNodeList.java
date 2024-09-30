package main;

import java.util.ArrayList;
import java.util.List;

public class GraphNodeList {

	public String name;
	public int index;
	public List<GraphNodeList> neighbors;
	public boolean isVisited;
	public GraphNodeList parent;

	public GraphNodeList(String name, int index) {
		this.name = name;
		this.index = index;
		this.neighbors = new ArrayList<>();
		this.isVisited = false;
	}

}
