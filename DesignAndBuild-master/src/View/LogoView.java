package View;

/**
 * @author 327278
 * @version 12/04/2016
 */

import javax.swing.*;
import java.awt.*;
import Model.Simulator;

public class LogoView extends AbstractView {
    private ImageIcon logo;
    private JLabel logoLabel;

    /**
     * This creates the Logo of City Parking Groningen for in the SimulatorScreen
     * @param sim Generate Simulator to inherit from
     */
    public LogoView(Simulator sim) {
        super(sim);
        this.logo = new ImageIcon(getClass().getResource("../images/CityParkingGroningen_120x40.png"));
        this.logoLabel = new JLabel(logo);
        this.add(logoLabel);
    }

    @Override public void updateView() {

    }
}
