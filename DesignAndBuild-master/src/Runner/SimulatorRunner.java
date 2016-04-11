package Runner;

import Model.*;

/**
 * @author      327278, 331048, 335364 & 343991
 * @version     07-04-2016
 */

public class SimulatorRunner {
    public static void main(String[] args) {
        // Model.Simulator simulator =
        new Thread(new Simulator()).start();
        // simulator.run();
    }
}