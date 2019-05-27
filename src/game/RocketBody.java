package game;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 
 * implementing rocket body
 * this class is called when creating the item e.g. rocket body 
 */
public class RocketBody extends Item {
	private String name;
	private char displayChar;
	
	public RocketBody(String name, char displayChar) {
		super(name, displayChar);
        
	}
	public static RocketBody newInventoryItem(String name, char displayChar)
	{
		RocketBody rocket = new RocketBody(name, displayChar);
		rocket.allowableActions.clear();								//not shown on map
		rocket.allowableActions.add(new DropItemAction(rocket));		//drop item on map
		return rocket;
	}
}