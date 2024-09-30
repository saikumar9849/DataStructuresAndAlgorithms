package main;

import java.util.ArrayList;
import java.util.List;

//Disjoint sets don’t have any element in common.
public class DisjointSet {

	List<WeightNode> nodeList = new ArrayList<>();

	// Adding new sets to the disjoint set.
	public static void makeSets(List<WeightNode> nodeList) {
		for (WeightNode node : nodeList) {
			DisjointSet set = new DisjointSet();
			set.nodeList.add(node);
			node.set = set;
		}
	}

	// Finding representative of a disjoint set using Find operation.
	public static DisjointSet findSet(WeightNode node) {
		return node.set;
	}

	// Merging disjoint sets to a single disjoint set using Union operation.
	public static DisjointSet union(WeightNode node1, WeightNode node2) {
		if (node1.set.equals(node2.set)) {
			return node1.set;
		}
		DisjointSet set1 = node1.set;
		DisjointSet set2 = node2.set;
		if (set1.nodeList.size() >= set2.nodeList.size()) {
			List<WeightNode> nodeList1 = set2.nodeList;
			for (WeightNode node : nodeList1) {
				node.set = set1;
				set1.nodeList.add(node);
			}
			return set1;
		} else {
			List<WeightNode> nodeList2 = set1.nodeList;
			for (WeightNode node : nodeList2) {
				node.set = set2;
				set2.nodeList.add(node);
			}
			return set2;
		}
	}

	public void printAllNodesOfThisSet() {
		System.out.println("Printing all nodes of the set: ");
		for (WeightNode node : this.nodeList) {
			System.out.print(node.name + " ");
		}
		System.out.println();
	}

}
