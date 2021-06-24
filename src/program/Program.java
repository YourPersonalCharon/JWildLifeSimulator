package program;


import types.*;


public class Program{

	public static void main(String[] args) {
		
		Population animals = new Population();	
		
		World world = new World(C.WIDTH, C.HEIGHT, animals);
		
		MyPanel panel = new MyPanel(world);
		MyFrame frame = new MyFrame(panel);
		
		world.draw();
		
		for(int time = 0;time<C.MAX_TIME;time++) {
			
			H.lifeCycle(world);
			frame.panel.repaint();
			if(animals.predators.size()==0) {
				System.out.println("All predators have died in "
									+ time + " days");
				break;
			}
			try {
				Thread.sleep(C.TICKRATE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
