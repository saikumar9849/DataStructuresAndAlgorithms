package greedy_algorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Problem Statement:
//Given a set of items, each with a weight and a value.
//Determine the number of each item to include in a collection so that the total weight is less than or equal to agiven limit and the total value is as large as possible


//Example:
//weights[] = {20,30,10}
//profits[] = {100,120,60}
//capacity = 50
//Explanation: Take 60 + 100 + (120*(2/3)) = 240
//Output = 240

//Algorithm:
//Calculate the density or ratio for each item
//Sort items based on this ratio
//Take items with the highest ratio sequentially until weight allows
//Add the next item as much (fractional) as we can
public class FractionalKnapsack {

	// TC -> O(NlogN)
	// SC -> O(1)
	public static double fractionalKnapsack(List<KnapSackItem> items, int capacity) {
		Comparator<KnapSackItem> ratioComparator = (o1, o2) -> {
			if (o2.getRatio() > o1.getRatio()) {
				return 1;
			} else {
				return -1;
			}
		};
		Collections.sort(items, ratioComparator);
		double totalValue = 0;
		for (KnapSackItem item : items) {
			if (capacity - item.getWeight() >= 0) {
				totalValue += item.getValue();
				capacity -= item.getWeight();
				System.out.println("Taken: " + item);
			} else {
				double fractionalValue = capacity * item.getRatio();
				capacity = 0;
				totalValue += fractionalValue;
				System.out.println("Taken: Fractional item index= " + item.getIndex() + ", Obtained value= "
						+ fractionalValue + ", usedWeight= " + capacity + ", ratio=" + item.getRatio());
			}
			if (capacity == 0)
				break;
		}
		return totalValue;
	}
}
