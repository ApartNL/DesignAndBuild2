package View;

import javax.swing.*;
import java.awt.*;

import Controller.SimulatorController;
import Logic.*;
import Model.*;

/**
 * @author      327278, 331048, 335364 & 343991
 * @version     07-04-2016
 */

public class SimulatorScreen extends JFrame {

    private Simulator sim;
    private Container container;

    public SimulatorScreen( Simulator sim) {

        this.sim = sim;

        this.container = getContentPane();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200, 800));

        this.setLayout(new BorderLayout());

        CarParkView carParkView = new CarParkView(sim);
        CarPieView carPieView = new CarPieView(sim);
        InformationView informationView = new InformationView(sim);
        SimulatorController simulatorController = new SimulatorController(sim);

        JPanel tabbedViewPanel = new JPanel();
        JTabbedPane tabContainer = new JTabbedPane();
        tabContainer.addTab("Parking Space", carParkView);
        tabContainer.addTab("#Cars Pie chart", carPieView);

        tabbedViewPanel.add(tabContainer);

        JPanel eastContainerPanel = new JPanel();
        eastContainerPanel.setLayout(new BorderLayout());
        eastContainerPanel.add(simulatorController, BorderLayout.NORTH);
        eastContainerPanel.add(informationView, BorderLayout.SOUTH);

        container.add(tabbedViewPanel, BorderLayout.CENTER);
        container.add(eastContainerPanel, BorderLayout.EAST);

        pack();
        setVisible(true);
    }
}