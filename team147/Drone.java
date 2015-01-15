package team147;

import battlecode.common.Clock;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Drone extends BaseRobot {
	public Drone(RobotController myRC) throws GameActionException {
		super(myRC);
		while (true) {
			attackLeastHealthyEnemy();
			if (Clock.getRoundNum() < 1500)
				followEconUnit();
			else if (Clock.getRoundNum() < 1600)
				safeMoveTowardDestination(messaging.getRallyPoint());
			else if (Clock.getRoundNum() < 1750)
				safeMoveTowardDestination(getClosestTowerLocation());
			else
				moveTowardDestination(getClosestTowerLocation());
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