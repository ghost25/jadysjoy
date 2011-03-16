package com.dabis.trimsalon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dabis.trimsalon.ui.TrimsalonKlantFrame;

public class DeTrimsalon {

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI(ApplicationContext context) {
        //Create and set up the window.
		TrimsalonKlantFrame lbw = new TrimsalonKlantFrame(context);
		lbw.setLocationRelativeTo(null);
		lbw.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext factory = 
                	new ClassPathXmlApplicationContext("applicationContext.xml");
                createAndShowGUI(factory);
            }
        });
    }
}
