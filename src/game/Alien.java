package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.PickUpItemAction;

/**
 * 
 * @author Tith Sothearith
 *Creating Alien
 */
public class Alien extends Actor {
    private Actor target;
	/**
	 * creating the actor and add behavior
	 * @param name
	 * @param player
	 */
	// Alien have 50 hitpoints and are always represented with a A
	public Alien(String name, Actor player) {
		super(name, 'A', 5, 50);
		addBehaviour(new Qbehaviour(player));
		this.target = player;
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	/**
	 * Return the next action of the actor
	 * 
	 * @param: Actions action of the actor
	 * @param: GameMap location of the actor
	 * @param: Display 
	 * @return: what action the actor took at which direction and display it 
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
        for (Action action : actions) {
			
			if (action instanceof DropItemAction) {
				actions.remove(action);
			}
			else if(action instanceof PickUpItemAction) {
				actions.remove(action);
			}
		}
		return super.playTurn(actions,  map,  display);
	   }
	
}
