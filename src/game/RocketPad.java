package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * 
 * 
 * creating rocketpad
 * Extends Ground to make an location of Rocket Pad 
 */

public class RocketPad extends Ground {
	static ArrayList <ThanosWorld> map = new ArrayList <ThanosWorld>();

	public RocketPad() {		
		super('0');				//indicate rocketpad on the map
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		
		
		return true;	//check for rocket body and engine
	}

	

	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
