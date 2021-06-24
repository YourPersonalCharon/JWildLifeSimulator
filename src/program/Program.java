package program;


import types.*;


public class Program{

	public static void main(String[] args) {
		
		Population animals = new Population();	
		
		World world = new World(C.WIDTH, C.HEIGHT, animals);
		
		System.out.println(world.draw());
		
		MyPanel panel = new MyPanel(world);
		MyFrame frame = new MyFrame(panel);
		
		
		for(int time = 1;time<C.MAX_TIME;time++) {
			
			try {
				Thread.sleep(C.TICKRATE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			H.lifeCycle(world);
			frame.panel.repaint();
			if(animals.predators.size()==0) {
				System.out.println("All predators have died in "
									+ time + " days");
				break;
			}
		}	
	}
}
