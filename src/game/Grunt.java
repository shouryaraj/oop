package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;




public class Grunt extends Actor {
	private Actor target;
	private Shift shift;

	// Grunts have 50 hitpoints and are always represented with a g
	public Grunt(String name, Actor player) {
		super(name, 'g', 5, 50);
		addBehaviour(new FollowBehaviour(player));
		this.target = player;
		this.addSkill(PlayerEnum.EARTH);
		 shift = new Shift();
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(target.hasSkill(PlayerEnum.HASPOWER)) {
			if (this.hasSkill(PlayerEnum.EARTH)) {
				return shift.shiftPlayer(this, target, map);
				     
			}
		}
			if(target.hasSkill(PlayerEnum.EARTH)) {
				if (this.hasSkill(PlayerEnum.HASPOWER)) {
				
					return shift.shiftPlayer(this, target, map);
		
			  }	
			}
			
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
