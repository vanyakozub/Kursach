import java.util.LinkedList;

public class Changes {
    public Point head;
    public LinkedList<Point> area;
    public Point tail;

    public Changes(){
        head = new Point(-1, -1);
        tail = new Point(-1, -1);
        area = new LinkedList<Point>();
       // area.add(null);
    }
}
