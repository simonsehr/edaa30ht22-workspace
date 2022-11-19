package mountain;

import java.util.Random;

import fractal.*;

public class Mountain extends Fractal {
    private Point a;
    private Point b;
    private Point c;
    private double dev;;

	/** Creates an object that handles Koch's fractal. 
	 * @param length the length of the triangle side
	 */
	public Mountain(Point p1, Point p2, Point p3, double dev) {
		super();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.dev = dev;
		
	}

	/**
	 * Returns the title.
	 * @return the title
	 */
    @Override
	public String getTitle() {
		return "Mountain";
	}

	/** Draws the fractal.  
	 * @param turtle the turtle graphic object
	 */
    @Override
    public void draw(TurtleGraphics turtle) {
   
        fractalLine(turtle, order, a, b, c);

    }

    private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c) {

        RandomUtilities rand = new RandomUtilities();
  
		if(order == 0){
            turtle.penUp();
            turtle.moveTo(a.getX(), a.getY());
            turtle.penDown();
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(a.getX(), a.getY());
		} else{

            int offset1 = (int) rand.randFunc(dev);
            int offset2 = (int) rand.randFunc(dev);
            int offset3 = (int) rand.randFunc(dev);
            dev = dev/2;
            
            Point p1p2 = new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY())/2 - offset1);
            Point p2p3 = new Point((b.getX() + c.getX()) / 2, (b.getY() + c.getY())/2 - offset2);
            Point p3p1 = new Point((c.getX() + a.getX()) / 2, (c.getY() + a.getY())/2 - offset3);


            fractalLine(turtle, order-1, a, p1p2, p3p1);
			fractalLine(turtle, order-1, b, p1p2, p2p3);
			fractalLine(turtle, order-1, c, p2p3, p3p1);
            fractalLine(turtle, order-1, p3p1, p1p2, p2p3);

        }
    }

}
