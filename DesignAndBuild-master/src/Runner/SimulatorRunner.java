package Runner;

import Model.*;

/**
 * Main/Runner to create the Parking Garage Simulator
 * @author      327278, 331048, 335364 & 343991
 * @version     13-04-2016
 */

public class SimulatorRunner {
    /**
     * Create a new Simulator
     */
    public static void main(String[] args) {
        new Thread(new Simulator()).start();
    }
}