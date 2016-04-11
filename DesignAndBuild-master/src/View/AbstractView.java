package View;

import Model.Simulator;

import javax.swing.*;

public abstract class AbstractView extends JPanel{

    protected Simulator sim;

    protected AbstractView(Simulator sim) {
        this.sim = sim;
        sim.registerView(this);
    }

    public abstract void updateView();
}
