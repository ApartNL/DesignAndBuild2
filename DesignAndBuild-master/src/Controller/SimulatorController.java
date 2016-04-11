package Controller;

import Model.Simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author      327278, 331048, 335364 & 343991
 * @version     07-04-2016
 */

public class SimulatorController extends JPanel {

    private Simulator sim;

    private JButton oneTimeRunButton;
    private JButton hundredTimeRunButton;

    public SimulatorController(Simulator sim) {

        this.sim = sim;

        oneTimeRunButton = new JButton("Run 1 time");
        hundredTimeRunButton = new JButton("Run 100 times");

        OneTimeRunEvent oneTimeRunEvent = new OneTimeRunEvent();
        oneTimeRunButton.addActionListener(oneTimeRunEvent);

        HundredTimeRunEvent hundredTimeRunEvent = new HundredTimeRunEvent();
        hundredTimeRunButton.addActionListener(hundredTimeRunEvent);

        setLayout(new BorderLayout());
        oneTimeRunButton.setMinimumSize(new Dimension(100, 50));
        hundredTimeRunButton.setMinimumSize(new Dimension(100, 50));
        add(oneTimeRunButton, BorderLayout.NORTH);
        add(hundredTimeRunButton, BorderLayout.AFTER_LAST_LINE);
        setMinimumSize(new Dimension(100, 100));

    }

    private class OneTimeRunEvent implements ActionListener {
        public void actionPerformed(ActionEvent a){
            sim.singleTick();
        }
    }

    private class HundredTimeRunEvent implements ActionListener {
        public void actionPerformed(ActionEvent b){
            sim.hundredTicks();
        }
    }
}
