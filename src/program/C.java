package program;

import java.awt.Color;

/*	Constants class
 *	Contains all the constant numbers needed
 * 
 * 
 */
public class C {
	
	//TIME
	public static final int TICKRATE = 400;
	public static final int MAX_TIME = 1000;
	
	//MAP
	public static final int HEIGHT = 10; 
	public static final int WIDTH = 10; 
	
	//POPULATION START
	public static final int STARTING_MAP_POPULATION_PERCENTAGE = 5000; 	// /100
	public static final int STARTING_PREDATORS_SPAWN_CHANCE = 20;		// /100
	
	//POPULATION LIFE
	public static final int OVERPOPULATION_THRESHOLD = 1000;
	public static final int MAX_PRAY_AGE=8;
	public static final int MAX_PREDATOR_AGE=8;
	public static final int PRAYS_BREED_CHANCE = 100; // 0 to 100
	public static final int PREDATORS_BREED_CHANCE = 50; // 0 to 100
	
	// how much prays die due to overpopulation
	public static final int PRAYS_STARVE_DEATH_PERCENTAGE = 50; 
	
	
	//GRAPHICS
	public static final int TILE_SIZE=60;
	public static final int CANVAS_WIDTH=TILE_SIZE*WIDTH;
	public static final int CANVAS_HEIGHT=TILE_SIZE*HEIGHT;
	
	//COLORS
	public static final Color BACKGROUND =  Color.white;	
	public static final Color NEUTRAL =  Color.yellow;
	public static final Color HUNGRY_TILE =  Color.red;
	public static final Color OK_TILE =  Color.green;
	public static final Color OVERPOPULATED_TILE =  Color.blue;
	
}
