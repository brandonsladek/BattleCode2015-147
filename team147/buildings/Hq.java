package team147.buildings;

import team147.BaseRobot;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.RobotType;

public class Hq extends BaseRobot {
	int numBeaversAlive;

	public Hq(RobotController myRC) throws GameActionException {
		super(myRC);
		defaultSpawnSetup();
		while (true) {
			defaultTurnSetup();
			attackLeastHealthyEnemy();
			transferSupply();
			defaultTurnEndAction();
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

	}

	@Override
	public void defaultExploreAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultTurnSetup() throws GameActionException {
		numBeaversAlive = messaging.getNumBeaversSpawned();
		messaging.setNumBeaversSpawned(0);
		if (numBeaversAlive == 0)
			spawnRobot(RobotType.BEAVER);
	}

	@Override
	public void defaultSpawnSetup() throws GameActionException {
		messaging.setRallyPoint(getDefaultRallyPoint(enemyHQLoc));
	}

	@Override
	public void defaultTurnEndAction() throws GameActionException {
		// TODO Auto-generated method stub
		rc.yield();
	}
}