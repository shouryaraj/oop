package game;

import edu.monash.fit2099.engine.*;
import java.util.Random;

/**
 * 
 * @author 
 * creating ninjas movement behavior
 * move one step away from player after throwing stun power
 */
public class NinjasBehaviour extends Action implements ActionFactory {

	private Actor target;

	public NinjasBehaviour(Actor subject) {
		this.target = subject;
	}
	
	/**
	 * Display a string indicating that ninjas is moving
	 * @param: Actor
	 * @param: Map
	 * @return: display
	 */
	@Override
	public String execute(Actor actor, GameMap map) {		//display when ninjas move
		return actor + " moves one step";
	}

	/**
	 * This is where the range of ninjas is implemented
	 * Ninjas will move if player is within the range 
	 * stay in one place otherwise
	 * @param: Actor
	 * @param: Map the location
	 * @return: null or new destination
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Random rand = new Random(); 
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
		//calculating the distance ninjas from player if player is more 5 square, do nothing
        if ((Math.abs(here.x() - there.x()) > 5) || (Math.abs(here.y()- there.y()) > 5)){
        	return null;
        }
        // move otherwise
		int currentDistance = distance(here, there);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();				//getting new destination
			if (destination.canActorEnter(actor)) {
				int newDistance = distance(destination, there);
				if (newDistance >= currentDistance) {
					return new MoveActorAction(destination, exit.getName());		//move to new destination
				}
			}
		}
			 
	
		return null;
	}


	// Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
	
	@Override
	public String menuDescription(Actor actor) {
		return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
}
