import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.SwingUtilities;

public class Field {

    public Color[] color;
    public ArrayList<Point> head;
    public ArrayList<LinkedList<Point>> area;
    public ArrayList<LinkedList<Point>> tail;
    public JFrame frame;

    public Field() {

        init();
        setColors();
        frame = new JFrame("Paper.io");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(515, 538);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //MyComponent pole = new MyComponent();
        //pole.paintField();
       // frame.paint();
        //frame.add(new Board());
        frame.add(new Basic());
        frame.setVisible(true);
    }

    public void drawChanges(){
        frame.add(new Change());
    }

    public void getChanges(Point h1, Point h2, LinkedList<Point> a1, LinkedList<Point> a2, LinkedList<Point> t1, LinkedList<Point> t2){
        head.set(0, h1);
        head.set(1, h2);
        area.set(0, a1);
        area.set(1, a2);
        tail.set(0, t1);
        tail.set(1, t2);
    }

    public void init(){
        head.add(new Point());
        head.add(new Point());
        area.add(new LinkedList<Point>());
        area.add(new LinkedList<Point>());
        tail.add(new LinkedList<Point>());
        tail.add(new LinkedList<Point>());
    }
    public void setColors(){
        color = new Color[6];
        color[0] = new Color(0,69,16);
        color[1] = new Color(0, 140, 16);
        color[2] = new Color(57, 227, 78);
        color[3] = new Color(158, 8, 8);
        color[4] = new Color(243, 24, 24);
        color[5] = new Color(249, 80, 80);
    }

    public class Change extends JComponent{
        @Override
        public void paint(Graphics g1) {
            Graphics2D g = (Graphics2D)g1;
            int i = 0;
            for (i = 0; i < 2; i++) {
                Rectangle2D r = new Rectangle2D.Double(head.get(i).x, head.get(i).y, 20, 20);
                // g.setPaint(Color.getHSBColor(0, 204, 0));
                g.setPaint(color[i * 3]);
                g.fill(r);
                g.draw(r);
            }

            for (i = 0; i < 2; i++) {
                if (area.get(i).getFirst().x >= 0) {
                    ListIterator<Point> it = area.get(i).listIterator();
                    while (it.hasNext()) {
                        Point p = new Point();
                        p = (it.next());
                        Rectangle2D r = new Rectangle2D.Double(p.x, p.y, 20, 20);
                        g.setPaint(color[1 + i * 3]);
                        g.fill(r);
                        g.draw(r);
                    }
                }
            }

            for (i = 0; i < 2; i++) {
                if (tail.get(i).getFirst().x >= 0) {
                    for (Point point : tail.get(i)) {
                        //Point p = new Point();
                        //p = point;
                        Rectangle2D r = new Rectangle2D.Double(point.x, point.y, 20, 20);
                        g.setPaint(color[2 + i * 3]);
                        g.fill(r);
                        g.draw(r);
                    }
                }
            }

        }

    }

    public class Basic extends JComponent{
        @Override
        public void paint(Graphics g1){
            //g.drawLine(0, 0, 100, 100);
            Graphics2D g = (Graphics2D)g1;
           // int step = 10;
            for (int i = 1; i < 25; i++) {
                //Point2D p1 = new Point2D.Double(10 * i, 0);
               // Point2D p2 = new Point2D.Double(10 * i, 500);
                Line2D line = new Line2D.Double(20 * i, 0, 20 * i, 500);
                g.draw(line);
                Line2D line2 = new Line2D.Double(0, 20 * i, 500, 20 * i);
                g.draw(line2);
            }
            Rectangle2D r = new Rectangle2D.Double(0, 0, 40, 40);
           // g.setPaint(Color.getHSBColor(0, 204, 0));
            g.setPaint(color[1]);
            g.fill(r);
            g.draw(r);

            Rectangle2D r2 = new Rectangle2D.Double(460, 460, 40, 40);
            g.setPaint(color[4]);
            g.fill(r2);
            g.draw(r2);

            Rectangle2D r3 = new Rectangle2D.Double(40, 20, 20, 20);
            // g.setPaint(Color.getHSBColor(0, 204, 0));
            g.setPaint(color[0]);
            g.fill(r3);
            g.draw(r3);

            Rectangle2D r4 = new Rectangle2D.Double(440, 460, 20, 20);
            g.setPaint(color[3]);
            g.fill(r4);
            g.draw(r4);
        }
    }
}