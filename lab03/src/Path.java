/** A class that represents a path via pursuit curves. */
public class Path {
    
    //current point of the path
    private Point curr;
    //next point of the path
    private Point next;

    public Path(double x, double y) {
        next = new Point(x, y);
        curr = new Point();
    }

    public double getCurrX() {
        return curr.getX();
    }
     
    public double getCurrY() {
        return curr.getY();
    }

    public double getNextX() {
        return next.getX();
    }

    public double getNextY() {
        return next.getY();
    }

    public Point getCurrentPoint() {
        return curr;
    }
     
    public void setCurrentPoint(Point point) {
        curr = point;
    }

    public void iterate(double dx, double dy) {
        curr = next;
        double x = getCurrX();
        double y = getCurrY();
        next = new Point(x+dx, y+dy);
    }
}
