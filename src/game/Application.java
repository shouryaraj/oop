<<<<<<< HEAD
package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.demo.DemoSkills;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.WeaponItem;
import edu.monash.fit2099.engine.World;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new RocketPad(), new Pool(), new MoonFloor());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...+....#....#....",
				"....#####....##.###....",
				".......................",
				".......................",
				".......................",
				".......................",
				".0.....................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		 List<String> marsMap = Arrays.asList(
					"ooooooooooooooooooooooo",
					"ooooooooooooooooooooooo",
					"ooooooooooooooooooooooo",
					"ooooooooooooooooooooooo",
					"oo########ooooooooooooo",
					"oooo~~~oooooooooooooooo",
					"oooo~~~oooooooooooooooo",
					"oooo~~~oooooooooooooooo",
					"ooooooooooooooooooooooo",
					"oooooooooooooooooo###oo",
					"ooooooooooooooooo##oooo");
	        ThanosWorld avenger = new ThanosWorld(groundFactory, marsMap);
	        world.addMap(avenger);
	        FancyGroundFactory groundFactory1 = new FancyGroundFactory(new space(), new Floor(), new Wall());
	      // Extra feature to move the Thanos World \	 
	        List<String> SwapMap = Arrays.asList(
	        		"            ...........",
					"         ..............",
					"......            .....",
					"          .............",
					"....###....            ",
					"............           ",
					"          .............",
					"          .............",
					"          .............",
					"...................#...",
					"          .......#.....");		
			
	        Snapped Swap = new Snapped(groundFactory1, SwapMap);
	        world.addMap(Swap);
	        Maps store1 = new Maps(gameMap);
	        Maps store2 = new Maps(avenger);
	        
	        
			Actor player = new Player2("Player", '@', 1, 100);
			world.addPlayer(player, gameMap, 2, 2);
			
		 Rocket rocket = Rocket.newFurnitureItem("Rocket", 'R');
		 rocket.addMove(new MovePlayer(avenger.at(7, 2), "Welcome to Moon ", player));
		  
		  // Adding place snap the figure
		 Item swap = Item.newFurniture("Swap", 'S');
		 swap.getAllowableActions().add(new BackToEarth(gameMap.at(1, 9), "Earth", player));
		 avenger.addItem(swap, 1, 1);
		
		 Oxygen oxy = Oxygen.newFurniture("OxygenDispenser", 'D');
		 oxy.getAllowableActions().add(new OxygenDispenser(player));
		 gameMap.addItem(oxy, 0, 9);
		 
		 
		// key Item
		Item key = Item.newInventoryItem("Key", 'k');
        key.addSkill(PlayerEnum.HASKEY);
		
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 0, 0);
        
		grunt.addItemToInventory(key);
		
		Grunt grunt2 = new Grunt("Norbert", player);
		gameMap.addActor(grunt2,  10, 10);
	
		grunt2.addItemToInventory(key);
		
		Goons goon1 = new Goons("sony", player);
		gameMap.addActor(goon1,  10, 3);
	
		goon1.addItemToInventory(key);
		
		Goons goon2 = new Goons("Nobita", player);
		gameMap.addActor(goon2,  10, 5);
		goon1.addItemToInventory(key);
		
        
        RocketEngine rocketengine =  RocketEngine.newInventoryItem("rocket engine", 'e');
        rocketengine.addSkill(PlayerEnum.HASROCKETENGINE);
        
        RocketPlan rocketplan = new RocketPlan("rocket plan", 'p');
        rocketplan.addSkill(PlayerEnum.HASROCKETPLAN);
        gameMap.addItem(rocketplan, 5, 3);
        
        WaterGun gun = new WaterGun("Water Gun", '>');
        avenger.addItem(gun, 5, 1);
        gun.addSkill(PlayerEnum.HASGUN);
        
      
        RocketBody rocketbody = RocketBody.newInventoryItem("rocket body", 'b');
        rocketbody.addSkill(PlayerEnum.HASROCKETBODY);
        
        
//      MiniBoss doctormaybe = new MiniBoss("Doctor Maybe", player);
//     	gameMap.addActor(doctormaybe, 5, 2); 
//     	doctormaybe.addItemToInventory(rocketengine);
//     	        
     	Ninjas ninjas = new Ninjas("Ninjas", player);
     	gameMap.addActor(ninjas, 6, 8);
//     		
//     	Q npc = new Q("Q", player);
//     	gameMap.addActor(npc, 14, 10);
//     	npc.addItemToInventory(rocketbody);
        
