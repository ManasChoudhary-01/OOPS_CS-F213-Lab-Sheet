package lab9;

public class Anonymous {

    public Circle getCircle(int radius) {

    	return new Circle(radius) {
    		
    		@Override
    		public double area() {
    			return 3.14*radius*radius;
    		}
    	};
    }

    public static void main(String[] args) {
        Anonymous p = new Anonymous();
        Circle w = p.getCircle(10);
        System.out.println(w.area());
    }
}

class Circle {
    private int rad;

    public Circle(int radius) {
        rad = radius;
    }

    public double area() {
        return rad * rad;
    }
}

