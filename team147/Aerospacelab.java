package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class Aerospacelab extends BaseRobot {
	public Aerospacelab(RobotController myRC) throws GameActionException {
		super(myRC);
		messaging.incrementNumAerospacelabsSpawned();
		while (true) {
			super.spawnRobot(RobotType.LAUNCHER);
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