//     	     
//        
//        // Extra feature for the Thanos World
//        Gauntlet gauntlet = new Gauntlet("thanos gauntlet", 'Y');
//        gauntlet.addSkill(PlayerEnum.HASGAUNTLET);
//        avenger.addItem(gauntlet, 17, 2);
        
        GemStone soulStone = new GemStone("Soul Stone", '*');
        soulStone.addSkill(PlayerEnum.HASSOULSTONE);
        avenger.addItem(soulStone, 5, 10);
        
        GemStone mindStone = new GemStone("Mind Stone", '*');
        mindStone.addSkill(PlayerEnum.HASMINDSTONE);
        avenger.addItem(mindStone, 9, 6);
        
        GemStone realityStone = new GemStone("Reality Stone", '*');
        realityStone.addSkill(PlayerEnum.HASREALITYSTONE);
        avenger.addItem(realityStone, 1, 7);
        
        GemStone powerStone = new GemStone("Power Stone", '*');
        powerStone.addSkill(PlayerEnum.HASPOWERSTONE);
        avenger.addItem(powerStone, 8, 9);
        
        GemStone timeStone = new GemStone("Time Stone", '*');
        timeStone.addSkill(PlayerEnum.HASTIMESTONE);
        avenger.addItem(timeStone, 15, 7);
        
        YoguMaxx maxx = new YoguMaxx ("YoguMaxx", player);
        avenger.addActor(maxx, 5, 10);
        maxx.addSkill(PlayerEnum.HASEXOSKELETON);
	    
        Item spaceSuit = new Item("space suit", '[');
        spaceSuit.addSkill(PlayerEnum.HASSPACESUIT);
        gameMap.addItem(spaceSuit, 0, 1);
        
        player.addSkill(PlayerEnum.HASSPACESUIT);
	    
//       player.addItemToInventory(key);	     
//	     npc.addItemToInventory(rocketplan);
         player.addItemToInventory(rocketbody);
         player.addItemToInventory(rocketengine);
//	     player.addItemToInventory(timeStone);
//	     player.addItemToInventory(powerStone);
//	     player.addItemToInventory(realityStone);
//	     player.addItemToInventory(mindStone);
//	     player.addItemToInventory(soulStone);
//	     player.addItemToInventory(gauntlet);
////			
		world.run();
	}
}
=======
package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.demo.DemoSkills;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.WeaponItem;
import edu.monash.fit2099.engine.World;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new RocketPad(), new Pool(), new MoonFloor());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...+....#....#....",
				"....#####....##.###....",
				".......................",
				".......................",
				".......................",
				".......................",
				".0.....................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		 List<String> marsMap = Arrays.asList(
					"ooooooooooooooooooooooo",
					"ooooooooooooooooooooooo",
					"ooooooooooooooooooooooo",
					"ooooooooooooooooooooooo",
					"oo########ooooooooooooo",
					"oooo~~~oooooooooooooooo",
					"oooo~~~oooooooooooooooo",
					"oooo~~~oooooooooooooooo",
					"ooooooooooooooooooooooo",
					"oooooooooooooooooo###oo",
					"ooooooooooooooooo##oooo");
	        ThanosWorld avenger = new ThanosWorld(groundFactory, marsMap);
	        world.addMap(avenger);
	        FancyGroundFactory groundFactory1 = new FancyGroundFactory(new space(), new Floor(), new Wall());
	      // Extra feature to move the Thanos World \	 
	        List<String> SwapMap = Arrays.asList(
	        		"            ...........",
					"         ..............",
					"......            .....",
					"          .............",
					"....###....            ",
					"............           ",
					"          .............",
					"          .............",
					"          .............",
					"...................#...",
					"          .......#.....");		
			
	        Snapped Swap = new Snapped(groundFactory1, SwapMap);
	        world.addMap(Swap);
	        Maps store = new Maps(avenger);
	        
	        
			Actor player = new Player2("Player", '@', 1, 100);
			world.addPlayer(player, gameMap, 2, 2);
			
		  Item rocketLaunch = Item.newFurniture("Rocket", '=');
		  rocketLaunch.getAllowableActions().add(new MovePlayer(avenger.at(7, 2), "Thanos World !", player));
		  gameMap.addItem(rocketLaunch, 0, 9);
		  // Adding place snap the fingure ===
		  Item swap = Item.newFurniture("Swap", 'S');
		  swap.getAllowableActions().add(new Snap(Swap.at(4, 2), "Swapped", player));
		  avenger.addItem(swap, 1, 1);
		
		// key Item
		Item key = Item.newInventoryItem("Key", 'k');
        key.addSkill(PlayerEnum.HASKEY);
		
