package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.World;

public class MovePlayer extends Action {

	private Location moveToLocation;
	private String direction;
	private String hotKey;
    private Actor player;
	/**
	 * Constructor to create an Action that will move the Actor to a Location in a given Direction, using
	 * a given menu hotkey.
	 *
	 * Note that this constructor does not check whether the supplied Location is actually in the given direction
	 * from the Actor's current location.  This allows for (e.g.) teleporters, etc.
	 *
	 * @param moveToLocation the destination of the move
	 * @param direction the direction of the move (to be displayed in menu)
	 * @param hotKey the menu hotkey for this move
	 */
	public MovePlayer(Location moveToLocation, String direction, String hotKey) {
		this.moveToLocation = moveToLocation;
		this.direction = direction;
		this.hotKey = hotKey;
		
	}

	/**
	 * Constructor to create an Action that will move the Actor to a Location in a given Direction.  A currently-unused
	 * menu hotkey will be assigned.
	 *
	 * Note that this constructor does not check whether the supplied Location is actually in the given direction
	 * from the Actor's current location.  This allows for (e.g.) teleporters, etc.
	 *
	 * @param moveToLocation Location to move to
	 * @param direction String describing the direction to move in, e.g. "north"
	 */
	public MovePlayer(Location moveToLocation, String direction, Actor actor) {
		this.moveToLocation = moveToLocation;
		this.direction = direction;
		this.hotKey = "";
		this.player  = actor;
	}

	/**
	 * Allow the Actor to be moved.
	 *
	 * Overrides Action.execute()
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a description of the Action suitable for the menu
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		for(Item item: actor.getInventory()) {
			if(item instanceof Tank) {
				map.moveActor(actor, moveToLocation);
				actor.addSkill(PlayerEnum.HASPOWER);
				// Adding new Actors on the ThanosWOrld
				return menuDescription(actor);
			}
		}
		return "You need Oxygen To Survive on the Moon Base!"+"\n";
           
			
		     
		
		
		
		
	}

	/**
	 * Returns a description of this movement suitable to display in the menu.
	 *
	 * @param actor The actor performing the action.
	 * @return a String, e.g. "Player moves east"
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " moves " + direction;
	}

	/**
	 * Returns this Action's hotkey.
	 *
	 * @return the hotkey
	 */
	@Override
	public String hotKey() {
		return hotKey;
	}
}
