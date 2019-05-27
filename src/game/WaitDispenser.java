package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class WaitDispenser extends Action {

	public WaitDispenser() {
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " Wait for the Oxygen";
	}
	
	@Override
	public String hotKey() {
		return "5";
	}
}