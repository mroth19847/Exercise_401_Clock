package BL;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.swing.JPanel;

public class Clock extends JPanel implements Runnable {

    private ZonedDateTime time;
    private ZoneId zoneid;

    public Clock(ZoneId zoneid) {
        this.zoneid = zoneid;
        this.time = ZonedDateTime.now(zoneid);
        repaint();
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.time = ZonedDateTime.now(zoneid);
                repaint();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics gd) {
        super.paint(gd);
        Graphics2D g = (Graphics2D) gd;
        g.setColor(Color.GRAY);
        g.fillOval(25, 25, 150, 150);
        
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(5));
        g.drawOval(26, 26, 150, 150);
        g.setStroke(new BasicStroke(1));

        g.drawString("12", 93, 45);
        g.drawString("3", 161, 105);
        g.drawString("6", 98, 168);
        g.drawString("9", 34, 105);


        for (int i = 0; i < 60; i++) {
            g.setColor(Color.DARK_GRAY);
            if(i%5 == 0) g.setColor(Color.WHITE);
            double fx = 100 + 70 * Math.cos((i - 15) * 6 * Math.PI / 180);
            double fy = 100 + 70 * Math.sin((i - 15) * 6 * Math.PI / 180);
            g.fillOval((int) fx, (int) fy, 2, 2);
        }

        //Seconds
        g.setColor(Color.RED);
        double fx = 100 + 70 * Math.cos((time.getSecond() - 15) * 6 * Math.PI / 180);
        double fy = 100 + 70 * Math.sin((time.getSecond() - 15) * 6 * Math.PI / 180);
        g.drawLine(100, 100, (int) fx, (int) fy);

        //Minutes
        g.setColor(Color.BLUE);
        fx = 100 + 55 * Math.cos((time.getMinute() - 15) * 6 * Math.PI / 180);
        fy = 100 + 55 * Math.sin((time.getMinute() - 15) * 6 * Math.PI / 180);
        g.setStroke(new BasicStroke(2));
        g.drawLine(100, 100, (int) fx, (int) fy);

        //Hours
        g.setColor(Color.GREEN);
        int hHour = time.getHour();
        if(hHour > 12) hHour -= 12;
        fx = 100 + 35 * Math.cos((hHour - 3) * 30 * Math.PI / 180);
        fy = 100 + 35 * Math.sin((hHour - 3) * 30 * Math.PI / 180);
        g.setStroke(new BasicStroke(3));
        g.drawLine(100, 100, (int) fx, (int) fy);

        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(1));
        g.fillOval(96, 96, 8, 8);
    }

}
