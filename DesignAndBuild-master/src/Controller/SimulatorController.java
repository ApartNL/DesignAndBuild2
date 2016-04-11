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
    private JButton oneHourTimeRunButton;
    private JButton dayTickRunButton;

    public SimulatorController(Simulator sim) {

        this.sim = sim;

        oneTimeRunButton = new JButton("Run 1 time");
        hundredTimeRunButton = new JButton("Run 100 times");
        oneHourTimeRunButton = new JButton("Run 1 hour");
        dayTickRunButton = new JButton("Run 1 Day");

        OneTimeRunEvent oneTimeRunEvent = new OneTimeRunEvent();
        oneTimeRunButton.addActionListener(oneTimeRunEvent);

        HundredTimeRunEvent hundredTimeRunEvent = new HundredTimeRunEvent();
        hundredTimeRunButton.addActionListener(hundredTimeRunEvent);

        OneHourTimeRunEvent oneHourTimeRunEvent = new OneHourTimeRunEvent();
        oneHourTimeRunButton.addActionListener(oneHourTimeRunEvent);

        DayTickRunEvent dayTickRunEvent = new DayTickRunEvent();
        dayTickRunButton.addActionListener(dayTickRunEvent);

        setLayout(new BorderLayout());
        oneTimeRunButton.setMinimumSize(new Dimension(100, 50));
        hundredTimeRunButton.setMinimumSize(new Dimension(100, 50));
        oneHourTimeRunButton.setMinimumSize(new Dimension(100, 50));
        dayTickRunButton.setMinimumSize(new Dimension(100, 50));

        add(oneTimeRunButton, BorderLayout.NORTH);
        add(hundredTimeRunButton, BorderLayout.CENTER);
        add(oneHourTimeRunButton, BorderLayout.SOUTH);
        add(dayTickRunButton, BorderLayout.EAST);

        setMinimumSize(new Dimension(100, 100));

    }

    private class OneTimeRunEvent implements ActionListener {
        public void actionPerformed(ActionEvent a){
            sim.singleTick();
        }
    }

    private class HundredTimeRunEvent implements ActionListener {
        public void actionPerformed(ActionEvent b) {
            sim.hundredTicks();
        }
    }

    private class OneHourTimeRunEvent implements  ActionListener {
        public void actionPerformed(ActionEvent c) { sim.oneHour(); }
        }

    private class DayTickRunEvent implements  ActionListener {
        public void actionPerformed(ActionEvent d) { sim.dayTicks(); }
    }
}
