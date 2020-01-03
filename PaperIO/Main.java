import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class Main {

    public static void main(String[] args) {

        /*boolean[][] a = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                System.out.print(a[i][j]);
            System.out.println();
        }*/
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Field();
            }
        });*/
        Field feild = new Field();
        //

        /*Changes one  = new Changes();
        Changes two  = new Changes();
        one.head = new Point(3, 1);
        one.tail = new Point(2, 1);
        feild.getChanges(one, two);
        feild.drawChanges();*/
        //
    }
}
