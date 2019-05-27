package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

import game.ActionFactory;
import edu.monash.fit2099.engine.*;

/**
 * 
 * @author 
 * creating ninjas fighting behavior
 * throw stunned power when player is within range
 */
public class NinjasFight extends Action implements ActionFactory{

	private Actor target;

	public NinjasFight(Actor subject) {
		this.target = subject;
	}

	/**
	 * Calculate the chance of hitting player with stun powder
	 * @param: Actor
	 * @param: Map
	 * @return: String stating whether stun powder hit or not
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		double chance = Math.random();
		if (chance > 0.5) {
		
			((Player2) target).stun();
			return actor + " throw stunned power at " + target + ".";
		}
		return actor + "Missed the" + target;
	}
	
	/**
	 * The range surrounding  ninjas will be calculated and check if player is within that range
	 * Will throw stun powder if player is within the range
	 * don not move otherwise
	 * 
	 * @param: Actor
	 * @param: Map
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
		//do nothing if player is more than 5 square away
		 if ((Math.abs(here.x() - there.x()) > 5) || (Math.abs(here.y()- there.y()) > 5)){
	        	return null;
	        }
		//setting the range of the throw
		Range xs, ys;
			
		 if (here.x() == there.x() || here.y() == there.y()) {
				xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
				ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);
	
				for (int x : xs) {
					for (int y : ys) {
						if(map.at(x, y).getGround().blocksThrownObjects())			//block the throwing 
							return null;
					}
				}
				 if (target instanceof Player2) {
					 if (!((Player2) target).isStunned()) {			//stunned if hit
						 return this;
					 }
				 }
			
		
		  }
		
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "";
	}

	@Override
	public String hotKey() {
		return "";
	}
}
