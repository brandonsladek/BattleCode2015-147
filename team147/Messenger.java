package team147;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

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

}
