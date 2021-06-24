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
	
	public static void lifeCycle(World world, Population animals) {
		breed(world,animals);
		move(animals);
		eat(world, animals);
		removeDead(animals);
		
		//TODO make graphics
		System.out.println(world.draw(animals));
	}

	private static void removeDead(Population animals) {
		List<Predator> predatorsTemp = new ArrayList<Predator>();
		for(Predator predator : animals.predators) {
			if(predator.starving || predator.isOld()) {
				continue;
			}
			predatorsTemp.add(predator);
		}
		animals.predators=predatorsTemp;
		
		List<Pray> praysTemp = new ArrayList<Pray>();
		
		for(Pray pray : animals.prays) {
			if(pray.isOld()) {
				continue;
			}
			praysTemp.add(pray);
		}
		animals.prays=praysTemp;
	}

	private static void eat(World world, Population animals) {
		for(Predator predator: animals.predators) {
			predator.eat(world, animals);
		}
	}

	private static void move(Population animals) {
		for(Pray animal : animals.prays) {
			animal.move();
		}
		for(Predator animal : animals.predators) {
			animal.move();
		}
		
	}

	private static void breed(World world, Population animals) {
		
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
					
					animals.add(new Predator(tile.coords, rand.nextBoolean()));
					
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
					
					animals.add(new Pray(tile.coords, rand.nextBoolean()));
					
					male--;female--;
				}
			}
		}
		
	}
	
}
