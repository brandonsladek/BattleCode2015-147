package team147.buildings;

import team147.BaseRobot;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class Hq extends BaseRobot {
	public Hq(RobotController myRC) throws GameActionException {
		super(myRC);
		int numBeaversSpawned = 0;
		messaging.setRallyPoint(getDefaultRallyPoint(enemyHQLoc));
		while (true) {
			attackLeastHealthyEnemy();
			if (numBeaversSpawned++ < 5 || rand.nextDouble() < .01)
				spawnRobot(RobotType.BEAVER);
			transferSupply();
			rc.yield();
		}
	}

	@Override
	public void defaultPanicAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultAttackAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultDefendAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultEconAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defaultExploreAction() {
		// TODO Auto-generated method stub
		
	}
}