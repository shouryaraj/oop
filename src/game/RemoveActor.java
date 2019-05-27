package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;

public class RemoveActor extends Action{
	

	private Actor target;

	public RemoveActor(Actor subject) {
		this.target = subject;
	}
	/**
	 * Perform the Action.
	 *
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a description of what happened that can be displayed to the user.
	 */
		@Override
		public String execute(Actor actor, GameMap map) {	
			map.removeActor(actor);
		
			return  "";
		}

		/**
		 * This is where the range of ninjas is implemented
		 * Ninjas will move if player is within the range 
		 * stay in one place otherwise
		 * @param: Actor
		 * @param: Map the location
		 * @return: null or new destination
		 */
		


	
		
		@Override
		public String menuDescription(Actor actor) {
			return "";
		}

		@Override
		public String hotKey() {
			return "";
		}
}
