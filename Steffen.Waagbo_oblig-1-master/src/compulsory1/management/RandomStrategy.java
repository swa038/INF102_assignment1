package compulsory1.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStrategy implements IStrategy {

	List<Robot> robotList = new ArrayList<>();
	List<Job> jobList = new ArrayList<>();
	List<Job> jobList2 = new ArrayList<>();
	Random rand = new Random();

	@Override
	//Time complexity: O(n)
	public void registerRobots(List<Robot> robots) {
			robotList.addAll(robots);
	}

	@Override
	//Time complexity: O(M) (But this is highly unlikely)
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
			int robotsSent = 0;
			while (robotsSent != job.robotsNeeded) {
				int random = rand.nextInt(robotList.size());
				if (!robotList.get(random).isBusy()) {
					robotList.get(random).move(job);
					robotsSent++;
				}
			}
		} else {
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
}



