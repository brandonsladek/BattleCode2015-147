package team147.buildings;

import team147.BaseRobot;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class Minerfactory extends BaseRobot {
	public Minerfactory(RobotController myRC) throws GameActionException {
		super(myRC);
		messaging.incrementNumMinerfactoriesSpawned();
		int numMinersSpawned = 0;
		while (true) {
			if (numMinersSpawned++ < 10 || rand.nextDouble() < .01)
				spawnRobot(RobotType.MINER);
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