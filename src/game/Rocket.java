<<<<<<< HEAD
package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;


public class Rocket extends  Item {
	private static ArrayList<MovePlayer> mp = new ArrayList<MovePlayer>();
	
	
	public Rocket(String name, char displayChar) {
		super(name,  displayChar);
	
	}
	public static Rocket newFurnitureItem(String name, char displayChar)		//creating new rocket engine
	{
		Rocket rocket = new Rocket(name, displayChar);
		//disappear from map
		rocket.allowableActions.clear();
		return rocket ;
	}
	
	public void addMove(MovePlayer move) {
		mp.add(move);
	}
	public ArrayList<MovePlayer> getArrayList() {
		return new ArrayList<MovePlayer>(mp);
	}

=======
package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;


public class Rocket extends  Item {
	static ArrayList<MovePlayer> mp = new ArrayList<MovePlayer>();
	
	
	public Rocket(String name, char displayChar) {
		super(name,  displayChar);
	
	}
	public static Rocket newInventoryItem(String name, char displayChar)		//creating new rocket engine
	{
		Rocket rocket = new Rocket(name, displayChar);
		//disappear from map
		rocket.allowableActions.clear();
		return rocket ;
	}
	
	public void addMove(MovePlayer move) {
		mp.add(move);
	}
	public ArrayList<MovePlayer> getArrayList() {
		return new ArrayList<MovePlayer>(mp);
	}

>>>>>>> master
}