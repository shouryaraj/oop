package game;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 * creating rocket engine which will be called when picking up and at rocket pad where it will be checked in order to build rocket.
 */
public class RocketEngine extends Item {
	
	public RocketEngine(String name, char displayChar) {
		super(name,  displayChar);
	
	}
	public static RocketEngine newInventoryItem(String name, char displayChar)		//creating new rocket engine
	{
		RocketEngine rocket = new RocketEngine(name, displayChar);
		rocket.allowableActions.clear();								//disappear from map
		rocket.allowableActions.add(new DropItemAction(rocket));		//drop item
		return rocket;
	}

}