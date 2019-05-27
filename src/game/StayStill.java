package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/*
 * implementing restriction on actor from moving and say something
 *
 * 
 */
public class StayStill extends Action {
	 String[] string = {"I am feeling lonely Iron Man!", "Do You have Courage to Fight with me?"};

	 /*
	 * Special Action used when the player/actor doesn't want to do anything this turn.
	 */

		public StayStill() {
		}

		@Override
		public String execute(Actor actor, GameMap map) {
			String word ="";
			int i = 0;
		   if( Math.random()>= 0.5){
		    	i =1;
		    	
		    }
		     word= string[i];
			return actor +" says: " + "I am watching you IronMan...HAHA" +"\n" +word;
		}

		@Override
		public String menuDescription(Actor actor) {
			
			return null;
		}
		
		@Override
		public String hotKey() {
			return "5";
		}
		

}
