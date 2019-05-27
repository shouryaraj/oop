package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import java.util.*;

/**
 * 
 * 
 * This class will perform rocket build, this class will be 
 * called when player is at the rocket pad and trying to build rocket
 */
public class RocketBuild extends Action {
	private Actor actor;
	private Actor subject;
	//private Random rand = new Random();

	public RocketBuild(Actor actor) {
		this.actor = actor;
		this.subject = subject;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
	   
		return "Rocket building is done!" +"\n\n";		//display string if rocket is built
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Build Rocket";
	}

	@Override
	public String hotKey() {
		return "b";
	}


}
