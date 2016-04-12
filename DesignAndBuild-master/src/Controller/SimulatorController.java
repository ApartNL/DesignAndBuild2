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
//creating JButtons
    private JButton oneTimeRunButton;
    private JButton hundredTimeRunButton;
    private JButton oneHourTimeRunButton;
    private JButton dayTickRunButton;
    private JButton fullRunButton;


    public SimulatorController(Simulator sim) {

        this.sim = sim;

        oneTimeRunButton = new JButton("Run 1 time");
        hundredTimeRunButton = new JButton("Run 100 times");
        oneHourTimeRunButton = new JButton("Run 1 hour");
        dayTickRunButton = new JButton("Run 1 Day");
        fullRunButton = new JButton("Start Running");



        OneTimeRunEvent oneTimeRunEvent = new OneTimeRunEvent();
        oneTimeRunButton.addActionListener(oneTimeRunEvent);

        HundredTimeRunEvent hundredTimeRunEvent = new HundredTimeRunEvent();
        hundredTimeRunButton.addActionListener(hundredTimeRunEvent);

        OneHourTimeRunEvent oneHourTimeRunEvent = new OneHourTimeRunEvent();
        oneHourTimeRunButton.addActionListener(oneHourTimeRunEvent);

        DayTickRunEvent dayTickRunEvent = new DayTickRunEvent();
        dayTickRunButton.addActionListener(dayTickRunEvent);

        FullRunEvent fullRunEvent = new FullRunEvent();
        fullRunButton.addActionListener(fullRunEvent);



//setting preferred size of the buttons
        setLayout(new BorderLayout());
        oneTimeRunButton.setMinimumSize(new Dimension(100, 50));
        hundredTimeRunButton.setMinimumSize(new Dimension(100, 50));
        oneHourTimeRunButton.setMinimumSize(new Dimension(100, 50));
        dayTickRunButton.setMinimumSize(new Dimension(100, 50));
        fullRunButton.setMinimumSize(new Dimension(100, 50));

//position of the buttons
        add(oneTimeRunButton, BorderLayout.LINE_START);
        add(hundredTimeRunButton, BorderLayout.LINE_END);
        add(oneHourTimeRunButton, BorderLayout.CENTER);
        add(dayTickRunButton, BorderLayout.SOUTH);
        add(fullRunButton, BorderLayout.NORTH);

        setMinimumSize(new Dimension(100, 100));
//adding actions to the buttons making them able to be used.
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

    private class FullRunEvent implements  ActionListener {
        public void actionPerformed(ActionEvent e) { sim.fullRun(); }
    }

}
