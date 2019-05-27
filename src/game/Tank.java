package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

public class Tank extends  Item {
	private static int oxygenLevel = 10;
	
	
	public Tank(String name, char displayChar) {
		super(name,  displayChar);
		 
	
	}
	public static Tank newFurniture(String name, char displayChar)		//creating new rocket engine
	{
		Tank tank = new Tank(name, displayChar);
        //tank.allowableActions.clear();
		
      
		
		return tank;
	}
	   public int oxygenValue() {
	    	return oxygenLevel;
	    }
	    
	   public void decreaseOxygenLevel() {
	    	oxygenLevel -= 1;
	   }
	   public void setOxygenLevel(int value) {
		   oxygenLevel = value * 10 ;
	   }


}
