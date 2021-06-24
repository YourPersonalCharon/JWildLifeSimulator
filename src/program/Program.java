package program;


import types.*;



public class Program {
	public static void main(String[] args) {
		World world = new World(C.WIDTH, C.HEIGHT);
		
		Population animals = new Population();
		
		world.draw(animals);
		
		for(int time = 0;time<100;time++) {
			H.lifeCycle(world, animals);
			if(animals.predators.size()==0) {
				System.out.println("All predators have died in "
									+ time + " days");
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
