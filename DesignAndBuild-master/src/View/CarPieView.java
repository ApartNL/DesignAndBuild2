package View;

import Model.Simulator;

import java.awt.*;

public class CarPieView extends AbstractView {

    private int ticketCars;
    private int parkPassCars;
    private int reservationCars;
    private int totalAmountOfCars;
    private double onePercent;

    public CarPieView(Simulator sim) {
        super(sim);
        this.ticketCars = 0;
        this.parkPassCars = 0;
        this.reservationCars = 0;

    }

    /**
     * Overridden. Tell the GUI manager how big we would like to be.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }

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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(totalAmountOfCars > 0) {
            // Calculate percentages
            float percentageTicket = totalAmountOfCars <= 0 || this.ticketCars <= 0 ? 0 : (float) (onePercent * this.ticketCars);
            float percentageParkPass = totalAmountOfCars <= 0 || this.parkPassCars <= 0 ? 0 : (float) (onePercent * this.parkPassCars);
            float percentageReservation = totalAmountOfCars <= 0 || this.reservationCars <= 0 ? 0 : (float) (onePercent * this.reservationCars);
            // Calculate one percent
            double calc = 3.6;
            // Calculate arcAngle
            float ticketAngle = totalAmountOfCars <= 0 || this.ticketCars <= 0 ? 0 : (float) calc * percentageTicket;
            float parkPassAngle = totalAmountOfCars <= 0 || this.parkPassCars <= 0 ? 0 : (float) calc * percentageParkPass;
            float reservationAngle = totalAmountOfCars <= 0 || this.reservationCars <= 0 ? 0 : (float) calc * percentageReservation;
            // Set view dimensions
            Dimension prefSize = this.getPreferredSize();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 800, 500);
            // Default Colour
            g.setColor(Color.BLACK);
            g.fillArc(prefSize.width / 2 + 10, prefSize.height / 2 + 10, 180, 180, 0, 360);
            // Set Colour depending on Car type and Percentage
            g.setColor(Color.RED);
            g.fillArc(prefSize.width / 2 + 10, prefSize.height / 2 + 10, 180, 180, 0, (int) ticketAngle);
            g.setColor(Color.BLUE);
            g.fillArc(prefSize.width / 2 + 10, prefSize.height / 2 + 10, 180, 180, (int) ticketAngle, (int) parkPassAngle);
            g.setColor(Color.ORANGE);
            g.fillArc(prefSize.width / 2 + 10, prefSize.height / 2 + 10, 180, 180, (int) ticketAngle + (int) parkPassAngle, (int) reservationAngle);
            // Draw labels for the different types of Cars with percentages
            g.setColor(Color.BLACK);
            g.drawString("Tickets: " + (Float.toString((int)percentageTicket) + "%"), 460, 200);
            g.drawString("ParkingPass: " + (Float.toString((int)percentageParkPass) + "%"), 460, 220);
            g.drawString("Reservations: " + (Float.toString((int)percentageReservation) + "%"), 460, 240);
        } else {

        }
        /*
        int aantal=getModel().getAantal();
        g.setColor(Color.BLUE);
        g.fillArc(10, 10, 180, 180, 0, aantal);
        */
    }
}
