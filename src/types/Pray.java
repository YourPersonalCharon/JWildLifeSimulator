package types;

import program.C;

public class Pray extends Animal {
	
	public boolean isOld() {
		return age >= C.MAX_PRAY_AGE ? true
									 : false;
	}
	
	public Pray(Point pos, boolean sex) {
		position = pos;
		this.sex = sex;
		age=0;
	}

}
