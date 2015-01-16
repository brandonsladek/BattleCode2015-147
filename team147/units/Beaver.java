package team147.units;

import team147.BaseRobot;
import team147.util.statemachines.EconStateMachine;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Beaver extends BaseRobot {
	private EconStateMachine stateMachine;

	public Beaver(RobotController myRC) throws GameActionException {
		super(myRC);
		stateMachine = new EconStateMachine(this);
		defaultSpawnSetup();

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
			case ECON:
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

		// while (true) {
		//
		// switch (rand.nextInt(6)) {
		// case 0:
		// case 1:
		// case 2:
		// case 3:
		// mine();
		// safeMoveAround();
		// break;
		// case 4:
		// case 5:
		// build(getNeededBuilding());
		// default:
		// mine();
		// safeMoveAround();
		// break;
		// }
		//
		// // attackEnemyZero();
		// attackLeastHealthyEnemy();
		// transferSupply();
		// rc.yield();
		// }
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
	public void defaultEconAction() throws GameActionException {
		build(getNeededBuilding());
		transferSupply();
	}

	@Override
	public void defaultExploreAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultTurnSetup() throws GameActionException {
		messaging.setNumBeaversSpawned(1);
	}

	@Override
	public void defaultSpawnSetup() throws GameActionException {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultTurnEndAction() throws GameActionException {
		rc.yield();
	}
}