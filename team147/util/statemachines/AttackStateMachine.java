package team147.util.statemachines;

import team147.BaseRobot;
import team147.util.StateMachine;
import battlecode.common.MapLocation;
import battlecode.common.RobotInfo;
import battlecode.common.RobotType;

public class AttackStateMachine extends StateMachine {
	public State currentState;

	public AttackStateMachine(BaseRobot br) {
		super(br);
		currentState = updateState();
	}

	RobotInfo enemies[] = br.rc.senseNearbyRobots(br.sensorRadiusSquared,br.enemyTeam);
	RobotInfo allies[] = br.rc.senseNearbyRobots(br.sensorRadiusSquared, br.myTeam);
	
	
	
	//Information Methods (methods that get data we can use to make state decisions)
	
	
	private double getEnemyAllyDifferential(){	//Determines the enemy:ally ratio within the sensor radius squared
		int enemyPower = 0;
		int allyPower = 0;
		
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
			}
		}
		switch (br.rc.getType()){
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
		}
				//Note: Things to think about - Bashers can attack all squares around it, Commanders increase hit points of units around it, etc
		
		//The higher the ratio, the worse the situation.
		double ratio = enemyPower/allyPower;	
		
		return ratio;			//Note: If we need to lower bytecodes, could save this ratio as a variable, and only update that variable every other round
	}

	
	
	//Methods that might already exist:
		//getEnemyTowerHealth()
		//getAllyTowerHealth()
		//getHQHealth()
		//getEnemyHQHealth()
	
	
	
	public State updateState() {
		
		if(getEnemyAllyDifferential()>)
		
		
		
	//Note: Maybe later, add logic that is specific to robot type
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		MapLocation currentLoc = br.rc.getLocation();

		
		
		if(enemies.length > allies.length){
			return
		}
		

		
		
		
		
		if(br.rc.getType()==SOLDIER){
			
		}
		
		return State.ATTACK;
		
		
		return State.DEFEND;
		
		return State.EXPLORE;

		return State.ECON;
		

	}

	public void sendStateMessages() {
		// TODO Auto-generated method stub

	}

}
