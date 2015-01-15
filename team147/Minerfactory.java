package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class Minerfactory extends BaseRobot {
	public Minerfactory(RobotController myRC) throws GameActionException {
		super(myRC);
		messaging.incrementNumMinerfactoriesSpawned();
		int numMinersSpawned = 0;
		while (true) {
			if (numMinersSpawned++ < 10 || rand.nextDouble() < .01)
				spawnRobot(RobotType.MINER);
			rc.yield();
		}
	}

	@Override
	public void defaultMove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultAttack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendSpawnMessages() {
		// TODO Auto-generated method stub

	}
}