package View;

import Model.Simulator;

import java.awt.*;

public class CarPieView extends AbstractView {

    private int adhocCars;
    private int parkpassCars;
    private int reservationCars;

    public CarPieView(Simulator sim) {
        super(sim);
        this.adhocCars = 0;
        this.parkpassCars = 0;
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
        this.adhocCars = sim.getTotalNumberOfTicketCars();
        this.parkpassCars = sim.getTotalNumberOfParkingPassCars();
        this.reservationCars = sim.getTotalNumberOfReservationCars();
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int totalAmountOfCars = this.adhocCars + this.reservationCars + this.parkpassCars;
        float percentageAdhoc = totalAmountOfCars <= 0 || this.adhocCars <= 0 ? 0 : totalAmountOfCars/adhocCars * 100;
        float percentageReservation = totalAmountOfCars <= 0 || this.reservationCars <= 0 ? 0 :totalAmountOfCars/reservationCars * 100;
        float percentageParkpass = totalAmountOfCars <= 0 || this.parkpassCars <= 0 ? 0 :totalAmountOfCars/parkpassCars * 100;

        float adhocAngle = totalAmountOfCars <= 0 || this.adhocCars <= 0 ? 0 : 360*percentageAdhoc;
        float parkpassAngle = totalAmountOfCars <= 0 || this.parkpassCars <= 0 ? 0 : 360*percentageParkpass;
        float reservationAngle = totalAmountOfCars <= 0 || this.reservationCars <= 0 ? 0 : 360*percentageReservation;

        Dimension prefSize = this.getPreferredSize();
        g.setColor(Color.WHITE);
        g.fillRect(prefSize.width/2, prefSize.height/2, 200, 200);

        g.setColor(Color.BLACK);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, 0, 360);
        g.setColor(Color.RED);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, 0, (int)adhocAngle);
        g.setColor(Color.BLUE);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, (int)adhocAngle, (int)parkpassAngle);
        g.setColor(Color.ORANGE);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, (int)parkpassAngle, (int)reservationAngle);

        /*
        int aantal=getModel().getAantal();
        g.setColor(Color.BLUE);
        g.fillArc(10, 10, 180, 180, 0, aantal);
        */
    }
}
