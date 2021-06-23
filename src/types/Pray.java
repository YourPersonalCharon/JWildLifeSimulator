package types;

public class Pray implements Animal {

	Point position;
	boolean sex;
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breed() {
		// TODO Auto-generated method stub
		
	}
	
	public Pray(Point pos, boolean sex) {
		position = pos;
		this.sex = sex;
	}

}
