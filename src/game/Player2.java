package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 
 * Implementing player characteristics
 */

public class Player2 extends Player{
     private int stuntime;
     boolean check = true;
     boolean stop = true;
     private Tank tank;
	/**
	 * Constructor.
	 *
	 * @param name Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param priority How early in the turn the player can act
	 * @param hitPoints Player's starting number of hitpoints
	 */
	public Player2(String name, char displayChar, int priority, int hitPoints) {
		super(name, displayChar, priority, hitPoints);
		stuntime =0;				//Initialize stun time
		tank = new Tank("dummy", 'T');
	}
	
	/**
	 * This is where stun is implemented as well as building rocket and interaction with Q
	 * Player will skip turn if get stunned by ninjas
	 * When player arrived at rocket pad, rocket engine and rocket body will be check in order to build rocket
	 * Add rocket plan to the map
	 * @param: Action
	 * @param: Map
	 * @param: Display
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		
		boolean anotherDimension = false;
		if (stuntime > 0) {								//got stunned
			Actions newActions = new Actions();
			newActions.add(new SkipTurnAction());		//skip turn if stunned
			stuntime-=1;
			return showMenu(newActions, display);
		 }
		
		Location here = map.locationOf(this);
		if(check) {                                         
			if(this.hasSkill(PlayerEnum.HASROCKETPLAN)) {		//Add rocket plan and remove from the map
				map.add(new Floor(), here);
				check = false;
			}
		}
		
		// Waiting for the Oxygen Tank
		if(this.hasSkill(PlayerEnum.OXYGENTANKPRODUCE)) {
			this.removeSkill(PlayerEnum.OXYGENTANKPRODUCE);
			Actions newActions = new Actions();
			newActions.add(new WaitDispenser());	
			
			return showMenu(newActions, display);
		}
		
		
		for (Exit exit : here.getExits()) {              // For the Interaction of the Q
			Location destination = exit.getDestination();
			if(map.actorAt(destination) instanceof Q) {				//meet Q
				
				Actions newActions = new Actions();						
				newActions.add(new Talk(map.actorAt(destination)));		//talk action 
				return showMenu(newActions, display);
				
			}
				
			} 
		// Look for the RocketPad
		    if(stop) {
<<<<<<< HEAD
		      if(checkRocketPad(actions, map, display)) {
		    	  return new RocketBuild(this);	
		      };
			} 
		    
		    // Checking the Oxygen Feature
		  if (map instanceof ThanosWorld) {
			  if(checkToGoBack())
				  
				return new MovePlayer(new Maps().getArrayList().get(0).at(1, 9), "Earth", this);
=======
		    Item item1 = new Item("rocket", 'r');
		    Item item2 = new Item("rocket", 'r');
			if(here.getGround() instanceof RocketPad){
				for(Item item : here.getItems()) {
					if(item instanceof RocketBody) {		//look for rocket body
	                   item1 = item;
						value += 1;
					}
					if(item instanceof RocketEngine) {		//look for rocket engine
						item2 = item;
						value+= 1;
					}
				
				}
				if(value == 2) {
					this.addSkill(PlayerEnum.ROCKETDONE);
					stop =false;                         // No need to check Further
					here.removeItem(item1);
					here.removeItem(item2);
					Rocket rocket = new Rocket("Rocket", 'R');
					here.addItem(rocket);
					rocket.getAllowableActions().add(rocket.getArrayList().get(0));
					//map.addItem(rocket, 0, 9);
					return new RocketBuild(this);		//build rocket
				}
			
			 }
			
		
		  } // Extra feature
		  if (map instanceof Snapped) {
			  return new RemoveActor(this);
>>>>>>> master
		  }
		    
	
		return showMenu(actions, display);				//display
		}
	
	
	public boolean checkToGoBack() {
		tank.decreaseOxygenLevel();
		if (tank.oxygenValue() < 1) {
			return  true;
		}
		
		else {
		      return false;
		}
	}
    public boolean isStunned() {
    	return stuntime > 0;
	}
	
    public void stun() {
	   stuntime +=2;
	}
    
    public boolean checkRocketPad(Actions actions, GameMap map, Display display) {
    	Location here = map.locationOf(this);
    	int value = 0;
    	Item item1 = new Item("rocket", 'r');
		Item item2 = new Item("rocket", 'r');
		if(here.getGround() instanceof RocketPad){
			for(Item item : here.getItems()) {
				if(item instanceof RocketBody) {		//look for rocket body
	                   item1 = item;
						value += 1;
					}
					if(item instanceof RocketEngine) {		//look for rocket engine
						item2 = item;
						value+= 1;
					}
				
				}
				if(value == 2) {
					this.addSkill(PlayerEnum.ROCKETDONE);
					stop =false;                         // No need to check Further
					here.removeItem(item1);
					here.removeItem(item2);
					Rocket rocket = Rocket.newFurnitureItem("Rocket", 'R');
					here.addItem(rocket);
					rocket.getAllowableActions().add(rocket.getArrayList().get(0));
					//map.addItem(rocket, 0, 9);
					return true;
						//build rocket
				}
			
			 }
			return false;
    	
    }
	
}