//		Grunt grunt = new Grunt("Mongo", player);
//		gameMap.addActor(grunt, 0, 0);
//      avenger.addActor(grunt, 0, 0);
//		grunt.addItemToInventory(key);
//		
//		Grunt grunt2 = new Grunt("Norbert", player);
//		gameMap.addActor(grunt2,  10, 10);
//		avenger.addActor(grunt2,  10, 10);
//		grunt2.addItemToInventory(key);
//		
//		Goons goon1 = new Goons("sony", player);
//		gameMap.addActor(goon1,  10, 3);
//		avenger.addActor(goon1,  10, 3);
//		goon1.addItemToInventory(key);
//		
//		Goons goon2 = new Goons("Nobita", player);
//		gameMap.addActor(goon2,  10, 5);
//		avenger.addActor(goon2,  10, 5);
//		goon1.addItemToInventory(key);
		
        
        RocketEngine rocketengine =  RocketEngine.newInventoryItem("rocket engine", 'e');
        rocketengine.addSkill(PlayerEnum.HASROCKETENGINE);
        
        RocketPlan rocketplan = new RocketPlan("rocket plan", 'p');
        rocketplan.addSkill(PlayerEnum.HASROCKETPLAN);
        gameMap.addItem(rocketplan, 5, 3);
        
        WaterGun gun = new WaterGun("Water Gun", '>');
        avenger.addItem(gun, 5, 1);
        gun.addSkill(PlayerEnum.HASGUN);
        
      
        RocketBody rocketbody = RocketBody.newInventoryItem("rocket body", 'b');
        rocketbody.addSkill(PlayerEnum.HASROCKETBODY);
        
        
//      MiniBoss doctormaybe = new MiniBoss("Doctor Maybe", player);
//     	gameMap.addActor(doctormaybe, 5, 2); 
//     	doctormaybe.addItemToInventory(rocketengine);
//     	        
//     	Ninjas ninjas = new Ninjas("Ninjas", player);
//     	gameMap.addActor(ninjas, 6, 8);
//     		
//     	Q npc = new Q("Q", player);
//     	gameMap.addActor(npc, 14, 10);
//     	npc.addItemToInventory(rocketbody);
        
//     	     
//        
//        // Extra feature for the Thanos World
//        Gauntlet gauntlet = new Gauntlet("thanos gauntlet", 'Y');
//        gauntlet.addSkill(PlayerEnum.HASGAUNTLET);
//        avenger.addItem(gauntlet, 17, 2);
        
        GemStone soulStone = new GemStone("Soul Stone", '*');
        soulStone.addSkill(PlayerEnum.HASSOULSTONE);
        avenger.addItem(soulStone, 5, 10);
        
        GemStone mindStone = new GemStone("Mind Stone", '*');
        mindStone.addSkill(PlayerEnum.HASMINDSTONE);
        avenger.addItem(mindStone, 9, 6);
        
        GemStone realityStone = new GemStone("Reality Stone", '*');
        realityStone.addSkill(PlayerEnum.HASREALITYSTONE);
        avenger.addItem(realityStone, 1, 7);
        
        GemStone powerStone = new GemStone("Power Stone", '*');
        powerStone.addSkill(PlayerEnum.HASPOWERSTONE);
        avenger.addItem(powerStone, 8, 9);
        
        GemStone timeStone = new GemStone("Time Stone", '*');
        timeStone.addSkill(PlayerEnum.HASTIMESTONE);
        avenger.addItem(timeStone, 15, 7);
        
        YoguMaxx maxx = new YoguMaxx ("YoguMaxx", player);
        avenger.addActor(maxx, 5, 10);
        maxx.addSkill(PlayerEnum.HASEXOSKELETON);
	    
        Item spaceSuit = new Item("space suit", '[');
        spaceSuit.addSkill(PlayerEnum.HASSPACESUIT);
        gameMap.addItem(spaceSuit, 0, 1);
	    
//       player.addItemToInventory(key);	     
//	     npc.addItemToInventory(rocketplan);
         player.addItemToInventory(rocketbody);
         player.addItemToInventory(rocketengine);
//	     player.addItemToInventory(timeStone);
//	     player.addItemToInventory(powerStone);
//	     player.addItemToInventory(realityStone);
//	     player.addItemToInventory(mindStone);
//	     player.addItemToInventory(soulStone);
//	     player.addItemToInventory(gauntlet);
////			
		world.run();
	}
}
>>>>>>> master
