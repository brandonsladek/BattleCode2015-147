package team147.units;

import team147.BaseRobot;
import team147.util.statemachines.AttackStateMachine;
import battlecode.common.Clock;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

public class Soldier extends BaseRobot {
	private AttackStateMachine stateMachine;

	public Soldier(RobotController myRC) throws GameActionException {
		super(myRC);
		stateMachine = new AttackStateMachine(this);

		while (true) {
			stateMachine.updateState();
			defaultTurnSetup();
//			switch (stateMachine.currentState) {
//			case ATTACK:
//				defaultAttackAction();
//				break;
//			case DEFEND:
//				defaultDefendAction();
//				break;
//			case SIEGE:
//				safeMoveTowardDestination(messaging.getRallyPoint());
//				break;
//			case EXPLORE:
//				defaultExploreAction();
//				break;
//			case PANIC:
//				defaultPanicAction();
//				break;
//			default:
//				break;
//          }
			
			attackLeastHealthyEnemy();
			if(rc.getID()%5 != 0 && Clock.getRoundNum() < 1500)
				followSoldierOrTankOrDroneUnit();
			if(Clock.getRoundNum() < 1500)
				safeMoveAround();
			else if (Clock.getRoundNum() < 1700)
				safeMoveTowardDestination(getClosestTowerLocation());
			else
				moveTowardDestination(getClosestTowerLocation());
			transferSupply();
			
			defaultTurnEndAction();
			stateMachine.sendStateMessages();
			rc.yield();
		}
	}

	@Override
	public void defaultPanicAction() throws GameActionException {
		moveTowardDestination(rc.senseHQLocation());
	}

	@Override
	public void defaultAttackAction() throws GameActionException {
		attackLeastHealthyEnemy();
		followSoldierOrTankOrDroneUnit();
		harrass();
	}

	@Override
	public void defaultDefendAction() throws GameActionException {
		attackLeastHealthyEnemy();
		safeMoveTowardDestination(rc.senseHQLocation());
	}

	@Override
	public void defaultEconAction() throws GameActionException {
		transferSupply();
	}

	@Override
	public void defaultExploreAction() throws GameActionException {
		moveAround();
		transferSupply();
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
		rc.yield();
	}
	
	public MapLocation getSoldierRallyPoint() {
		int enemyX = super.enemyHQLoc.x;
		int enemyY = super.enemyHQLoc.y;
		int ourX = super.hQLoc.x;
		int ourY = super.hQLoc.y;
		int rallyX = (enemyX + ourX)/4;
		int rallyY = ((enemyY + ourY)/4)*3;
		MapLocation rallyPoint = new MapLocation(rallyX, rallyY);
		return rallyPoint;
	}
}