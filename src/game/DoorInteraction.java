package game;

import java.util.Random;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class DoorInteraction extends Action {

	private String direction;
	private Location windowLocation;
	private Random rand = new Random();
	
	/**
	 * 
	 * @param direction
	 * @param windowLocation
	 */
	public DoorInteraction(String direction, Location windowLocation) {
		this.direction = direction;
		this.windowLocation = windowLocation;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		
			return actor + "I am feeling afraid to go inside!";
		
		
		
	}

	@Override
	public String menuDescription(Actor actor) {
		if(actor.hasSkill(PlayerEnum.HASKEY)) {
		     return  "I am coming Mini Boss";
	  }
		return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
}
