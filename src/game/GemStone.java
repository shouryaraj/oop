package game;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 
 * EXTRA FEATURE
 * implementing soul stone
 * this class is called when creating the item 
 */
public class GemStone extends Item {
	private String name;
	private char displayChar;
	
	public GemStone(String name, char displayChar) {
		super(name, displayChar);
        
		
		
	}
	public static GemStone newInventoryItem(String name, char displayChar)
	{
		GemStone Stone = new GemStone(name, displayChar);
		Stone.allowableActions.clear();								//not shown on map
		Stone.allowableActions.add(new DropItemAction(Stone));		//drop item on map
		return Stone;
	}
	
	
  
}