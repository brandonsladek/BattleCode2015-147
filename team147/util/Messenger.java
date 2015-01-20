package team147.util;

import battlecode.common.Clock;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.RobotType;

public class Messenger {

	private RobotController rc;

	public Messenger(RobotController rc) {
		this.rc = rc;
	}

	private static enum ChannelNumber {
		// Enemy Intelligence Data:
		NUMBER_ENEMY_BEAVERS_SPOTTED(0),

		NUMBER_ENEMY_BARRACKS_SPOTTED(3), NUMBER_ENEMY_TANKFACTORIES_SPOTTED(4),

		NUM_BARRACKS_SPAWNED(10), NUM_TANKFACTORIES_SPAWNED(11),

		NUM_HELIPADS_SPAWNED(12), NUM_AEROSPACELABS_SPAWNED(13),

		NUM_TECHNOLOGYINSTITUTES_SPAWNED(14), NUM_TRAININGFIELDS_SPAWNED(15),

		NUM_HANDWASHSTATIONS_SPAWNED(16),

		NUM_MINERFACTORIES_SPAWNED(17),

		NUM_SUPPLYDEPOTS_SPAWNED(18),

		NUM_BEAVERS_SPAWNED(19),
		
		NUM_TANKS_SPAWNED(20),
		
		NUM_MINERS_SPAWNED(21),

		// Example of a Map Location
		RALLYPOINT_1X(5), RALLYPOINT_1Y(6);

		// ADD Channels AS NEEDED

		private final int channelNum;

		ChannelNumber(int channelNum) {
			this.channelNum = channelNum;
		}

		public int getValue() {
			return channelNum;
		}

	}

	// broadcast HQ pressure to channel 1000
	public void broadCastHQPressure() throws GameActionException{
		RobotInfo enemies[] = rc.senseNearbyRobots(rc.getType().sensorRadiusSquared, rc.getTeam().opponent());
		RobotInfo allies[] = rc.senseNearbyRobots(rc.getType().sensorRadiusSquared, rc.getTeam());

		int enemyPower = 0;
		int allyPower = 1; // just so we never divide by 0
		
		RobotType type;
		for(RobotInfo r: enemies){
			type=r.type;
			switch (type){
			case SOLDIER:
				enemyPower+=8;
				break;
			case BASHER:
				enemyPower+=4;
				break;
			case DRONE:
				enemyPower+=12;
				break;
			case COMMANDER:
				enemyPower+=15;
				break;
			case TANK:
				enemyPower+=25;
				break;
			case LAUNCHER:
				enemyPower+=15;
				break;
			case MISSILE:
				enemyPower+=20;
				break;
			case BEAVER:
				enemyPower+=4;
				break;
			case MINER:
				enemyPower+=3;
				break;
			default:
				break;
			}
		}
		
		for(RobotInfo r: allies){
			type=r.type;
			switch (type){
			case SOLDIER:
				allyPower+=8;
				break;
			case BASHER:
				allyPower+=4;
				break;
			case DRONE:
				allyPower+=12;
				break;
			case COMMANDER:
				allyPower+=15;
				break;
			case TANK:
				allyPower+=25;
				break;
			case LAUNCHER:
				allyPower+=15;
				break;
			case MISSILE:
				allyPower+=20;
				break;
			case BEAVER:
				allyPower+=4;
				break;
			case MINER:
				allyPower+=3;
				break;
			default:
				break;
			}
		}
		// if the ratio is over 100, BAD, under 100 GOOD
		double pressureRatio = 100 * (enemyPower/allyPower);
		int intPressureRatio = (int) Math.ceil(pressureRatio);
		rc.broadcast(1000, intPressureRatio);
		} // end of broadcastHQPressure method
	
	
	// Getter and setter methods for each enum:

