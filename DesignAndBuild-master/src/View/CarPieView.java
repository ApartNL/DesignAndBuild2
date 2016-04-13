package View;

import Model.*;
import java.math.BigDecimal;
import java.awt.*;

/**
 * Class for creating a new Pie Chart to read the amount of Cars in percentages
 * @author      327278, 331048, 335364 & 343991
 * @version     13-04-2016
 */

public class CarPieView extends AbstractView {

    private int ticketCars;
    private int parkPassCars;
    private int reservationCars;
    private int totalAmountOfCars;
    private double onePercent;

    /**
     * Constructor for a new CarPieView
     * @param sim select the current simulatr.
     */
    public CarPieView(Simulator sim) {
        super(sim);
        this.ticketCars = 0;
        this.parkPassCars = 0;
        this.reservationCars = 0;

    }

    /**
     * Overridden from superClass. Set how big the new dimensions should be.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }

    /**
     * Overriden from superClass. Update the view with the data this class requires to be shown.
     */
    @Override
    public void updateView() {
        sim.countAllCars();
        this.ticketCars = sim.getTotalNumberOfTicketCars();
        this.parkPassCars = sim.getTotalNumberOfParkingPassCars();
        this.reservationCars = sim.getTotalNumberOfReservationCars();
        this.totalAmountOfCars = ticketCars + parkPassCars + reservationCars;
        if(totalAmountOfCars > 0) {
            this.onePercent = 100.0 / totalAmountOfCars;
        } else {
            this.onePercent = 100.0;
        }
        this.repaint();
    }

    /**
     * Method to round off a double to two decimals.
     * @param d             The double you want to give less decimals
     * @param decimalPlace  Integer value for how many decimals you want.
     * @return
     */
    public static float round(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    /**
     * Method to create the Pie Chart view and display the variables of the amount of cars and their types in the parking garage.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(totalAmountOfCars > 0) {
            // Calculate percentages
            double percentageTicket = onePercent * this.ticketCars;
            double percentageParkPass = onePercent * this.parkPassCars;
            double percentageReservation = onePercent * this.reservationCars;
            // Calculate one percent
            double calc = 3.6;
            // Calculate arcAngle
            double ticketAngle = calc * percentageTicket;
            double parkPassAngle = calc * percentageParkPass;
            double reservationAngle = calc * percentageReservation;
            // Set view dimensions
            Dimension prefSize = this.getPreferredSize();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 800, 500);
            // Default Colour
            g.setColor(Color.RED);
            g.fillArc(prefSize.width / 2 + 10, prefSize.height / 2 + 10, 180, 180, 0, 360);
            // Set Colour depending on Car type and Percentage and draw a Label
            g.setColor(Color.RED);
            g.drawString("Tickets: ", 460, 200);
            g.fillArc(prefSize.width / 2 + 10, prefSize.height / 2 + 10, 180, 180, 0, (int) ticketAngle);
            g.setColor(Color.BLUE);
            g.drawString("ParkingPass: ", 460, 230);
            g.fillArc(prefSize.width / 2 + 10, prefSize.height / 2 + 10, 180, 180, (int) ticketAngle, (int) parkPassAngle);
            g.setColor(Color.ORANGE);
            g.drawString("Reservations: ", 460, 260);
            g.fillArc(prefSize.width / 2 + 10, prefSize.height / 2 + 10, 180, 180, (int) ticketAngle + (int) parkPassAngle, (int) reservationAngle);
            // Draw labels for the different types of Cars with percentages
            g.setColor(Color.BLACK);
            g.drawString((round(percentageTicket, 2) + "%"), 460, 215);
            g.drawString((round(percentageParkPass, 2) + "%"), 460, 245);
            g.drawString((round(percentageReservation, 2) + "%"), 460, 275);

        } else {

        }
    }
}
