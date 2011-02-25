package com.dabis.trimsalon;

import com.dabis.trimsalon.ui.TrimsalonOpmerkingenFrame;
import com.dabis.trimsalon.utils.HibernateUtil;

public class DeTrimsalon {

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
		TrimsalonOpmerkingenFrame lbw = new TrimsalonOpmerkingenFrame();
		lbw.setLocationRelativeTo(null);
		lbw.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		HibernateUtil.setDB("PROD");
                createAndShowGUI();
            }
        });
    }
}
