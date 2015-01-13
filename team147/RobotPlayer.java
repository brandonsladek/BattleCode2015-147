package team147;

import java.util.Random;

import battlecode.common.Clock;
import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.GameConstants;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.RobotType;

public class RobotPlayer {

	private static RobotController rc;
	private static Random rand;
	private static Direction currentDirection;
	private static MapLocation enemyHQLoc;
	private static MapLocation[] enemyTowers;
	private static Messenger messaging;

	public static void run(RobotController myRC) {

		rc = myRC;
		rand = new Random(rc.getID());
		currentDirection = randomDirection();
		messaging = new Messenger(rc);

		try {
			switch (rc.getType()) {
			case AEROSPACELAB:
				aerospacelab();
				break;
			case BARRACKS:
				barracks();
				break;
			case BASHER:
				basher();
				break;
			case BEAVER:
				beaver();
				break;
			case COMMANDER:
				commander();
				break;
			case COMPUTER:
				computer();
				break;
			case DRONE:
				drone();
				break;
			case HANDWASHSTATION:
				handwashstation();
				break;
			case HELIPAD:
				helipad();
				break;
			case HQ:
				hq();
				break;
			case LAUNCHER:
				launcher();
				break;
			case MINER:
				miner();
				break;
			case MINERFACTORY:
				minerfactory();
				break;
			case MISSILE:
				missile();
				break;
			case SOLDIER:
				soldier();
				break;
			case SUPPLYDEPOT:
				supplydepot();
				break;
			case TANK:
				tank();
				break;
			case TANKFACTORY:
				tankfactory();
				break;
			case TECHNOLOGYINSTITUTE:
				technologyinstitute();
				break;
			case TOWER:
				tower();
				break;
			case TRAININGFIELD:
				trainingfield();
				break;
			default:
				break;
			}
		} catch (GameActionException ge) {
			ge.printStackTrace();
		}
	} // end of run method

	// the following methods are all for the above switch statement
	private static void trainingfield() {
		while (true) {
			rc.yield();
		}
	} // end of trainingfield method

	private static void technologyinstitute() {
		while (true) {
			rc.yield();
		}
	} // end of technologyinstitute method

	private static void tower() throws GameActionException {
		while (true) {
			// attackEnemyZero();
			attackLeastHealthyEnemy();
			transferSupply();
			rc.yield();
		}
	} // end of tower method

	private static void tankfactory() throws GameActionException {
		while (true) {
			messaging.incrementNumTankfactoriesSpawned();
			rc.yield();
		}
	} // end of tankfactory method

	private static void tank() {
		while (true) {
			rc.yield();
		}
	} // end of tank method

	private static void supplydepot() throws GameActionException {
		messaging.incrementNumSupplydepotsSpawned();
		while (true) {
			transferSupply();
			rc.yield();
		}
	} // end of supplydepot method

	private static void soldier() throws GameActionException {
		while (true) {
			// attackEnemyZero();
			attackLeastHealthyEnemy();
			safeMoveTowardsHQ();
			transferSupply();
			rc.yield();
		}
	} // end of soldier method

	private static void missile() {
		while (true) {
			rc.yield();
		}
	} // end of missile method

	private static void minerfactory() throws GameActionException {
		messaging.incrementNumMinerfactoriesSpawned();
		int numMinersSpawned = 0;
		while (true) {
			if (numMinersSpawned++ < 10 || rand.nextDouble() < .01)
				spawnRobot(RobotType.MINER);
			rc.yield();
		}
	} // end of minerfactory method

	private static void miner() throws GameActionException {
		while (true) {
			mine();
			safeMoveAround();
			// attackEnemyZero();
			attackLeastHealthyEnemy();
			transferSupply();
			rc.yield();
		}
	} // end of miner method

	private static void launcher() throws GameActionException {
		while (true) {
			safeMoveTowardsHQ();
			checkAndLaunchMissile();
			rc.yield();
		}
	} // end of launcher method

	private static void hq() throws GameActionException {
		int numBeaversSpawned = 0;
		getAndSetRallyPoint(getEnemyHQLoc());
		while (true) {
			attackLeastHealthyEnemy();
			if (numBeaversSpawned++ < 10 || rand.nextDouble() < .01)
				spawnRobot(RobotType.BEAVER);
			transferSupply();
			rc.yield();
		}
	} // end of hq method

