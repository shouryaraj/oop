package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class OxygenDispenser extends Action {

	
	private Actor target;
	String[] statement = {" No need for insults, your face says it all.", " Your intelligence is my common sense."};
	int i;
	
	/**
	 * 
	 * @param actor
	 */
	public OxygenDispenser(Actor target) {
		this.target = target;
		
	}

	/**
	 * 
	 * @param: Actor
	 * @param: Map
	 * @return: insult statement
	 */
	@Override
	public String execute(Actor actor, GameMap map) {	
		Location here = map.locationOf(actor);
		for(Item item : here.getItems()) {
			if(item instanceof Tank) {
				 return "Tank is Available";
			}
		}
		Tank tank = Tank.newFurniture("Tank", 'T');
	    tank.addSkill(PlayerEnum.OXYGENTANK);
	    here.addItem(tank);
		actor.addSkill(PlayerEnum.OXYGENTANKPRODUCE);
	    return "Oxygen is generated";
	}

	/**
	 * A string describing the action suitable for displaying in the UI menu.
	 *
	 * @param actor The actor performing the action.
	 * @return a String, e.g. "Player drops the potato"
	 */
	@Override 
	public String menuDescription(Actor actor) {
		return "Press O to generate oxygen Tank";
	}

	/**
	 * Returns an empty string as item dropping does not have a dedicated hotkey.
	 *
	 * @return an empty string
	 */
	@Override
	public String hotKey() {
		return "o";
	}
}

