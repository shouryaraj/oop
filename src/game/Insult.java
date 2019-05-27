package game;

import edu.monash.fit2099.engine.*;

/**
 * 
 * @author 
 * insult behavior for goons
 * throw out insult when player health is less than 10%
 */
public class Insult extends Action {

	
	private Actor actor;
	String[] statement = {" No need for insults, your face says it all.", " Your intelligence is my common sense."};
	int i;
	
	/**
	 * 
	 * @param actor
	 */
	public Insult(Actor actor) {
		this.actor = actor;
		
	}

	/**
	 * Groon will shout out the insult while following the player
	 * @param: Actor
	 * @param: Map
	 * @return: insult statement
	 */
	@Override
	public String execute(Actor actor, GameMap map) {	//calculating the chance of shouting insult
		  double k = (Math.random());
			if (k>=0.5)
				i = (int) Math.ceil(k);
			if (k< 0.5)
				i = (int) Math.floor(k);
		
		return  actor +" says: " + statement[i];
	}

	/**
	 * A string describing the action suitable for displaying in the UI menu.
	 *
	 * @param actor The actor performing the action.
	 * @return a String, e.g. "Player drops the potato"
	 */
	@Override
	public String menuDescription(Actor actor) {
		return "";
	}

	/**
	 * Returns an empty string as item dropping does not have a dedicated hotkey.
	 *
	 * @return an empty string
	 */
	@Override
	public String hotKey() {
		return "";
	}
}
