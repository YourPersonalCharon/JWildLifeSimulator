package program;

import java.util.Random;



import types.*;
/*	Helper
 * 	Contains utility methods
 */
public class H {
	
	public static Random rand = new Random();
	
	
	public static void lifeCycle(World world) {
		doBreedingPhase(world);
		doMovingPhase(world);
		doEatingPhase(world);
		OverpopulationCheck(world);
		
		removeDead(world);
		
		System.out.println(world.draw());
	}

	private static void OverpopulationCheck(World world) {
		for(Tile[] row : world.map) {
			for(Tile tile : row) {
				if(tile.prays.size()>C.OVERPOPULATION_THRESHOLD) {
					starvePrays(tile);
					System.out.println(tile.coords+" overpopulated");
				}
			}
		}
		
	}

	private static void starvePrays(Tile tile) {
		int halfSize = tile.prays.size()*
				(100-C.PRAYS_STARVE_DEATH_PERCENTAGE)/100;
		for(int i = 0; i<halfSize;i++) {
			tile.prays.get(i).starve();
		}
		
	}

	private static void removeDead(World world) {
		
		world.animals.predators.removeIf(predator -> 
										((predator.starving) ||
										  predator.isOld()));
		
		world.animals.prays.removeIf(pray -> 
									((pray.starving) ||
									  pray.isOld()));
	}

	private static void doEatingPhase(World world) {
		for(Predator predator: world.animals.predators) {
			predator.eat(world);
		}
		world.update();
	}

	private static void doMovingPhase(World world) {
		for(Pray animal : world.animals.prays) {
			animal.move();
		}
		for(Predator animal : world.animals.predators) {
			animal.move();
		}
		world.update();
	}

	private static void doBreedingPhase(World world) {
		
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
					
					if(rand.nextInt(100)+1<=C.PREDATORS_BREED_CHANCE) {
						world.animals.add(new Predator(
								tile.coords, rand.nextBoolean()
								));
					}
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
					
					if(rand.nextInt(100)+1<=C.PRAYS_BREED_CHANCE) {
						world.animals.add(new Pray(
								tile.coords, rand.nextBoolean()
								));
					}
					male--;female--;
				}
			}
		}
		world.update();
		
	}
	
}
