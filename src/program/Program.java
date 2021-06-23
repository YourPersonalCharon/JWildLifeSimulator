package program;
import types.*;


public class Program {
	public static void main(String[] args) {
		Map map = new Map(C.WIDTH, C.HEIGHT);
		
		Population animals = new Population();
		
		map.draw(animals);
		
		H.lifeCycle();
		
		
		
		System.out.println("Done");
		
		
		
	}
}
