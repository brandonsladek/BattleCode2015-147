package team147;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Messenger{

	private static RobotController rc;
	
	public Messenger(RobotController rc)
	{
		this.rc = rc;
	}
	
	private static enum ChannelNumber{
		//Enemy Intelligence Data:
		NUMBER_ENEMY_BEAVERS_SPOTTED (0),
		
		
		NUMBER_ENEMY_BARRACKS_SPOTTED (3),
		NUMBER_ENEMY_TANKFACTORIES_SPOTTED (4),
		
		
		//Example of a Map Location
		RALLYPOINT_1X (5),
		RALLYPOINT_1Y (6);
		
		//ADD Channels AS NEEDED
		

		
		private final int channelNum;
		
		ChannelNumber(int channelNum) {
			this.channelNum = channelNum;
		}
		
		public int getValue() {
			return channelNum;
		}
		
	}

	

	//Getter and setter methods for each enum:
	
	private int getNumEnemyBeaversSpotted() throws GameActionException
	{
		return rc.readBroadcast(ChannelNumber.NUMBER_ENEMY_BEAVERS_SPOTTED.getValue());
	}	
	private void setNumEnemyBeaversSpotted(int numSpawned) throws GameActionException
	{
		rc.broadcast(ChannelNumber.NUMBER_ENEMY_BEAVERS_SPOTTED.getValue(), numSpawned);
	}	
	private void incrementNumEnemyBeaversSpotted() throws GameActionException
	{
		int numSpawned = rc.readBroadcast(ChannelNumber.NUMBER_ENEMY_BEAVERS_SPOTTED.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUMBER_ENEMY_BEAVERS_SPOTTED.getValue(), numSpawned);
	}	
	
	private int getNumEnemyBarracksSpotted() throws GameActionException
	{
		return rc.readBroadcast(ChannelNumber.NUMBER_ENEMY_BARRACKS_SPOTTED.getValue());
	}	
	private void setNumEnemyBarracksSpotted(int numSpawned) throws GameActionException
	{
		rc.broadcast(ChannelNumber.NUMBER_ENEMY_BARRACKS_SPOTTED.getValue(), numSpawned);
	}	
	private void incrementNumEnemyBarracksSpotted() throws GameActionException
	{
		int numSpawned = rc.readBroadcast(ChannelNumber.NUMBER_ENEMY_BARRACKS_SPOTTED.getValue()) + 1;
		rc.broadcast(ChannelNumber.NUMBER_ENEMY_BARRACKS_SPOTTED.getValue(), numSpawned);
	}	
	
	
	private void setRallyPoint1x(int xCoordinate) throws GameActionException{
		rc.broadcast(ChannelNumber.RALLYPOINT_1X.getValue(), xCoordinate);
	}
	private void setRallyPoint1y(int yCoordinate) throws GameActionException{
		rc.broadcast(ChannelNumber.RALLYPOINT_1Y.getValue(), yCoordinate);
	}
	private void getRallyPoint1x() throws GameActionException{
		rc.readBroadcast(ChannelNumber.RALLYPOINT_1X.getValue());
	}
	private void getRallyPoint1y() throws GameActionException{
		rc.readBroadcast(ChannelNumber.RALLYPOINT_1Y.getValue());
	}
	
	
	
	
}


