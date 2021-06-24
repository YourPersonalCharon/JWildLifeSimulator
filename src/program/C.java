package program;


/*	Constants class
 *	Contains all the constant numbers needed
 * 
 * 
 */
public class C {
	
	public static final int TICKRATE = 200;
	public static final int MAX_TIME = 1000;
	
	public static final int HEIGHT = 10; 
	public static final int WIDTH = 10; 
	public static final int STARTING_MAP_POPULATION_PERCENTAGE = 5000; 	// /100
	public static final int STARTING_PREDATORS_SPAWN_CHANCE = 5;		// /100
	
	public static final int MAX_PRAY_AGE=3;
	public static final int MAX_PREDATOR_AGE=5;
	
	public static final int TILE_SIZE=60;
	
	public static final int CANVAS_WIDTH=TILE_SIZE*WIDTH;
	public static final int CANVAS_HEIGHT=TILE_SIZE*HEIGHT;
}
