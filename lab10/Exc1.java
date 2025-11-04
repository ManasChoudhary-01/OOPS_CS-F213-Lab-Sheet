package lab10;

interface Movable {
	public void moveUp();
	public void moveDown();
	public void moveLeft();
	public void moveRight();
	
	public class Main {
	    public static void main(String[] args) {
	        MovableCircle circle = new MovableCircle(0, 0, 2, 3, 5);

	        System.out.println(circle); // Before moving
	        circle.moveUp();
	        circle.moveRight();
	        System.out.println(circle); // After moving
	    }
	}
}

class MovablePoint implements Movable {
	int x,y;
	int xSpeed, ySpeed;
	
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.ySpeed = ySpeed;
		this.xSpeed = xSpeed;
	}
	
	public String toString() {
		return x + ":" + y;
	}
	
	@Override
	public void moveUp() {
		y-= ySpeed ;
	}
	
	@Override
	public void moveDown() {
		y+= ySpeed ;
	}
	
	@Override
	public void moveLeft() {
		x-= xSpeed ;
	}
	
	@Override
	public void moveRight() {
		x+= xSpeed ;
	}
}

class MovableCircle implements Movable {
	private int radius;
	private MovablePoint center;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		this.radius = radius;
		this.center = new MovablePoint(x,y, xSpeed, ySpeed); 
	}
	
    @Override
    public String toString() {
        return "MovableCircle with center " + center + " and radius " + radius;
    }
	
	@Override
	public void moveUp() {
		center.moveUp();
	}
	
	@Override
	public void moveDown() {
		center.moveDown() ;
	}
	
	@Override
	public void moveLeft() {
		center.moveLeft() ;
	}
	
	@Override
	public void moveRight() {
		center.moveRight() ;
	}
}

public class Exc1 {
	 public static void main(String[] args) {
		 Movable m1 = new MovablePoint(5, 6, 10, 11);
		 System.out.println(m1);
		 m1.moveLeft();
		 System.out.println(m1);
		 Movable m2 = new MovableCircle(2, 1, 2, 20,21);
		 System.out.println(m2);
		 m2.moveRight();
		 System.out.println(m2);
	  }
}
