package game;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Rocket plan class will be called when rocket plan is picking up and exchanging between player and Q.
 * It is an extended item from the Item 
 * 
 */
public class RocketPlan extends Item {
	
	public RocketPlan(String name, char displayChar) {
		super(name,  displayChar);
	}
	public static RocketPlan newInventoryItem(String name, char displayChar)
	{
		RocketPlan rocket = new RocketPlan(name, displayChar);
		rocket.allowableActions.clear();								//remove rocket plan
		rocket.allowableActions.add(new DropItemAction(rocket));		//drop rocket plan
		return rocket;
	}
}
