package types;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import program.C;

public class Population {
	
	public List<Pray> prays = new ArrayList<Pray>();
	public List<Predator> predators = new ArrayList<Predator>();
	
	public Population(){
		int startingAnimals = C.WIDTH * C.HEIGHT
							* C.STARTING_MAP_POPULATION_PERCENTAGE/100;
		
		Random rand = new Random();
		
		for(int i = 0; i < startingAnimals; i++) {
			
			Point pos = new Point(rand.nextInt(C.WIDTH),
								  rand.nextInt(C.HEIGHT));
			
			if(rand.nextInt(100) + 1 <= C.STARTING_PREDATORS_SPAWN_CHANCE){
				predators.add(new Predator(pos, rand.nextBoolean()));
			}else{
				prays.add(new Pray(pos, rand.nextBoolean()));
			}
		}
	}
}
