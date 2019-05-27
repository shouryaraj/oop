<<<<<<< HEAD
package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * 
 * @author 
 * implementing locked door
 */

public class LockedDoor extends Ground {

	public LockedDoor() {
		//what locked door look like on map
		super('+');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasSkill(PlayerEnum.HASKEY);			//check if player has key
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new DoorInteraction(direction, location));
	}

	
	@Override
	public boolean blocksThrownObjects() {			//block actors, player or actions
		return true;
	}
}
=======
package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * 
 * @author 
 * implementing locked door
 */

public class LockedDoor extends Ground {

	public LockedDoor() {
		//what locked door look like on map
		super('+');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasSkill(PlayerEnum.HASKEY);			//check if player has key
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new DoorInteraction(direction, location));
	}

	
	@Override
	public boolean blocksThrownObjects() {			//block actors, player or actions
		return true;
	}
}
>>>>>>> master
