package greedy_algorithms;

public class KnapSackItem {
	private int index;
	private int weight;
	private int value;
	private double ratio;

	public KnapSackItem(int index, int weight, int value) {
		super();
		this.index = index;
		this.weight = weight;
		this.value = value;
		this.ratio = (value * 1.0) / weight;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "KnapSackItem [index=" + index + ", weight=" + weight + ", value=" + value + ", ratio=" + ratio + "]";
	}

}
