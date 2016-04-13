package View;

import Model.Simulator;
import java.awt.*;

public class CarLineGraphView extends AbstractView {
    private int ticketCars;
    private int parkPassCars;
    private int reservationCars;
    private int totalAmountOfCars;
    final int PAD = 20;

    public CarLineGraphView(Simulator sim) {
        super(sim);
        this.ticketCars = 0;
        this.parkPassCars = 0;
        this.reservationCars = 0;
        this.totalAmountOfCars = ticketCars + parkPassCars + reservationCars;
    }

    // This will set the Dimension of the View
    @Override public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }

    // This will update the view
    @Override public void updateView() {
        sim.countAllCars();
        this.ticketCars = sim.getTotalNumberOfTicketCars();
        this.parkPassCars = sim.getTotalNumberOfParkingPassCars();
        this.reservationCars = sim.getTotalNumberOfReservationCars();
        this.repaint();
    }
    // This will draw a  Line Graph
    @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] data = { this.ticketCars, this.parkPassCars, this.reservationCars };
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        g2.drawLine(PAD, PAD, PAD, h-PAD);
        g2.drawLine(PAD, h-PAD, w-PAD, h-PAD);
        double xScale = (w - 2*PAD)/(data.length + 1);
        double maxValue = 100.0;
        double yScale = (h - 2*PAD)/maxValue;
        // The origin location.
        int x0 = PAD;
        int y0 = h-PAD;
        g2.setPaint(Color.red);
        for(int j = 0; j < data.length; j++) {
            int x = x0 + (int) (xScale * (j + 1));
            int y = y0 - (int) (yScale * data[j]);
            g2.fillOval(x - 2, y - 2, 4, 4);
        }
    }
}
