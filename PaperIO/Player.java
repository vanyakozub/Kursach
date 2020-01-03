//import.Point.class ;
//import.List.java;
import java.util.LinkedList;

public class Player {
   private Point head;
   private boolean[][] area;
   private LinkedList<Point> tail;
  // public Changes chan;

    public Player(Point h, Point[] a /*LinkedList<Point> t*//*, Changes c*/, int feildsize){
        head = h;
        tail = new LinkedList<Point>();
        //chan = new Changes();

        area = new boolean[feildsize][feildsize];
        for (Point point : a) {
            area[point.y][point.x] = true;
        }
    }

    public int loseCheck(Changes my, Changes enemy){
        if (my.head.x == enemy.head.x && my.head.y == enemy.head.y)
            return 1;
        //for (Point point : my.tail)
        if (my.area.isEmpty() || my.area.size() == 1)
            return 0;
        for (Point point : tail)
            if (my.head == point || enemy.head == point)
                return -1;
         if (my.tail == enemy.head)
             return -1;
         return 0;
    }

    public void refreshParametres(Changes my, Changes enemy){
        area[enemy.head.y][enemy.head.x] = false;
        area[my.head.y][my.head.x] = false;
        if (my.tail.x >= 0)
            tail.add(my.tail);
        if (my.area.size() == 1)
            area[my.area.get(0).y][my.area.get(0).x] = true;
        if (my.area.size() > 1)
            for (Point point : my.area)
                area[point.y][point.x] = true;
    }

    public Changes correct(Point newHead){ //нужно, чтобы проверить, появилась ли новая территория, если нет, то ничего не происходит

        Changes my = new Changes();
       if (newHead.x >= 0) { //если двигался
          // Changes my = new Changes();
           my.head = newHead;
           if (area[head.y][head.x] == true) {
               my.area.add(new Point(head.x, head.y));
           }
           else{
               if (area[newHead.y][newHead.x]){ ///////ДОПИСАТЬ

               }
               else{
                   my.tail = new Point(head.x, head.y);
               }
           }
       }
       return my;
    }
}
