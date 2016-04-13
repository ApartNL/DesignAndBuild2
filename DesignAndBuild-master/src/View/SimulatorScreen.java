package View;

import javax.swing.*;
import java.awt.*;

import Controller.SimulatorController;
import Model.*;

/**
 *
 * @author      327278, 331048, 335364 & 343991
 * @version     13-04-2016
 */

public class SimulatorScreen extends JFrame {

    private Simulator sim;
    private Container container;
    private Image im = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("src/Images/CityParkingIcon.png"));

    /**
     * Constructor for the
     * @param sim
     */
    public SimulatorScreen( Simulator sim) {

        this.sim = sim;

        this.container = getContentPane();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200, 720));

        this.setLayout(new BorderLayout());
        this.setTitle("City Parking Groningen - Simulator");
        this.setIconImage(im);

        this.setResizable(false);

        // Create new views
        CarParkView carParkView = new CarParkView(sim);
        CarPieView carPieView = new CarPieView(sim);
        CarLineGraphView carLineGraphView = new CarLineGraphView(sim);
        InformationView informationView = new InformationView(sim);
        LogoView logoView = new LogoView(sim);
        SimulatorController simulatorController = new SimulatorController(sim);

        JPanel tabbedViewPanel = new JPanel();
        JTabbedPane tabContainer = new JTabbedPane();
        tabContainer.addTab("Simulator", carParkView);
        tabContainer.addTab("Pie Chart", carPieView);
        tabContainer.addTab("Line Graph", carLineGraphView);

        tabbedViewPanel.add(tabContainer);

        JPanel eastContainerPanel = new JPanel();
        eastContainerPanel.setLayout(new BorderLayout());
        eastContainerPanel.add(simulatorController, BorderLayout.NORTH);
        eastContainerPanel.add(informationView, BorderLayout.SOUTH);
        eastContainerPanel.add(logoView, BorderLayout.CENTER);

        container.add(tabbedViewPanel, BorderLayout.CENTER);
        container.add(eastContainerPanel, BorderLayout.EAST);

        pack();
        setVisible(true);
    }
}