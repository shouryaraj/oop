package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class BackToEarth extends MovePlayer{
	Location moveToLocation;
	public BackToEarth(Location moveToLocation, String direction, Actor actor) {
		super(moveToLocation, direction, actor);
		this.moveToLocation = moveToLocation;
		
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		if(actor instanceof Player2) {
			actor.removeSkill(PlayerEnum.HASPOWER);
			actor.addSkill(PlayerEnum.EARTH);
		}
		map.moveActor(actor, moveToLocation);
		return actor + " Moved to " +  "Earth";
		
	}

}
