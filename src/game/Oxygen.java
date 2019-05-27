package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

public class Oxygen extends Item {
	 
	public Oxygen(String name, char displayChar) {
		super(name,  displayChar);
	
	}
	public static Oxygen newFurniture(String name, char displayChar)		//creating new rocket engine
	{
		Oxygen oxygen = new Oxygen(name, displayChar);
		oxygen.allowableActions.clear();								//disappear from map	//drop item
		
		
		return oxygen;
	}
}
	
	