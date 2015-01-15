package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Tankfactory extends BaseRobot {
	public Tankfactory(RobotController myRC) throws GameActionException {
		super(myRC);
		messaging.incrementNumTankfactoriesSpawned();
		while (true) {
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