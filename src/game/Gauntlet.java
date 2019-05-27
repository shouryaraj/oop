package game;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 
 * extra feature
 * implementing gauntlet
 */
public class Gauntlet extends Item {
	
	/**
	 * creating gauntlet
	 * @param name
	 * @param displayChar
	 */
	public Gauntlet(String name, char displayChar) {
		super(name,  displayChar);
		newFurniture( name,  displayChar);
	}

}