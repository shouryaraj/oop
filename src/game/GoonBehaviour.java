package game;

import edu.monash.fit2099.engine.*;

/**
 * 
 * @author 
 * implementing goons behavior
 * follow and attack the player
 * shout insult to the player
 */
public class GoonBehaviour  extends FollowBehaviour  {

	private Actor target;

	/**
	 * Groon constructor
	 * @param subject
	 */
	public GoonBehaviour(Actor subject) {
		super(subject);
		this.target = subject;
	}

	/**
	 * The insult that will be display
	 * @param: Actor
	 * @param: GameMap location of the actor
	 * @return: Action shouting insult
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		double value = Math.random() *10;
		
		if (value >= 1 && value <= 2) {				//shouting insult
		     return new Insult(actor);
		 }
		 return super.getAction(actor, map);
		 
	}

	    
	
}
