package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Beaver extends BaseRobot {
	public Beaver(RobotController myRC) throws GameActionException {
		super(myRC);
		while (true) {

			switch (rand.nextInt(6)) {
			case 0:
			case 1:
			case 2:
			case 3:
				mine();
				safeMoveAround();
				break;
			case 4:
			case 5:
				build(getNeededBuilding());
			default:
				mine();
				safeMoveAround();
				break;
			}

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