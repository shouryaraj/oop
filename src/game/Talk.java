package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * 
 *  
 * action class for Q 
 * implementing talk action when player meet Q
 */
public class Talk extends Action {
	 
        private Actor target;
		int i;

		public Talk(Actor actor) {
			this.target = actor;
			
		}

		/**
		 * Talk to the player
		 *
		 * @param actor The actor performing the action
		 * @param map The map the actor is on
		 * @return a description of the action suitable for feedback in the UI
		 */
		@Override
		public String execute(Actor actor, GameMap map) {
			 if (actor.hasSkill(PlayerEnum.HASROCKETPLAN)) 		//check for rocket plan
			 {   for(Item item : actor.getInventory())
				   if(item instanceof RocketPlan) {
					   for(Item itemQ: target.getInventory()) {
						   if (itemQ instanceof RocketBody) {
						       actor.addItemToInventory(itemQ);	
						       actor.removeItemFromInventory(item);//adding item to the inventory
						   }
						  
					   }
					  
					  	
			           
			           map.removeActor(target);			//Q disappear
				   }
				 return target + "Hand over I don't have time all day";		//display talking
			 }
			
			return actor + "I can give you something that will help, but I am going to need the plans." ;
		}

		/**
		 * A string describing the action suitable for displaying in the UI menu.
		 *
		 * @param actor The actor performing the action.
		 * @return a String, e.g. "Talk to Q"
		 */
		@Override
		public String menuDescription(Actor actor) {
		       return "Talk to Q";
			}
		
		@Override
		public String hotKey() {
			return "t";
		}

}
