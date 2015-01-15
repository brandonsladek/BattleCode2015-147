package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class Hq extends BaseRobot {
	public Hq(RobotController myRC) throws GameActionException {
		super(myRC);
		int numBeaversSpawned = 0;
		getAndSetRallyPoint(getEnemyHQLoc());
		while (true) {
			attackLeastHealthyEnemy();
			if (numBeaversSpawned++ < 10 || rand.nextDouble() < .01)
				spawnRobot(RobotType.BEAVER);
			transferSupply();
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