	private static void helipad() throws GameActionException {
		messaging.incrementNumHelipadsSpawned();
		while (true) {
			// spawnRobot(RobotType.DRONE);
			rc.yield();
		}
	} // end of helipad

	private static void handwashstation() {
		while (true) {
			rc.yield();
		}
	} // end of handwashstation method

	private static void drone() throws GameActionException {
		while (true) {
			attackLeastHealthyEnemy();
			moveTowardDestination(messaging.getRallyPoint());
			safeMoveTowardsHQ();
			transferSupply();
			rc.yield();
		}
	} // end of drone method

	private static void computer() {
		while (true) {
			rc.yield();
		}
	} // end of computer method

	private static void commander() {
		while (true) {
			rc.yield();
		}
	} // end of commander method

	private static void beaver() throws GameActionException {
		while (true) {

			switch (rand.nextInt(6)) {
			case 0:
			case 1:
			case 2:
			case 3:
				mine();
				safeMoveAround();
				break;
			case 4:
			case 5:
				build(getNeededBuilding());
			default:
				mine();
				safeMoveAround();
				break;
			}

			// attackEnemyZero();
			attackLeastHealthyEnemy();
			transferSupply();
			rc.yield();
		}
	} // end of beaver method

	private static void basher() throws GameActionException {
		while (true) {
			safeMoveTowardsHQ();
			transferSupply();
			rc.yield();
		}
	} // end of basher method

	private static void barracks() throws GameActionException {
		while (true) {
			messaging.incrementNumBarracksSpawned();
			spawnRobot(RobotType.SOLDIER);
		}
	} // end of barracks method

	private static void aerospacelab() throws GameActionException {
		messaging.incrementNumAerospacelabsSpawned();
		while (true) {
			spawnRobot(RobotType.LAUNCHER);
			rc.yield();
		}
	} // end of aerospacelab method

	// end of switch methods
	// --------------------------------------------------------------
	// ------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------
	// below are all of the methods used above

	private static boolean canBuildLauncher() {
		boolean canBuildLauncher = rc.hasBuildRequirements(RobotType.LAUNCHER);
		return canBuildLauncher;
	}

	private static void checkAndLaunchMissile() throws GameActionException {
		enemyTowers = rc.senseEnemyTowerLocations();
		int distanceFromNearestTower = rc.getLocation().distanceSquaredTo(
				enemyTowers[0]);
		Direction dir = rc.getLocation().directionTo(enemyTowers[0]);
		if (distanceFromNearestTower < RobotType.TOWER.attackRadiusSquared + 2) {
			if (rc.canLaunch(dir)) {
				rc.launchMissile(dir);
			}
		}
	} // end of checkAndLaunchMissile method

	private static void attackEnemyTowerZero() throws GameActionException {
		enemyTowers = rc.senseEnemyTowerLocations();
		if (rc.getLocation().distanceSquaredTo(enemyTowers[0]) <= rc.getType().attackRadiusSquared) {
			rc.attackLocation(enemyTowers[0]);
		} else {
			moveTowardDestination(enemyTowers[0]);
		}
	} // end of attackEnemyTowerZero method

	// this method returns a rally point halfway between our HQ and the attack
	// location
	private static MapLocation getAndSetRallyPoint(MapLocation attackLocation)
			throws GameActionException {
		MapLocation ourHQ = rc.senseHQLocation();

		MapLocation rallyPoint = ourHQ.add(ourHQ.directionTo(attackLocation),
				(int) (Math.sqrt(ourHQ.distanceSquaredTo(attackLocation)) / 4));

		messaging.setRallyPoint1x(rallyPoint.x);
		messaging.setRallyPoint1y(rallyPoint.y);
		return rallyPoint;
	} // end of getRallyPoint method

	private static Direction randomDirection() {
		return Direction.values()[rand.nextInt(8)];
	} // end of randomDirection method

	private static void moveAround() throws GameActionException {
		if (rc.isCoreReady()) {
			if (rc.canMove(currentDirection)) {
				if (rand.nextInt(100) > 10) {
					rc.move(currentDirection);
				} else {
					currentDirection = currentDirection.rotateRight();
					if (rc.canMove(currentDirection)) {
						rc.move(currentDirection);
					}
				}
			} else {
				currentDirection = currentDirection.rotateRight();
				moveAround();
			}
		}
	} // end of moveAround method

