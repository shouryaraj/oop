package game;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class Shift {
	
	
	public Shift() {
		
	}
	
	public Action shiftPlayer(Actor actor, Actor target, GameMap map) {
		
		if (actor.hasSkill(PlayerEnum.EARTH)) {
			
			
			Maps transferMap = new Maps();
			map = transferMap.getArrayList().get(1);
			int value1 = (int) (Math.random()*10);
			int value2 = (int) (Math.random()*10);
			
			while (map.isAnActorAt(map.at(value1, value2))){
				value1= (int) (Math.random()*10);
				value2 = (int) (Math.random()*10);
			};
			actor.removeSkill(PlayerEnum.EARTH);
			actor.addSkill(PlayerEnum.HASPOWER);
			return new MoveEnemies(map.at(value1, value2), "TO MOON", actor);
		}
		else if(actor.hasSkill(PlayerEnum.HASPOWER)) {
			Maps transferMap = new Maps();
			map = transferMap.getArrayList().get(0);
			int value1 = (int) (Math.random()*10);
			int value2 = (int) (Math.random()*10);
			
			while (map.isAnActorAt(map.at(value1, value2))){
				value1= (int) (Math.random()*10);
				value2 = (int) (Math.random()*10);
			};
			actor.removeSkill(PlayerEnum.HASPOWER);
			actor.addSkill(PlayerEnum.EARTH);
			return new MoveEnemies(new Maps().getArrayList().get(0).at(value1 ,value2),"TO Earth", actor);
		}
			return null;
	}
}