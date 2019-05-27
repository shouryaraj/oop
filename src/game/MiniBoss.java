package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Tith Sothearith
 * miniboss class for creating boss and add behaviour
 */

public class MiniBoss extends Actor {
	private Actor target;
	// miniboss have 20 hit points and are always represented with a D
	public MiniBoss(String name, Actor player) {
		super(name, 'D', 2, 25);
		addBehaviour(new MiniBossBehaviour(player));
		this.target = player;
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(target.hasSkill(PlayerEnum.HASPOWER)) {
			return new RemoveActor(target);
		}
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
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
