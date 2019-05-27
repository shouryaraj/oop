package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;

import edu.monash.fit2099.engine.GameMap;


public class Thanos extends Actor{
	
	 private Actor target;
		/**
		 * Constructor
		 * @param name
		 * @param player
		 */
		// Grunts have 50 hitpoints and are always represented with a G
		public Thanos(String name, Actor player) {
			
			super(name, 'G', 40, 100);
			addBehaviour(new Qbehaviour(player));      //order matter
			this.target =player;
		
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
			if(target.hasSkill(PlayerEnum.HASSUPERPOWER)) {
				return new RemoveActor(target);
			}
			
			if(target.hasSkill(PlayerEnum.HASPOWER )) {
				
				
				
				for (ActionFactory factory : actionFactories) {
					Action action = factory.getAction(this, map);                  // Can't operate two behaviour together
					if(action != null)
						
						return action;
				 }
				}
			
			
			return new StayStill();
		}
		
}


