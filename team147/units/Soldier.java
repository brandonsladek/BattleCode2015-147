package team147.units;

import team147.BaseRobot;
import team147.util.statemachines.AttackStateMachine;
import team147.util.statemachines.EconStateMachine;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Soldier extends BaseRobot {
	private AttackStateMachine stateMachine;
	
	public Soldier(RobotController myRC) throws GameActionException {
		super(myRC);
		stateMachine = new AttackStateMachine(this);
		
		
		while (true) {
			stateMachine.updateState();
			defaultTurnSetup();
			switch (stateMachine.currentState) {
			case ATTACK:
				defaultAttackAction();
				break;
			case DEFEND:
				defaultDefendAction();
				break;
			case SIEGE:
				defaultEconAction();
				break;
			case EXPLORE:
				defaultExploreAction();
				break;
			case PANIC:
				defaultPanicAction();
				break;
			default:
				break;
			}
			defaultTurnEndAction();
			stateMachine.sendStateMessages();
		}
	}

	@Override
	public void defaultPanicAction() throws GameActionException {
		moveTowardDestination(rc.senseHQLocation());
	}

	@Override
	public void defaultAttackAction() throws GameActionException {
		attackLeastHealthyEnemy();
	}

	@Override
	public void defaultDefendAction() throws GameActionException {
		attackLeastHealthyEnemy();
	}

	@Override
	public void defaultEconAction() throws GameActionException {
		moveAround();	
	}

	@Override
	public void defaultExploreAction() {
		
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