package View;

import Logic.*;
import Model.Simulator;

import java.awt.*;

public class CarParkView extends AbstractView {

    private Dimension size;
    private Image carParkImage;
    private boolean isReserved;

    /**
     * Constructor for objects of class CarPark
     */
    public CarParkView(Simulator sim) {
        super(sim);
        this.size = new Dimension(0, 0);
    }

    /**
     * Overridden. Tell the GUI manager how big we would like to be.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }

    /**
     * Overridden. The car park view component needs to be redisplayed. Copy the
     * internal image to screen.
     */
    @Override
    public void paintComponent(Graphics g) {
        if (carParkImage == null) {
            return;
        }

        Dimension currentSize = getSize();
        if (size.equals(currentSize)) {
            g.drawImage(carParkImage, 0, 0, null);
        }
        else {
            // Rescale the previous image.
            g.drawImage(carParkImage, 0, 0, currentSize.width, currentSize.height, null);
        }
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public void updateView() {
        // Create a new car park image if the size has changed.
        if (!size.equals(getSize())) {
            size = getSize();
            carParkImage = createImage(size.width, size.height);
        }
        Graphics graphics = carParkImage.getGraphics();
        for(int floor = 0; floor < sim.getNumberOfFloors(); floor++) {
            for(int row = 0; row < sim.getNumberOfRows(); row++) {
                for(int place = 0; place < sim.getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = sim.getCarAt(location);
                    if (row == sim.getNumberOfRows()-1){
                        setIsReserved(true);
                    }
                    else{
                        setIsReserved(false);
                    }


                    Color color ;
                    if(getIsReserved() && car==null){
                        color = Color.black;
                    }
                   else if(car == null){
                        color = Color.white;
                    } else if(car instanceof AdHocCar){
                        color = Color.red;
                    } else if(car instanceof ParkPassCar){
                        color = Color.blue;
                    } else if (car instanceof ReservationCar){
                        color = Color.orange;
                    } else{
                        color = Color.black;
                    }

                    drawPlace(graphics, location, color);
                }
            }
        }
        repaint();
    }

    /**
     * Paint a place on this car park view in a given color.
     */
    private void drawPlace(Graphics graphics, Location location, Color color) {
        graphics.setColor(color);
        graphics.fillRect(
                location.getFloor() * 260 + (1 + (int)Math.floor(location.getRow() * 0.5)) * 75 + (location.getRow() % 2) * 20,
                60 + location.getPlace() * 10,
                20 - 1,
                10 - 1); // TODO use dynamic size or constants
    }
}



