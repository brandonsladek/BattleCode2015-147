package team147.buildings;

import team147.BaseRobot;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class Barracks extends BaseRobot {
	public Barracks(RobotController myRC) throws GameActionException {
		super(myRC);
		while (true) {
			messaging.incrementNumBarracksSpawned();
			super.spawnRobot(RobotType.SOLDIER);
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