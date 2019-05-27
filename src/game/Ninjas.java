package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 
 * creating ninjas and adding behaviours
 * 
 */

public class Ninjas extends Actor {
	private  boolean stun = false;
	private Actor target;
	private Shift shift;

	/**
	 * constructor
	 * @param name
	 * @param player
	 */
	public Ninjas(String name, Actor player) {
		//has hit points of 12 and shown on map as N
		super(name, 'N', 5, 12);
		//adding behaviour
		addBehaviour(new NinjasFight(player));				//two difference behaviours
		addBehaviour(new NinjasBehaviour(player));
		this.target = player;
		this.addSkill(PlayerEnum.EARTH);
		shift = new Shift();
		
	}

	public List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
		
	}
    
	/**
	 * Will remove all the drop and pickup action from ninjas
	 * @param: Action
	 * @param: Map
	 * @param: Display
	 * @return: playTurn
	 */
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
			
			if(action != null) {
			 
				   return action;
			   
		 }
			
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
	
    
	
	private void setStun(boolean value) {
		stun = value;
	}
    public boolean stun() {
    	return stun;
    }
}
