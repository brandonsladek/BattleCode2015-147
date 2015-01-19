package team147.units;

import team147.BaseRobot;
import battlecode.common.Clock;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Tank extends BaseRobot {
	public Tank(RobotController myRC) throws GameActionException {
		super(myRC);
		while (true) {
			attackLeastHealthyEnemy();
			if (Clock.getRoundNum() < 1700)
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

	@Override
	public void defaultTurnSetup() throws GameActionException {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultSpawnSetup() throws GameActionException {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultTurnEndAction() throws GameActionException {
		// TODO Auto-generated method stub

	}
}