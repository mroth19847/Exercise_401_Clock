package BL;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.swing.JPanel;

public class Time extends JPanel implements Runnable {

    private Digit[] digits = new Digit[8];
    private ZonedDateTime time;
    private ZoneId zoneid;

    public Time(ZoneId zoneid) {
        this.zoneid = zoneid;
        this.time = ZonedDateTime.now(zoneid);
        this.setBackground(Color.BLACK);
        this.setSize(88, 18);
        this.setLayout(new GridLayout(1, 8));
        for (int i = 0; i < digits.length; i++) {
            if (i == 2 || i == 5) {
                digits[i] = new Digit(true);
            } else {
                digits[i] = new Digit(false);
            }
            this.add(digits[i]);
        }
    }

    @Override
    public void run() {
        while(true){
        try {
            time = ZonedDateTime.now(zoneid);
            drawTimeAsDigits();
            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }
    }

    private void drawTimeAsDigits() throws Exception {
        digits[0].setNumber(time.getHour() / 10);
        digits[1].setNumber(time.getHour() % 10);
        digits[3].setNumber(time.getMinute() / 10);
        digits[4].setNumber(time.getMinute() % 10);
        digits[6].setNumber(time.getSecond() / 10);
        digits[7].setNumber(time.getSecond() % 10);
        for (int i = 0; i < digits.length; i++) {
            digits[i].repaint();
        }
    }

}
