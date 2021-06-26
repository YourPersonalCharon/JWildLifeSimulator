package types;

import program.C;

public class Predator extends Animal {
	
	
	
	public void eat(World world) {
		if(world.map[position.y][position.x].prays.size()>0) {
			Pray pray = world.map[position.y][position.x].prays.remove(0);
			world.animals.prays.remove(pray);
			return;
		}
		starve();
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
