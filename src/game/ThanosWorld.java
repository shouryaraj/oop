package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.GroundFactory;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Range;
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
import edu.monash.fit2099.engine.World;

public class ThanosWorld extends GameMap {

	protected Range heights;
	protected Range widths;
	protected Location[][] map;
	protected ActorLocations actorLocations;
	protected GroundFactory groundFactory;

	/**
	 * Constructor.
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param groundChar Symbol that will represent empty Ground in this map
	 * @param width width of the GameMap, in characters
	 * @param height height of the GameMap, in characters
	 */
	public ThanosWorld(GroundFactory groundFactory, char groundChar, int width, int height) {
		super(groundFactory,groundChar, width, height);
	}
	

	/**
	 * Constructor that reads a map from file.
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param mapFile Name of a file containing an ASCII representation of a level
	 * @throws IOException when file I/O fails
	 */
	public ThanosWorld(GroundFactory groundFactory, String mapFile) throws IOException {
		super(groundFactory, mapFile);
	}

	/**
	 * Constructor that creates a map from a sequence of ASCII strings.
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param lines List of Strings representing rows of the map
	 */
	public ThanosWorld(GroundFactory groundFactory, List<String> lines) {
		super(groundFactory,lines);
	}
}
