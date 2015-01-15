package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Miner extends BaseRobot {
	public Miner(RobotController myRC) throws GameActionException {
		super(myRC);
		while (true) {
			mine();
			safeMoveAround();
			// attackEnemyZero();
			attackLeastHealthyEnemy();
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