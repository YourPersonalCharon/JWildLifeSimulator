package program;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;



import types.*;
/*	Helper
 * 	Contains utility methods
 */
public class H {
	
	public static Random rand = new Random();
	
	
	public static void lifeCycle(World world) {
		breed(world);
		move(world);
		eat(world);
				
		removeDead(world);
		
		System.out.println(world.draw());
	}

	private static void removeDead(World world) {
		List<Predator> predatorsTemp = new ArrayList<Predator>();
		for(Predator predator : world.animals.predators) {
			if(predator.starving || predator.isOld()) {
				continue;
			}
			predatorsTemp.add(predator);
		}
		world.animals.predators=predatorsTemp;
		
		List<Pray> praysTemp = new ArrayList<Pray>();
		
		for(Pray pray : world.animals.prays) {
			if(pray.isOld()) {
				continue;
			}
			praysTemp.add(pray);
		}
		world.animals.prays=praysTemp;
	}

	private static void eat(World world) {
		for(Predator predator: world.animals.predators) {
			predator.eat(world);
		}
		world.update();
	}

	private static void move(World world) {
		for(Pray animal : world.animals.prays) {
			animal.move();
		}
		for(Predator animal : world.animals.predators) {
			animal.move();
		}
		world.update();
	}

	private static void breed(World world) {
		
		for(Tile[] row : world.map) {
			for(Tile tile : row) {
				
				int male = 0;
				int female = 0;
				
				for(Predator predator: tile.predators) {
					if(predator.sex) {
						male++;
					}else {
						female++;
					}
				}
				
				while(male>0 && female>0) {
					
					world.animals.add(new Predator(tile.coords, rand.nextBoolean()));
					
					male--;female--;
				}
				
				male = 0;
				female=0;
				
				for(Pray pray: tile.prays) {
					if(pray.sex) {
						male++;
					}else {
						female++;
					}
				}
				
				while(male>0 && female>0) {
					
					world.animals.add(new Pray(tile.coords, rand.nextBoolean()));
					
					male--;female--;
				}
			}
		}
		world.update();
		
	}
	
}
