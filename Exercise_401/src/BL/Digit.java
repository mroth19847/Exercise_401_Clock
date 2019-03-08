package BL;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

public class Digit extends JLabel {

    private int number;
    private boolean colon;

    public Digit(boolean colon) {
        this.number = 0;
        this.colon = colon;
        this.setSize(11, 18);
    }

    public void setNumber(int number) throws Exception {
        if (number < 0 || number > 9) {
            throw new Exception("Digit is invalid!");
        }
        this.number = number;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw((Graphics2D) g);
    }

    public void draw(Graphics2D g) {
        if (colon) {
            g.setColor(Color.RED);
            g.fillRect(4, 4, 3, 3);
            g.fillRect(4, 11, 3, 3);
        } else {
            drawBasic(g);
            g.setColor(Color.RED);
            switch (number) {
                case 0:
                    g.fillRect(1, 1, 9, 2);
                    g.fillRect(1, 1, 2, 9);
                    g.fillRect(8, 1, 2, 9);
                    g.fillRect(8, 8, 2, 9);
                    g.fillRect(1, 8, 2, 9);
                    g.fillRect(1, 15, 9, 2);
                    break;
                case 1:
                    g.fillRect(8, 1, 2, 9);
                    g.fillRect(8, 8, 2, 9);
                    break;
                case 2:
                    g.fillRect(1, 1, 9, 2);
                    g.fillRect(8, 1, 2, 9);
                    g.fillRect(1, 8, 9, 2);
                    g.fillRect(1, 8, 2, 9);
                    g.fillRect(1, 15, 9, 2);
                    break;
                case 3:
                    g.fillRect(1, 1, 9, 2);
                    g.fillRect(8, 1, 2, 9);
                    g.fillRect(1, 8, 9, 2);
                    g.fillRect(8, 8, 2, 9);
                    g.fillRect(1, 15, 9, 2);
                    break;
                case 4:
                    g.fillRect(1, 1, 2, 9);
                    g.fillRect(8, 1, 2, 9);
                    g.fillRect(1, 8, 9, 2);
                    g.fillRect(8, 8, 2, 9);
                    break;
                case 5:
                    g.fillRect(1, 1, 9, 2);
                    g.fillRect(1, 1, 2, 9);
                    g.fillRect(1, 8, 9, 2);
                    g.fillRect(8, 8, 2, 9);
                    g.fillRect(1, 15, 9, 2);
                    break;
                case 6:
                    g.fillRect(1, 1, 9, 2);
                    g.fillRect(1, 1, 2, 9);
                    g.fillRect(1, 8, 9, 2);
                    g.fillRect(1, 8, 2, 9);
                    g.fillRect(8, 8, 2, 9);
                    g.fillRect(1, 15, 9, 2);
                    break;
                case 7:
                    g.fillRect(1, 1, 9, 2);
                    g.fillRect(8, 1, 2, 9);
                    g.fillRect(8, 8, 2, 9);
                    break;
                case 8:
                    g.fillRect(1, 1, 9, 2);
                    g.fillRect(1, 1, 2, 9);
                    g.fillRect(1, 8, 9, 2);
                    g.fillRect(8, 1, 2, 9);
                    g.fillRect(1, 8, 2, 9);
                    g.fillRect(8, 8, 2, 9);
                    g.fillRect(1, 15, 9, 2);
                    break;
                case 9:
                    g.fillRect(1, 1, 9, 2);
                    g.fillRect(1, 1, 2, 9);
                    g.fillRect(1, 8, 9, 2);
                    g.fillRect(8, 1, 2, 9);
                    g.fillRect(8, 8, 2, 9);
                    g.fillRect(1, 15, 9, 2);
                    break;
            }
        }
    }

    private void drawBasic(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //TOP
        g.fillRect(1, 1, 9, 2);
        //UPPER LEFT
        g.fillRect(1, 1, 2, 9);
        //MID
        g.fillRect(1, 8, 9, 2);
        //UPPER RIGHT
        g.fillRect(8, 1, 2, 9);
        //BOTTOM LEFT
        g.fillRect(1, 8, 2, 9);
        //BOTTOM RIGHT
        g.fillRect(8, 8, 2, 9);
        //BOTTOM
        g.fillRect(1, 15, 9, 2);
    }
}
