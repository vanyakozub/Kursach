//import.Point.class ;
//import.List.java;
import java.util.LinkedList;

public class Player {
   private Point head;
   private LinkedList<Point> area;
   private LinkedList<Point> tail;

    public Player(Point h, LinkedList<Point> a, LinkedList<Point> t){
        head = h;
        area = a;
        tail = t;
    }
}