	public int getNumEnemyBeaversSpotted() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUMBER_ENEMY_BEAVERS_SPOTTED
				.getValue());
	}

	public void setNumEnemyBeaversSpotted(int numSpawned)
			throws GameActionException {
		rc.broadcast(ChannelNumber.NUMBER_ENEMY_BEAVERS_SPOTTED.getValue(),
				numSpawned);
	}

	public void incrementNumEnemyBeaversSpotted() throws GameActionException {
		int numSpawned = rc
				.readBroadcast(ChannelNumber.NUMBER_ENEMY_BEAVERS_SPOTTED
						.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUMBER_ENEMY_BEAVERS_SPOTTED.getValue(),
				numSpawned);
	}

	public int getNumEnemyBarracksSpotted() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUMBER_ENEMY_BARRACKS_SPOTTED
				.getValue());
	}

	public void setNumEnemyBarracksSpotted(int numSpawned)
			throws GameActionException {
		rc.broadcast(ChannelNumber.NUMBER_ENEMY_BARRACKS_SPOTTED.getValue(),
				numSpawned);
	}

	public void incrementNumEnemyBarracksSpotted() throws GameActionException {
		int numSpawned = rc
				.readBroadcast(ChannelNumber.NUMBER_ENEMY_BARRACKS_SPOTTED
						.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUMBER_ENEMY_BARRACKS_SPOTTED.getValue(),
				numSpawned);
	}

	public void setRallyPoint1x(int xCoordinate) throws GameActionException {
		rc.broadcast(ChannelNumber.RALLYPOINT_1X.getValue(), xCoordinate);
	}

	public void setRallyPoint1y(int yCoordinate) throws GameActionException {
		rc.broadcast(ChannelNumber.RALLYPOINT_1Y.getValue(), yCoordinate);
	}

	public int getRallyPoint1x() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.RALLYPOINT_1X.getValue());
	}

	public int getRallyPoint1y() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.RALLYPOINT_1Y.getValue());
	}

	public int getNumBarracksSpawned() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUM_BARRACKS_SPAWNED.getValue());
	}

	public void setNumBarracksSpawned(int numSpawned)
			throws GameActionException {
		rc.broadcast(ChannelNumber.NUM_BARRACKS_SPAWNED.getValue(), numSpawned);
	}

	public void incrementNumBarracksSpawned() throws GameActionException {
		int numSpawned = rc.readBroadcast(ChannelNumber.NUM_BARRACKS_SPAWNED
				.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUM_BARRACKS_SPAWNED.getValue(), numSpawned);
	}

	public int getNumTankfactoriesSpawned() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUM_TANKFACTORIES_SPAWNED
				.getValue());
	}

	public void setNumTankfactoriesSpawned(int numSpawned)
			throws GameActionException {
		rc.broadcast(ChannelNumber.NUM_TANKFACTORIES_SPAWNED.getValue(),
				numSpawned);
	}

	public void incrementNumTankfactoriesSpawned() throws GameActionException {
		int numSpawned = rc
				.readBroadcast(ChannelNumber.NUM_TANKFACTORIES_SPAWNED
						.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUM_TANKFACTORIES_SPAWNED.getValue(),
				numSpawned);
	}
	
	public int getNumTanksSpawned() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUM_TANKS_SPAWNED.getValue());
	}
	
	public void incremementNumTanksSpawned() throws GameActionException {
		int numSpawned = rc.readBroadcast(ChannelNumber.NUM_TANKS_SPAWNED.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUM_TANKS_SPAWNED.getValue(), numSpawned);
	}

	public int getNumHelipadsSpawned() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUM_HELIPADS_SPAWNED.getValue());
	}

	public void setNumHelipadsSpawned(int numSpawned)
			throws GameActionException {
		rc.broadcast(ChannelNumber.NUM_HELIPADS_SPAWNED.getValue(), numSpawned);
	}

	public void incrementNumHelipadsSpawned() throws GameActionException {
		int numSpawned = rc.readBroadcast(ChannelNumber.NUM_HELIPADS_SPAWNED
				.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUM_HELIPADS_SPAWNED.getValue(), numSpawned);
	}

	public int getNumAerospacelabsSpawned() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUM_AEROSPACELABS_SPAWNED
				.getValue());
	}

	public void setNumAerospacelabsSpawned(int numSpawned)
			throws GameActionException {
		rc.broadcast(ChannelNumber.NUM_AEROSPACELABS_SPAWNED.getValue(),
				numSpawned);
	}

	public void incrementNumAerospacelabsSpawned() throws GameActionException {
		int numSpawned = rc
				.readBroadcast(ChannelNumber.NUM_AEROSPACELABS_SPAWNED
						.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUM_AEROSPACELABS_SPAWNED.getValue(),
				numSpawned);
	}

	public int getNumMinerfactoriesSpawned() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUM_MINERFACTORIES_SPAWNED
				.getValue());
	}

	public void setNumMinerfactoriesSpawned(int numSpawned)
			throws GameActionException {
		rc.broadcast(ChannelNumber.NUM_MINERFACTORIES_SPAWNED.getValue(),
				numSpawned);
	}

	public void incrementNumMinerfactoriesSpawned() throws GameActionException {
		int numSpawned = rc
				.readBroadcast(ChannelNumber.NUM_MINERFACTORIES_SPAWNED
						.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUM_MINERFACTORIES_SPAWNED.getValue(),
				numSpawned);
	}
	
	public int getNumMinersSpawned() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUM_MINERS_SPAWNED.getValue());
	}
	
	public void incrementNumMinersSpawned() throws GameActionException {
		int numSpawned = rc.readBroadcast(ChannelNumber.NUM_MINERS_SPAWNED.getValue()) +1;
		rc.broadcast(ChannelNumber.NUM_MINERS_SPAWNED.getValue(), numSpawned);
	}

	public int getNumSupplydepotsSpawned() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUM_SUPPLYDEPOTS_SPAWNED
				.getValue());
	}

	public void setNumSupplydepotsSpawned(int numSpawned)
			throws GameActionException {
		rc.broadcast(ChannelNumber.NUM_SUPPLYDEPOTS_SPAWNED.getValue(),
				numSpawned);
	}

	public void incrementNumSupplydepotsSpawned() throws GameActionException {
		int numSpawned = rc
				.readBroadcast(ChannelNumber.NUM_SUPPLYDEPOTS_SPAWNED
						.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUM_SUPPLYDEPOTS_SPAWNED.getValue(),
				numSpawned);
	}

	public MapLocation getRallyPoint() throws GameActionException {
		return new MapLocation(getRallyPoint1x(), getRallyPoint1y());
	}

	public void setRallyPoint(MapLocation rallyPoint)
			throws GameActionException {
		setRallyPoint1x(rallyPoint.x);
		setRallyPoint1y(rallyPoint.y);
	}

	public void setNumBeaversSpawned(int numBeavers) throws GameActionException {
		rc.broadcast(ChannelNumber.NUM_BEAVERS_SPAWNED.getValue(), numBeavers);
	}

	public int getNumBeaversSpawned() throws GameActionException {
		return rc.readBroadcast(ChannelNumber.NUM_BEAVERS_SPAWNED.getValue());
	}
	
	// the following method will be used to determine the number of each robot/building in the current round
	
	public void incrementUnitCount(int channelNum) throws GameActionException {
		
		// only check unit counts every tenth round
		if (Clock.getRoundNum() % 10 == 0) {
		int currentNum = rc.readBroadcast(channelNum);
		rc.broadcast(channelNum, currentNum + 1);
		}
	} 
	/** list of channelNums:
	10000: SupplyDepot
	10001: Technology Institute
	10002: Barracks
	10003: Helipad
	10004: Handwash Station
	10005: Miner Factory
	10006: Computer
	10007: Soldier
	10008: Basher
	10009: Drone
	10010: Miner
	10011: Training Field
	10012: Tank Factory
	10013: Aerospace Lab
	10014: Commander
	10015: Tank
	10016: Launcher
	*/
	
	// this method will be used by the hq to reset the unit counts every round
	public void decrementAllUnitCounts() throws GameActionException {
		
		// decrement the unit counts the round after the hq stored them (see hq class)
		if (Clock.getRoundNum() % 10 == 3) {
		for (int i = 10000; i < 10017; i++) {
			rc.broadcast(i, 0);
		}
	  }
	}
	
	public int readChannel(int channelNum) throws GameActionException {
		int num = rc.readBroadcast(channelNum);
		return num;
	}
	
} // end of messenger class
