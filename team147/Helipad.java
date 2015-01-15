package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class Helipad extends BaseRobot {
	public Helipad(RobotController myRC) throws GameActionException {
		super(myRC);
		messaging.incrementNumHelipadsSpawned();
		while (true) {
			spawnRobot(RobotType.DRONE);
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