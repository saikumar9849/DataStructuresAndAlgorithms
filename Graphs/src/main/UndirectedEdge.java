package main;

public class UndirectedEdge {

	public WeightNode firstNode;
	public WeightNode secondNode;
	public int weight;

	public UndirectedEdge(WeightNode firstNode, WeightNode secondNode, int weight) {
		this.firstNode = firstNode;
		this.secondNode = secondNode;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "UndirectedEdge [firstNode=" + firstNode + ", secondNode=" + secondNode + ", weight=" + weight + "]";
	}

}
