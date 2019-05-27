package game;

import edu.monash.fit2099.engine.*;

/**+
 * 
 * @author
 * implementing miniboss behavior
 * stay in one place
 * attack player when player come close
 */
public class MiniBossBehaviour implements ActionFactory {

	private Actor target;

	public MiniBossBehaviour(Actor subject) {
		this.target = subject;
	}

	/**
	 * This will return null if player is not close to miniboss and return attack action if player is close to miniboss
	 * @param: Actor
	 * @param: Map
	 * @return: Attack action or null
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		for (Exit exit : there.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = distance(there, here);		//find the distance between the player and miniboss
				if (newDistance == 1 ) {
					return new AttackAction(actor, target);		//attack if player is close
				}
				else {
					return null;		
				}
			}
		}
		return null;
	}

		
	

	// Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}
