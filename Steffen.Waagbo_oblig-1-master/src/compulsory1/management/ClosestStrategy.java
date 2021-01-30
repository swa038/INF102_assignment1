package compulsory1.management;

import java.util.ArrayList;
import java.util.List;

public class ClosestStrategy implements IStrategy{

	List<Robot> robotList = new ArrayList<>();
	List<Job> jobList = new ArrayList<>();
	List<Job> jobList2 = new ArrayList<>();

	@Override
	//Runtime: O(n)
	public void registerRobots(List<Robot> robots) {
		robotList.addAll(robots);
	}

	@Override
	//Runtime: O(n^2)
	public void registerJob(Job job) {
		int freeRobots = 0;

		if (!jobList.contains(job))
			jobList.add(job);

		for (Robot robot : robotList) {
			if (!robot.isBusy()) {
				freeRobots++;
			}
		}

		if (freeRobots >= job.robotsNeeded) {
			sortByDistance(job);
			int robotsSent = 0;
			for (int i = 0; robotsSent < job.robotsNeeded; i++) {
				if (!robotList.get(i).isBusy()) {
					robotList.get(i).move(job);
					robotsSent++;
				}
			}
		}
		else {
			jobList2.add(job);
		}
		jobList.remove(job);
	}

	@Override
	//Runtime: O(n)
	public void jobFulfilled(Job job) {
		if (!jobList2.isEmpty()) {
			registerJob(jobList2.get(0));
			jobList2.remove(0);
		}
	}

	//Runtime: O(n^2)
	public void sortByDistance(Job job) {
		Robot temp;

		for (int i=1; i < robotList.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (robotList.get(j).getLocation().dist(job.location) < robotList.get(j-1).getLocation().dist(job.location)) {
					temp = robotList.get(j);
					robotList.set(j, robotList.get(j-1));
					robotList.set(j-1, temp);
				}
			}
		}
	}
}
