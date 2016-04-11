package Logic;

/**
 * @author      327278, 331048, 335364 & 343991
 * @version     07-04-2016
 */

public class Customer {
    private String name;
    private String address;
    private String postalCode;
    private int amountOfParkingSpots;
    private String startDate;
    private String endDate;
    private String eMailAddress;
    private String licensePlate;

    /**
     * Constructor for the class Logic.Customer.
     */
    public Customer(String name, String address, String postalCode, int amountOfParkingSpots, String startDate, String endDate, String eMailAddress) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.amountOfParkingSpots = amountOfParkingSpots;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eMailAddress = eMailAddress;
    }

    /**
     * Enter a new name for a Logic.Customer.
     * @param name Declare the new name of the Logic.Customer
     */
    public void setCustomerName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the name of the Logic.Customer
     * @return Name
     */
    public String getCustomerName() {
        return name;
    }

    /**
     * Enter a new address for a Logic.Customer.
     * @param address Declare the new address of the Logic.Customer
     */
    public void setCustomerAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieve the address of the Logic.Customer
     * @return Address
     */
    public String getCustomerAddress() {
        return address;
    }

    /**
     * Enter a new postalCode for a Logic.Customer
     * @param postalCode Declare the new postalCode of the Logic.Customer
     */
    public void setCustomerPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Retrieve the postalcode of the Logic.Customer
     * @return postalCode
     */
    public String getCustomerPostalCode() {
        return postalCode;
    }

    /**
     * Enter a new amount of parking spots for a Logic.Customer
     * @param amountOfParkingSpots Declare the new amountOfParkingSpots of the Logic.Customer
     */
    public void setAmountOfParkingSpots(int amountOfParkingSpots) {
        this.amountOfParkingSpots = amountOfParkingSpots;
    }

    /**
     * Retrieve the amount of parking spots of the Logic.Customer
     * @return amountOfParkingSpots
     */
    public int getAmountOfParkingSpots() {
        return amountOfParkingSpots;
    }

    /**
     * Enter a new startdate
     * @param startDate new startdate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Get startdate
     * @return Startdate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Enter a new enddate
     * @param endDate new enddate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Get enddate
     * @return enddate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Enter a new emailaddress
     * @param eMailAddress new emailaddress
     */
    public void setEMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    /**
     * Get emailaddress
     * @return emailaddress
     */
    public String getEMailAddress(){
        return eMailAddress;
    }

    /**
     * Enter license plate
     * @param licensePlate new licensePlate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Get license plate
     * @return license plate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

}