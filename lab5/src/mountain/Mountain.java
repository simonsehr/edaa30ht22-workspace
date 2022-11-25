package mountain;

import java.util.HashMap;

import fractal.*;

public class Mountain extends Fractal {
    private Point a;
    private Point b;
    private Point c;
    private double dev;;
    private HashMap<Side, Point> map;

	/** Creates an object that handles Koch's fractal. 
	 * @param length the length of the triangle side
	 */
	public Mountain(Point p1, Point p2, Point p3, double dev) {
		super();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.dev = dev;
		map = new HashMap<Side, Point>();
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
   
        fractalLine(turtle, order, a, b, c, dev);

    }

    private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev) {
  
		if(order == 0){
            turtle.moveTo(a.getX(), a.getY());
            turtle.penDown();
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(a.getX(), a.getY());
            
		} else{
            
            
            /*Point p1p2 = new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY())/2 + (int) RandomUtilities.randFunc(dev));
            Point p2p3 = new Point((b.getX() + c.getX()) / 2, (b.getY() + c.getY())/2 + (int) RandomUtilities.randFunc(dev));
            Point p3p1 = new Point((c.getX() + a.getX()) / 2, (c.getY() + a.getY())/2 + (int) RandomUtilities.randFunc(dev));
            */

            Point p1p2 = midPoint(a, b, dev);
			Point p2p3 = midPoint(b, c, dev);
			Point p3p1 = midPoint(a, c, dev);

            dev = dev/2;

            fractalLine(turtle, order-1, a, p1p2, p3p1, dev);
			fractalLine(turtle, order-1, b, p1p2, p2p3, dev);
			fractalLine(turtle, order-1, c, p2p3, p3p1, dev);
            fractalLine(turtle, order-1, p3p1, p1p2, p2p3, dev);

            

        }
    }

    public Point midPoint(Point a, Point b, double dev)  {
		Point mid;

		Side side = new Side(a, b);
		
		if (map.containsKey(side)) {
			mid = map.get(side);
			map.remove(side);
		} else {
			int midX = ((a.getX() + b.getX()) /2);
			int midY = ((a.getY() + b.getY()) /2);
			mid = new Point( midX , (midY + (int)Math.rint(RandomUtilities.randFunc(dev))) );
			map.put(side, mid);
		}

		return mid;
	}

}
