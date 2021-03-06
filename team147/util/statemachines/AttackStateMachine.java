package team147.util.statemachines;

import team147.BaseRobot;
import team147.util.StateMachine;
import battlecode.common.Clock;
import battlecode.common.GameActionException;
import battlecode.common.RobotInfo;
import battlecode.common.RobotType;

public class AttackStateMachine extends StateMachine {
	public State currentState;

	public AttackStateMachine(BaseRobot br) {
		super(br);
		updateState();
	}

	// Information Methods (methods that get data we can use to make state
	// decisions)
	private double getEnemyAllyDifferential() { // Determines the enemy:ally
												// ratio within the sensor
												// radius squared
		RobotInfo enemies[] = br.rc.senseNearbyRobots(br.sensorRadiusSquared,
				br.enemyTeam);
		RobotInfo allies[] = br.rc.senseNearbyRobots(br.sensorRadiusSquared,
				br.myTeam);
		int enemyPower = 0;
		int allyPower = 1; // just so we never divide by 0

		RobotType type;
		for (RobotInfo r : enemies) {
			type = r.type;
			switch (type) {
			case SOLDIER:
				enemyPower += 8;
				break;
			case BASHER:
				enemyPower += 4;
				break;
			case DRONE:
				enemyPower += 12;
				break;
			case COMMANDER:
				enemyPower += 15;
				break;
			case TANK:
				enemyPower += 25;
				break;
			case LAUNCHER:
				enemyPower += 15;
				break;
			case MISSILE:
				enemyPower += 20;
				break;
			case BEAVER:
				enemyPower += 4;
				break;
			case MINER:
				enemyPower += 3;
				break;
			default:
				break;
			}
		}

		for (RobotInfo r : allies) {
			type = r.type;
			switch (type) {
			case SOLDIER:
				allyPower += 8;
				break;
			case BASHER:
				allyPower += 4;
				break;
			case DRONE:
				allyPower += 12;
				break;
			case COMMANDER:
				allyPower += 15;
				break;
			case TANK:
				allyPower += 25;
				break;
			case LAUNCHER:
				allyPower += 15;
				break;
			case MISSILE:
				allyPower += 20;
				break;
			case BEAVER:
				allyPower += 4;
				break;
			case MINER:
				allyPower += 3;
				break;
			default:
				break;
			}
		}
		switch (br.rc.getType()) {
		case SOLDIER:
			allyPower += 8;
			break;
		case BASHER:
			allyPower += 4;
			break;
		case DRONE:
			allyPower += 12;
			break;
		case COMMANDER:
			allyPower += 15;
			break;
		case TANK:
			allyPower += 25;
			break;
		case LAUNCHER:
			allyPower += 15;
			break;
		case MISSILE:
			allyPower += 20;
			break;
		case BEAVER:
			allyPower += 4;
			break;
		case MINER:
			allyPower += 3;
			break;
		default:
			break;
		}
		// if the ratio is greater than 100 BAD, less than 100 GOOD
		double ratio = 100 * (enemyPower / allyPower);
		return ratio;
	} // end of getEnemyAllyDifferential method

	// Methods that might already exist:
	// getEnemyTowerHealth()
	// getAllyTowerHealth()
	// getHQHealth()
	// getEnemyHQHealth()

	public void updateState() {
		double diff = getEnemyAllyDifferential();
		int hqThreat = 0;
		try {
			hqThreat = br.rc.readBroadcast(1000);
		} catch (GameActionException e) {
			e.printStackTrace();
		}
		int distanceFromOurHQ = br.rc.getLocation().distanceSquaredTo(
				br.rc.senseHQLocation());
		int distanceFromEnemyHQ = br.rc.getLocation().distanceSquaredTo(
				br.rc.senseEnemyHQLocation());
		int roundNum = Clock.getRoundNum();
		if (diff < 75 && hqThreat < 125) {
			currentState = State.ATTACK;
			return;
		}
		if (diff > 125) {
			currentState = State.PANIC;
			return;
		}
		if (hqThreat > 150 && (distanceFromOurHQ < distanceFromEnemyHQ)) {
			currentState = State.DEFEND;
			return;
		}
		if (roundNum > 1700 && roundNum < 1800) {
			currentState = State.RALLY;
			return;
		}
		if (roundNum > 1800) {
			currentState = State.SIEGE;
			return;
		}
		currentState = State.EXPLORE;

	} // end of updateState method

	public void sendStateMessages() {
		// TODO Auto-generated method stub
	}

} // end of AttackStateMachine class