	private static void safeMoveAround() throws GameActionException {
		if (rc.isCoreReady()) {
			if (rc.canMove(currentDirection) && directionSafeFromTowers()) {
				if (rand.nextInt(100) > 10) {
					rc.move(currentDirection);
				} else {
					currentDirection = currentDirection.rotateRight();
					if (rc.canMove(currentDirection)
							&& directionSafeFromTowers()) {
						rc.move(currentDirection);
					} else {
						currentDirection = currentDirection.rotateRight();
						safeMoveAround();
					}
				}
			} else {
				currentDirection = currentDirection.rotateRight();
				safeMoveAround();
			}
		}
	}

	private static RobotType getNeededBuilding() throws GameActionException {
		if (messaging.getNumMinerfactoriesSpawned() < 2)
			return RobotType.MINERFACTORY;

		else if (messaging.getNumHelipadsSpawned() < 1)
			return RobotType.HELIPAD;

		else if (messaging.getNumSupplydepotsSpawned() < Clock.getRoundNum() / 100)
			return RobotType.SUPPLYDEPOT;

		else
			return RobotType.AEROSPACELAB;
	}

	private static boolean directionSafeFromTowers() {
		MapLocation target = rc.getLocation().add(currentDirection);
		MapLocation towerLocs[] = rc.senseEnemyTowerLocations();

		for (MapLocation towerLoc : towerLocs) {
			if (target.distanceSquaredTo(towerLoc) <= RobotType.TOWER.attackRadiusSquared)
				return false;
		}
		return true;
	}

	private static boolean directionSafeFromHQ() {
		MapLocation target = rc.getLocation().add(currentDirection);
		MapLocation hqLoc = getEnemyHQLoc();
		if (target.distanceSquaredTo(hqLoc) <= RobotType.HQ.attackRadiusSquared)
			return false;
		return true;
	}

	private static void moveTowardsHQ() throws GameActionException {
		if (rc.isCoreReady()) {
			if (rc.canMove(currentDirection)) {
				if (rand.nextInt(100) > 10) {
					rc.move(currentDirection);
				} else {
					currentDirection = rc.getLocation().directionTo(
							getEnemyHQLoc());
					if (rc.canMove(currentDirection)) {
						rc.move(currentDirection);
					}
				}
			} else {
				currentDirection = currentDirection.rotateRight();
			}
		}
	} // end of moveTowardsHQ method

	private static MapLocation getEnemyHQLoc() {
		if (enemyHQLoc == null)
			enemyHQLoc = rc.senseEnemyHQLocation();
		return enemyHQLoc;
	}

	private static void safeMoveTowardsHQ() throws GameActionException {
		if (rc.isCoreReady()) {
			if (rc.canMove(currentDirection)) {
				if (rand.nextInt(100) > 10 && directionSafeFromTowers()
						&& directionSafeFromHQ()) {
					rc.move(currentDirection);
				} else {
					currentDirection = rc.getLocation().directionTo(
							getEnemyHQLoc());
					if (rc.canMove(currentDirection)
							&& directionSafeFromTowers()) {
						rc.move(currentDirection);
					} else {
						currentDirection = currentDirection.rotateRight();
						// safeMoveTowardsHQ();
					}
				}
			} else {
				currentDirection = currentDirection.rotateRight();
				// safeMoveTowardsHQ();
			}
		}
	} // end of moveTowardsHQ method

	// we probably shouldn't use this method anymore since it makes more sense
	// to attack the least healthy enemy
	private static void attackEnemyZero() throws GameActionException {
		if (rc.isWeaponReady()) {
			RobotInfo[] enemies = rc.senseNearbyRobots(
					rc.getType().attackRadiusSquared, rc.getTeam().opponent());
			if (1 <= enemies.length) {
				rc.attackLocation(enemies[0].location);
			}
		}
	} // end of attackEnemyZero method

	private static void attackLeastHealthyEnemy() throws GameActionException {
		RobotInfo[] nearbyEnemies = rc.senseNearbyRobots(rc.getLocation(),
				rc.getType().attackRadiusSquared, rc.getTeam().opponent());
		double leastHealth = 999999;
		MapLocation loc = rc.getLocation().add(1, 1);
		for (RobotInfo robot : nearbyEnemies) {
			if (robot.health < leastHealth) {
				leastHealth = robot.health;
				loc = robot.location;
			}
		}
		if (nearbyEnemies.length >= 1) {
			if (rc.isCoreReady() && rc.isWeaponReady()) {
				rc.attackLocation(loc);
			}
		}
	} // end of attackLeastHealthyEnemy method

