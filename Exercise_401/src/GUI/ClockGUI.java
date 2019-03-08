package GUI;

import BL.Clock;
import BL.Time;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.ZoneId;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockGUI extends javax.swing.JFrame {

    private Time localTime = new Time(ZoneId.of("Europe/Vienna"));
    private Time sydney = new Time(ZoneId.of("Australia/Sydney"));
    private Time la = new Time(ZoneId.of("America/Los_Angeles"));

    
    public ClockGUI() {
        initComponents();
        paTime.setLayout(new GridLayout(3, 2));
        //Local Time
        JLabel title1 = new JLabel("  Local Time: ");
        title1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        title1.setForeground(Color.WHITE);
        paTime.add(title1);
        paTime.add(localTime);
        new Thread(localTime).start();
        //Sydney
        JLabel title2 = new JLabel("  Sydney: ");
        title2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        title2.setForeground(Color.WHITE);
        paTime.add(title2);
        paTime.add(sydney);
        new Thread(sydney).start();
        //LA
        JLabel title3 = new JLabel("  Los Angeles: ");
        title3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        title3.setForeground(Color.WHITE);
        paTime.add(title3);
        paTime.add(la);
        new Thread(la).start();
        
        //Clock
        JPanel paClock = new Clock(ZoneId.of("Europe/Vienna"));
        paClock.setBackground(new java.awt.Color(0, 0, 0));
        paClock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        paClock.setMaximumSize(new java.awt.Dimension(200, 200));
        paClock.setMinimumSize(new java.awt.Dimension(200, 200));
        paClock.setPreferredSize(new java.awt.Dimension(200, 200));
        getContentPane().add(paClock, java.awt.BorderLayout.LINE_END);
        new Thread((Runnable) paClock).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paTime = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        paTime.setBackground(new java.awt.Color(0, 0, 0));
        paTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        paTime.setMaximumSize(new java.awt.Dimension(600, 200));
        paTime.setMinimumSize(new java.awt.Dimension(600, 200));
        paTime.setPreferredSize(new java.awt.Dimension(600, 200));

        javax.swing.GroupLayout paTimeLayout = new javax.swing.GroupLayout(paTime);
        paTime.setLayout(paTimeLayout);
        paTimeLayout.setHorizontalGroup(
            paTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paTimeLayout.setVerticalGroup(
            paTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        getContentPane().add(paTime, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClockGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel paTime;
    // End of variables declaration//GEN-END:variables

}
