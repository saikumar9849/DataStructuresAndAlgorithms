package greedy_algorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Problem Statement:
//Given N number of activities with their start and end times.
//we need to select the maximum number of activities that can be performed by a single person assuming that a person assuming that a person can only work on a single at a time.

//Example:
//Activities[] = {A1, A2, A3, A4, A5, A6}
//weights[] = {0, 3, 1, 5, 5, 8}
//profits[] = {6, 4, 2, 8, 7, 9}
//Explanation: Take A3, A2, A5, A6
//Output = 4

//Algorithm:
//sort activities based on finish time.
//select first activity from sorted array and print it
//for all remaining activities: If the start time of this activity is greater or equal to the finish time of previously selected activity then select this activity and print it.
public class ActivitySelection {

	// TC -> O(NlogN)
	// SC -> O(1)
	public static void activitySelection(List<Activity> activities) {
		Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				return o1.getFinishTime() - o2.getFinishTime();
			}
		};
		Collections.sort(activities, finishTimeComparator);
		Activity previousActivity = activities.get(0);
		System.out.println(previousActivity);
		for (int i = 1; i < activities.size(); i++) {
			if (previousActivity.getFinishTime() < activities.get(i).getStartTime()) {
				System.out.println(activities.get(i));
				previousActivity = activities.get(i);
			}
		}
	}
}
