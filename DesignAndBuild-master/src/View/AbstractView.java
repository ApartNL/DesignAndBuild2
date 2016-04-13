package View;

import Model.Simulator;

import javax.swing.*;

/**
 * This public class creates a abstractview for the JPanel
 * @author      327278, 331048, 335364 & 343991
 * @version     13-04-2016
 */

public abstract class AbstractView extends JPanel{

    protected Simulator sim;

    /*
     * @Param Simulator Sim
     */
    protected AbstractView(Simulator sim) {
        this.sim = sim;
        sim.registerView(this);
    }

    /*
     * This will update the view.
     */
    public abstract void updateView();
}
