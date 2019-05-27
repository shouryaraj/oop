package game;

import edu.monash.fit2099.demo.KickAction;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author
 * implementing goons
 */

public class Goons extends Actor {
    private Actor target;
    private Shift shift;
	/**
	 * Constructor
	 * @param name
	 * @param player
	 */
	// Grunts have 50 hitpoints and are always represented with a G
	public Goons(String name, Actor player) {
		
		super(name, 'G', 10, 50);
		addBehaviour(new GoonBehaviour(player));      //order matter
		this.target = player;
<<<<<<< HEAD
		this.addSkill(PlayerEnum.EARTH);
		shift = new Shift();
=======
>>>>>>> master
	
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	/**
	 * adding behaviour
	 * @param behaviour
	 */
	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	/**
	 * return the action at which direction and display it
	 * @param: Actor
	 * @param: location of the actor
	 * @param: Display
	 * @return: next action
	 */
	@Override  
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(target.hasSkill(PlayerEnum.HASPOWER)) {
<<<<<<< HEAD
			if (this.hasSkill(PlayerEnum.EARTH)) {
				return shift.shiftPlayer(this, target, map);
				     
			}
=======
			Maps transferMap = new Maps();
			map = transferMap.getArrayList().get(0);
			int value = (int) (Math.random()*10);
			System.out.println(value);
			while (map.isAnActorAt(map.at(5, value))){
				value = (int) (Math.random()*10);
				System.out.println(value);
			};
			return new MoveEnemies(map.at(5, value), "TO MOON", this);
>>>>>>> master
		}
			if(target.hasSkill(PlayerEnum.EARTH)) {
				if (this.hasSkill(PlayerEnum.HASPOWER)) {
				
					return shift.shiftPlayer(this, target, map);
		
			  }	
			}
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);                  // Can't operate two behaviour together
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
	
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(5, "kicks");
	}
}

