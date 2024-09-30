package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightNode implements Comparable<WeightNode> {

	public String name;
	public int index;
	public List<WeightNode> neighbors;
	public Map<WeightNode, Integer> weightMap;
	public boolean isVisited;
	public int distance;
	public WeightNode parent;
	public DisjointSet set;

	public WeightNode(String name, int index) {
		this.index = index;
		this.name = name;
		this.neighbors = new ArrayList<>();
		this.isVisited = false;
		this.distance = Integer.MAX_VALUE;
		this.weightMap = new HashMap<>();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(WeightNode o) {
		return this.distance - o.distance;
	}

}
