package game;
import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * 
 * @author 
 * creating Q 
 * 
 */
public class Q extends Actor {
	/**
	 * Constructor
	 * @param name
	 * @param player
	 */
	public Q(String name, Actor player) {
		//has hit points of 100 and shown on map as Q
		super(name, 'Q', 5, 100);
		addBehaviour(new Qbehaviour(player));
	}
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	/**
	 * Add behaviour
	 * @param behaviour
	 */
	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	
	/**
	 * This is where the action of Q removed
	 * @param: Actor
	 * @param: Map
	 * @param: Display
	 * @return: action or playTurn
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		
		for (ActionFactory factory : actionFactories) {
			Action actio = factory.getAction(this, map);
			if(actio != null)
				return actio;
		}
		for (Action action : actions) {
			if (action instanceof MoveActorAction) {
				actions.remove(action);
			}
			else if (action instanceof DropItemAction) {
				actions.remove(action);
			}
			else if(action instanceof PickUpItemAction) {
				actions.remove(action);
			}
		}
		
		return super.playTurn(actions,  map,  display);
	}
}
