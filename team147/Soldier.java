package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Soldier extends BaseRobot {
	public Soldier(RobotController myRC) throws GameActionException {
		super(myRC);
		while (true) {
			// attackEnemyZero();
			attackLeastHealthyEnemy();
			safeMoveTowardsHQ();
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