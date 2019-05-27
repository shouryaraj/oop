package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class MoveEnemies extends MovePlayer {
	private Location moveToLocation;
	public MoveEnemies(Location moveToLocation, String direction, Actor actor) {
		super(moveToLocation, direction, actor  );
		this.moveToLocation = moveToLocation;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		map.moveActor(actor, moveToLocation);
		return actor + "Moved" +  "moon";
		
	}
}
