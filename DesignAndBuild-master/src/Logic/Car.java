package Logic;

/**
 *
 * @author      327278, 331048, 335364 & 343991
 * @version     13-04-2016
 */

public abstract class Car {
    private Location location;
    private int minutesLeft;
    private boolean isPaying;

    /**
     * Constructor for objects of class Logic.Car
     */
    public Car() {

    }

    /**
     * Method to retrieve the current Logic.Location of a Logic.Car.
     * @return  The current Logic.Location of the current Logic.Car, based on the Logic.Location class.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Method to set a new Logic.Location for a Logic.Car.
     * @param location Define a new Logic.Location for the current Logic.Car (based on an existing Logic.Location).
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Method to retrieve the parking time a parked Logic.Car still has remaining.
     * @return  The amount of parking time the current Logic.Car still has.
     */
    public int getMinutesLeft() {
        return minutesLeft;
    }

    /**
     * Method to change the parking time of a parked Logic.Car.
     * @param minutesLeft Define the amount of minutes to set minutesLeft to.
     */
    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }

    /**
     * Method to check if a ticket is being paid for.
     * @return Return 'true' if being paid for, return 'false' if not being paid for.
     */
    public boolean getIsPaying() {
        return isPaying;
    }

    /**
     * Method to change the value of the isPaying boolean.
     * @param isPaying  Define the new value. True means 'Yes', False means 'No'.
     */
    public void setIsPaying(boolean isPaying) {
        this.isPaying = isPaying;
    }

    /**
     * Method to decrease the time a parked Logic.Car has remaining.
     */
    public void tick() {
        minutesLeft--;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "location=" + location +
                ", minutesLeft=" + minutesLeft +
                ", isPaying=" + isPaying +
                '}';
    }
}