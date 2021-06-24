package types;

import program.C;
import program.H;

public class Pray implements Animal {

	Point position;
	public boolean sex;
	public int age;
	@Override
	public void move() {
		int vertical = H.rand.nextInt(3)-1;		
		int horizontal = H.rand.nextInt(3)-1;		
		
		if(position.x==0 && vertical==-1) {
			position.x=C.WIDTH-1;
		}else if(position.x == C.WIDTH-1 && vertical == 1) {
			position.x=0;
		}else {
			position.x+=vertical;
		}
		if(position.y==0 && horizontal==-1) {
			position.y=C.HEIGHT-1;
		}else if(position.y == C.HEIGHT-1 && horizontal == 1) {
			position.y=0;
		}else {
			position.y+=horizontal;
		}
		
		age++;
	}
	
	public boolean isOld() {
		return age >= C.MAX_PRAY_AGE ? true
									 : false;
	}
	
	public Pray(Point pos, boolean sex) {
		position = pos;
		this.sex = sex;
		age=1;
	}

}
