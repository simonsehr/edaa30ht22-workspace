package mountain;

public class Side {
    private Point a;
    private Point b;

    public Side(Point p1, Point p2){
        this.a = p1;
        this.b = p2;

    }

    @Override
    public int hashCode() {
    return a.hashCode() + b.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Side) {
            Side side = (Side) o;
           return (side.a == a && side.b == b) || (side.b == a && side.a == b);
        } else {
            return false;
        }
        
    }



    
}
