package Runner;

import Model.*;

/**
 *
 * @author      327278, 331048, 335364 & 343991
 * @version     13-04-2016
 */

public class SimulatorRunner {
    public static void main(String[] args) {
        new Thread(new Simulator()).start();
    }
}