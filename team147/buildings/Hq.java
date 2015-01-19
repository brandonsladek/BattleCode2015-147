package team147.buildings;

import team147.BaseRobot;
import battlecode.common.Clock;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.RobotType;

public class Hq extends BaseRobot {
	int numBeaversAlive;
//	int[] unitCounts = new int[17];
//	int[] lastRoundUnitCounts = new int[17];

	public Hq(RobotController myRC) throws GameActionException {
		super(myRC);
		defaultSpawnSetup();
		while (true) {
			defaultTurnSetup();
			determineAllUnitCounts();
			attackLeastHealthyEnemy();
			messaging.broadCastHQPressure();
			transferSupply();
			defaultTurnEndAction();
		}
	} // end of HQ constructor
	
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
	
//	// returns an array of all of the unit counts
//	public void readAllUnitCounts() throws GameActionException {
//		// read unit counts the round after they were counted up (which is every tenth round)
//		if (Clock.getRoundNum() % 10 == 1) {
//		for (int i = 10000; i < 10017; i++) {
//			int unitCount = rc.readBroadcast(i);
//			unitCounts[i-10000] = unitCount;
//		}
//	  }
//	}
//	
//	// stores the last round's unit counts on channels 11000 through 11017
//	public void storeLastRoundUnitCounts() throws GameActionException {
//		// store unit counts the round after they were read
//		if (Clock.getRoundNum() % 10 == 2) {
//		for (int i = 0; i < unitCounts.length; i++) {
//			rc.broadcast(i+11000, unitCounts[i]);
//		}
//	  }
//	}
//	
//	// encapsulate unit count methods
//	public void determineLastRoundUnitCounts() throws GameActionException {
//		this.readAllUnitCounts();
//		this.storeLastRoundUnitCounts();
//	}
	
	int numAero = 0;
	int numBarr = 0;
	int numBash = 0;
	int numBeav = 0;
	int numComm = 0;
	int numComp = 0;
	int numDron = 0;
	int numHand = 0;
	int numHeli = 0;
	int numLaun = 0;
	int numMine = 0;
	int numMfct = 0;
	int numMiss = 0;
	int numSold = 0;
	int numSupp = 0;
	int numTank = 0;
	int numTfct = 0;
	int numTech = 0;
	int numTowe = 0;
	int numTrai = 0;
	
	// this method determines how many units of each kind are currently alive
	public void determineAllUnitCounts() throws GameActionException {
		
		numAero = 0;
		numBarr = 0;
		numBash = 0;
		numBeav = 0;
		numComm = 0;
		numComp = 0;
		numDron = 0;
		numHand = 0;
		numHeli = 0;
		numLaun = 0;
		numMine = 0;
		numMfct = 0;
		numMiss = 0;
		numSold = 0;
		numSupp = 0;
		numTank = 0;
		numTfct = 0;
		numTech = 0;
		numTowe = 0;
		numTrai = 0;
		
		RobotInfo[] allies = rc.senseNearbyRobots(999999, rc.getTeam());
		RobotType type;
		
		for(int i = 0; i < allies.length; i++) {
				type = allies[i].type;
				switch(type) {
				case AEROSPACELAB:
					numAero++;
					break;
				case BARRACKS:
					numBarr++;
					break;
				case BASHER:
					numBash++;
					break;
				case BEAVER:
					numBeav++;
					break;
				case COMMANDER:
					numComm++;
					break;
				case COMPUTER:
					numComp++;
					break;
				case DRONE:
					numDron++;
					break;
				case HANDWASHSTATION:
					numHand++;
					break;
				case HELIPAD:
					numHeli++;
					break;
				case LAUNCHER:
					numLaun++;
					break;
				case MINER:
					numMine++;
					break;
				case MINERFACTORY:
					numMfct++;
					break;
				case MISSILE:
					numMiss++;
					break;
				case SOLDIER:
					numSold++;
					break;
				case SUPPLYDEPOT:
					numSupp++;
					break;
				case TANK:
					numTank++;
					break;
				case TANKFACTORY:
					numTfct++;
					break;
				case TECHNOLOGYINSTITUTE:
					numTech++;
					break;
				case TOWER:
					numTowe++;
					break;
				case TRAININGFIELD:
					numTrai++;
					break;
				default:
					break;
				} // end of switch statement
		} // end of for loop
		
		rc.broadcast(20000, numAero);
		rc.broadcast(20001, numBarr);
		rc.broadcast(20002, numBash);
		rc.broadcast(20003, numBeav);
		rc.broadcast(20004, numComm);
		rc.broadcast(20005, numComp);
		rc.broadcast(20006, numDron);
		rc.broadcast(20007, numHand);
		rc.broadcast(20008, numHeli);
		rc.broadcast(20009, numLaun);
		rc.broadcast(20010, numMine);
		rc.broadcast(20011, numMfct);
		rc.broadcast(20012, numMiss);
		rc.broadcast(20013, numSold);
		rc.broadcast(20014, numSupp);
		rc.broadcast(20015, numTank);
		rc.broadcast(20016, numTfct);
		rc.broadcast(20017, numTech);
		rc.broadcast(20018, numTowe);
		rc.broadcast(20019, numTrai);
	  } // end of determineAllUnitCounts method
	
} // end of HQ class