	private static void mine() throws GameActionException {
		int mineMax = (rc.getType() == RobotType.MINER ? GameConstants.MINER_MINE_MAX
				: GameConstants.BEAVER_MINE_MAX);

		if (rc.isCoreReady() && rc.senseOre(rc.getLocation()) > mineMax) {
			rc.mine();
		}
	} // end of mine method

	private static void spawnRobot(RobotType type) throws GameActionException {
		if (rc.hasSpawnRequirements(type) && rc.isCoreReady()) {
			for (Direction d : Direction.values()) {
				if (rc.canSpawn(d, type)) {
					rc.spawn(d, type);
					break;
				}
			}
		}
	} // end of spawnRobot method

	private static void build(RobotType building) throws GameActionException {
		if (rc.hasBuildRequirements(building) && rc.isCoreReady()) {
			for (int i = 0; i < 8; i++) {
				if (rc.canBuild(currentDirection, building)) {
					rc.build(currentDirection, building);
					break;
				} else
					currentDirection = currentDirection.rotateRight();
			}
		}
	} // end of build method

	private static void buildSupplyDepotNearHQ() throws GameActionException {
		MapLocation currentLoc = rc.getLocation();
		int distanceFromHQ = currentLoc.distanceSquaredTo(rc.senseHQLocation());
		if (Clock.getRoundNum() < 1500) {
			if (rand.nextInt(100) < 10) {
				if (distanceFromHQ < 60 && distanceFromHQ > 10) {
					build(RobotType.SUPPLYDEPOT);
				}
			}
		}
	} // end of buildSupplyDepotNearHQ method

	// checks to see how many nearby allies have zero supply
	private static int checkSupplyLevels() throws GameActionException {
		RobotInfo[] nearbyAllies = rc.senseNearbyRobots(rc.getLocation(),
				rc.getType().sensorRadiusSquared, rc.getTeam());
		int zeroSupplyCounter = 0;
		for (RobotInfo robot : nearbyAllies) {
			if (robot.supplyLevel == 0) {
				zeroSupplyCounter++;
			}
		}
		return zeroSupplyCounter;
	} // end of checkSupplyLevels method

	// transfer supply to other robots that have less supply
	private static void transferSupply() throws GameActionException {
		RobotInfo[] nearbyAllies = rc.senseNearbyRobots(rc.getLocation(),
				GameConstants.SUPPLY_TRANSFER_RADIUS_SQUARED, rc.getTeam());
		double lowestSupply = rc.getSupplyLevel();
		double transferAmount = 0;
		MapLocation transferDestination = null;
		if (nearbyAllies.length > 0) {
			for (RobotInfo robot : nearbyAllies) {
				if (robot.supplyLevel < lowestSupply) {
					lowestSupply = robot.supplyLevel;
					transferAmount = ((rc.getSupplyLevel() - robot.supplyLevel) / 2);
					transferDestination = robot.location;
				}
			}
		}
		if (transferDestination != null) {
			int transferDistance = transferDestination.distanceSquaredTo(rc
					.getLocation());
			if (transferDistance <= GameConstants.SUPPLY_TRANSFER_RADIUS_SQUARED) {
				rc.transferSupplies((int) transferAmount, transferDestination);
			}
		}
	} // end of transferSupply method

	private static void moveTowardDestination(MapLocation dest)
			throws GameActionException {
		Direction toDest = rc.getLocation().directionTo(dest);
		Direction[] directions = { toDest, toDest.rotateLeft(),
				toDest.rotateLeft().rotateLeft(), toDest.rotateRight(),
				toDest.rotateRight().rotateRight() };
		for (Direction d : directions) {
			if (rc.canMove(d) && rc.isCoreReady()) {
				rc.move(d);
				break;
			}
		}
	} // end of moveTowardDestination method

	// this method isn't being used, but could be used for efficient direction
	// changing
	private static int directionNum(Direction d) {
		switch (d) {
		case NORTH:
			return 0;
		case NORTH_WEST:
			return 1;
		case WEST:
			return 2;
		case SOUTH_WEST:
			return 3;
		case SOUTH:
			return 4;
		case SOUTH_EAST:
			return 5;
		case EAST:
			return 6;
		case NORTH_EAST:
			return 7;
		default:
			return -1;
		}
	} // end of directionNum method
} // end of RobotPlayer class
