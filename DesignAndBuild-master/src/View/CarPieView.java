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
        float percentageAdHoc = totalAmountOfCars <= 0 || this.adhocCars <= 0 ? 0 : totalAmountOfCars/adhocCars * 100;
        float percentageReservation = totalAmountOfCars <= 0 || this.reservationCars <= 0 ? 0 :totalAmountOfCars/reservationCars * 100;
        float percentageParkPass = totalAmountOfCars <= 0 || this.parkpassCars <= 0 ? 0 :totalAmountOfCars/parkpassCars * 100;

        float adHocAngle = totalAmountOfCars <= 0 || this.adhocCars <= 0 ? 0 : 360/percentageAdHoc*100;
        float parkPassAngle = totalAmountOfCars <= 0 || this.parkpassCars <= 0 ? 0 : 360/percentageParkPass*100;
        float reservationAngle = totalAmountOfCars <= 0 || this.reservationCars <= 0 ? 0 : 360/percentageReservation*100;

        Dimension prefSize = this.getPreferredSize();
        g.setColor(Color.WHITE);
        g.fillRect(prefSize.width/2, prefSize.height/2, 200, 200);

        //g.setColor(Color.BLACK);
        //g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, 0, 360);
        g.setColor(Color.RED);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, 0,(int)adHocAngle);
        g.setColor(Color.BLUE);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, (int)adHocAngle, (int)parkPassAngle);
        g.setColor(Color.ORANGE);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, (int)parkPassAngle, (int)reservationAngle);
        g.setColor(Color.WHITE);
        g.fillArc(prefSize.width/2 + 10, prefSize.height/2 + 10, 180, 180, (int) reservationAngle, 0);

        /*
        int aantal=getModel().getAantal();
        g.setColor(Color.BLUE);
        g.fillArc(10, 10, 180, 180, 0, aantal);
        */
    }
}
