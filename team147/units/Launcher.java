package team147.units;

import team147.BaseRobot;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Launcher extends BaseRobot {
	public Launcher(RobotController myRC) throws GameActionException {
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