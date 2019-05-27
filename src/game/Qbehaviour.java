package game;
import edu.monash.fit2099.engine.*;

/**
 * 
 * @author 
 * Creating Q behavior
 * Randomly moving around
 * Interact with the player
 * Swapping item with player
 */
public class Qbehaviour implements ActionFactory{
	private Actor target;

	public Qbehaviour(Actor subject) {
		this.target = subject;
	}
	
	/**
	 * This is where Q movement is implemented
	 * random number is used to get the next destination of Q
	 *@param: Actor
	 *@param: Map
	 *@return: return next destination or null
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
        
		int currentX = here.x();
		int currentY = here.y();
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			
			
			if (destination.canActorEnter(actor)) {     // destination just an single step to check
				if (Math.random() < 0.25) {
//				int newDistance = distance(destination, there);     
//				int newY = currentY + (int)Math.random()*15;    // need to make an logic to check whether it can go inside or not
//				if (newDistance  > currentX && newY <  currentY) { 
					return new MoveActorAction(destination, exit.getName());
//				}
			}
		}
		}

		return null;
	}
	

	// Random distance Calculation
	private int distance(Location a, Location b) {
		int x= a.x();
		int y = a.y();
		//System.out.println(a.y());
		if (a.x()>= 15 ) {
		  x = a.x()+(int)Math.random()*15;
		}
		if (a.x()< 15 ) {
		  x = a.x()-(int)Math.random()*15;
		}
		return x;
	}
}
		
	

	
		


	


