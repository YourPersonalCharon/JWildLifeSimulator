package types;

import program.C;
import program.H;

public class Predator implements Animal {
	
	public boolean sex;
	Point position;
	public int age;
	public boolean starving;
	
	@Override
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
	
	public void eat(World world) {
		if(world.map[position.y][position.x].prays.size()>0) {
			Pray pray = world.map[position.y][position.x].prays.remove(0);
			world.animals.prays.remove(pray);
			return;
		}
		starve();
	}
	
	private void starve() {
		starving=true;
	}

	public Predator(Point pos, boolean sex){
		position = pos;
		this.sex = sex;
		age=1;
	}

	public boolean isOld() {
		return age >= C.MAX_PREDATOR_AGE ? true
									     : false;
	}
}
