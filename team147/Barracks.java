package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class Barracks extends BaseRobot {
	public Barracks(RobotController myRC) throws GameActionException {
		super(myRC);
		while (true) {
			messaging.incrementNumBarracksSpawned();
			super.spawnRobot(RobotType.SOLDIER);
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