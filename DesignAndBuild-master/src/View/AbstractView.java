package View;

import Model.Simulator;
import javax.swing.*;

/**
 * Class for creating a new abstract view for the simulator
 * @author      327278, 331048, 335364 & 343991
 * @version     13-04-2016
 */
public abstract class AbstractView extends JPanel{

    protected Simulator sim;

    /**
     * Create a new abstract view
     * @param sim the current simulator
     */
    protected AbstractView(Simulator sim) {
        this.sim = sim;
        sim.registerView(this);
    }

    /**
     * Create a new method that the fields inheriting abstractView have to use
     */
    public abstract void updateView();
}
