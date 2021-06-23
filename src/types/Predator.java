package types;

public class Predator implements Animal {
	
	boolean sex;
	Point position;
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breed() {
		// TODO Auto-generated method stub
		
	}
	
	public void eat() {
		
	}
	
	public Predator(Point pos, boolean sex){
		position = pos;
		this.sex = sex;
	}
}
