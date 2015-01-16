package team147;

import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class MapAnalysis {

	private static RobotController rc;
	private static int towerHQProtection = 0;
	private static int xMin, xMax, yMin, yMax;
	
	// constructor
	public MapAnalysis(RobotController rc) {
		this.rc = rc;
	}
	
	/** this method returns an int that represents how many enemy towers are within 
	 * ten tiles of the enemy hq
	 */
	public int analyzeEnemyTowerHQProtection() {
		MapLocation[] enemyTowers = rc.senseEnemyTowerLocations();
		MapLocation enemyHQ = rc.senseEnemyHQLocation();
		towerHQProtection = 0;
		for (MapLocation tower : enemyTowers) {
			if (tower.distanceSquaredTo(enemyHQ) < 100) {
				towerHQProtection++;
			}
		} return towerHQProtection;
	} // end of analyzeEnemyTowerHQProtection method
	
} // end of MapAnalysis class
