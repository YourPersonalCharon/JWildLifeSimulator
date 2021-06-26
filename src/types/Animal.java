package types;

import program.C;
import program.H;

public abstract class Animal {
	
	public boolean sex;
	Point position;
	public int age;
	public boolean starving;
	
	public void move() {
		int vertical = H.rand.nextInt(3)-1;		
		int horizontal = H.rand.nextInt(3)-1;		
		
		if(position.x==0 && horizontal==-1) {
			position.x=C.WIDTH-1;
		}else if(position.x == C.WIDTH-1 && horizontal == 1) {
			position.x=0;
		}else {
			position.x+=horizontal;
		}
		if(position.y==0 && vertical==-1) {
			position.y=C.HEIGHT-1;
		}else if(position.y == C.HEIGHT-1 && vertical == 1) {
			position.y=0;
		}else {
			position.y+=vertical;
		}
		
		age++;
	}
	abstract boolean isOld();
	
	public void starve() {
		starving=true;
	}
}
