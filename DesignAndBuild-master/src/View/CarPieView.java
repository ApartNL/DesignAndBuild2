package View;

import Model.Simulator;

import java.awt.*;

public class CarPieView extends AbstractView {

    private int ticketCars;
    private int parkPassCars;
    private int reservationCars;

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
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int totalAmountOfCars = this.ticketCars + this.parkPassCars + this.ticketCars;
        // Percentage berekenen
        float percentageTicket = totalAmountOfCars <= 0 || this.ticketCars <= 0 ? 0 : totalAmountOfCars/ticketCars * 100;
        float percentageParkPass = totalAmountOfCars <= 0 || this.parkPassCars <= 0 ? 0 : totalAmountOfCars/parkPassCars * 100;
        float percentageReservation = totalAmountOfCars <= 0 || this.reservationCars <= 0 ? 0 : totalAmountOfCars/reservationCars * 100;

        // Hoek berekenen
        float ticketAngle = totalAmountOfCars <= 0 || this.ticketCars <= 0 ? 0 : 360/100*percentageTicket;
        float parkPassAngle = totalAmountOfCars <= 0 || this.parkPassCars <= 0 ? 0 : 360/100*percentageParkPass;
        float reservationAngle = totalAmountOfCars <= 0 || this.reservationCars <= 0 ? 0 : 360/100*percentageReservation;

        Dimension prefSize = this.getPreferredSize();
        g.setColor(Color.WHITE);
        g.fillRect(prefSize.width/2, prefSize.height/2, 200, 200);

        // Default Colour
        g.setColor(Color.BLACK);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, 0, 360);

        // Set Colour depending on Car type and Percentage
        g.setColor(Color.RED);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, 0,(int)ticketAngle);
        g.setColor(Color.BLUE);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, (int)ticketAngle, (int)parkPassAngle);
        g.setColor(Color.ORANGE);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, (int)parkPassAngle + (int)ticketAngle, (int)reservationAngle);

        /*
        int aantal=getModel().getAantal();
        g.setColor(Color.BLUE);
        g.fillArc(10, 10, 180, 180, 0, aantal);
        */
    }
}
