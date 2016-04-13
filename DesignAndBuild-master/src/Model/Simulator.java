package Model;

import Logic.*;
import View.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author      327278, 331048, 335364 & 343991
 * @version     13-04-2016
 */

public class Simulator implements Runnable{

    private static final int NUMBER_OF_FLOORS = 3;
    private static final int NUMBER_OF_ROWS = 6;
    private static final int NUMBER_OF_PLACES = 30;

    private List<AbstractView> simulatorViews;
    private SimulatorScreen simulatorScreen;

    private Car[][][] cars;

    private CarQueue entranceCarQueue;
    private CarQueue specialEntranceCarQueue;
    private CarQueue specialExitCarQueue;
    private CarQueue paymentCarQueue;
    private CarQueue exitCarQueue;

    private PaymentMachine paymentMachine;

    private boolean running;

    private int ticksToDo;


    private int day = 0;
    private int hour = 0;
    private int minute = 0;

    private int tickPause = 100;

    private int weekDayArrivals= 50; // average number of arriving cars per hour
    private int weekendArrivals = 60; // average number of arriving cars per hour
    private int Concert = 300; // average number of arriving cars per hour
    private int atNight = 1; // average number of arriving cars per hour
    private int shoppingNight = 100;
    private int atNightconcert = 3; // average number of arriving cars per hour

    private int enterSpeed = 10; // number of cars that can enter per minute
    private int paymentSpeed = 10; // number of cars that can pay per minute
    private int exitSpeed = 10; // number of cars that can leave per minute
    private int stayMinutes = 0;


    private int numberOfFloors;
    private int numberOfRows;
    private int numberOfPlaces;

    private int totalNumberOfCars;
    private int totalNumberOfTicketCars;
    private int totalNumberOfParkingPassCars;
    private int totalNumberOfReservationCars;


    private Random random;


    public Simulator() {
        simulatorViews = new LinkedList<AbstractView>();

        entranceCarQueue = new CarQueue();
        paymentCarQueue = new CarQueue();
        exitCarQueue = new CarQueue();

        specialEntranceCarQueue = new CarQueue();
        specialExitCarQueue = new CarQueue();

        paymentMachine = new PaymentMachine();

        random = new Random();

        simulatorScreen = new SimulatorScreen(this);

        numberOfFloors = Simulator.NUMBER_OF_FLOORS;
        numberOfRows   = Simulator.NUMBER_OF_ROWS;
        numberOfPlaces = Simulator.NUMBER_OF_PLACES;

        cars = new Car[numberOfFloors][numberOfRows][numberOfPlaces];

        ticksToDo = 0;

        day = 2;
        hour = 18;
        minute = 0;

        running = false;
    }

    public void oneHour() {
        ticksToDo += 60;
    }

    public void dayTicks() {
        ticksToDo += 1440;
    }

    public void hundredTicks() {
        ticksToDo += 100;
    }

    public void singleTick() {
        ticksToDo++;
    }

    public void fullRun() { ticksToDo +=40320;}


    public void run() {
        running = true;
        try{
            while(running){
                while(ticksToDo > 0) {
                    tick();
                    ticksToDo--;
                }
                Thread.sleep(1000);
            }
        } catch(InterruptedException ex){
            System.err.println(ex);
        }
    }

    public int getstayMinutes() {
        Random r = new Random();
        int Low = 30;
        int High = 40;
        int Result = r.nextInt(High-Low);

        if (hour >21){
            stayMinutes = (15 + Result);
        }
        else{
            stayMinutes = (int)  (15 + random.nextFloat() * 10 * 60);
        }
        return stayMinutes;
    }

    public void tick() {
        // Advance the time by one minute.
        minute++;
        while (minute > 59) {
            minute -= 60;
            hour++;
        }
        while (hour > 23) {
            hour -= 24;
            day++;
        }
        while (day > 6) {
            day -= 7;
        }



        // Get the average number of cars that arrive per hour.




        int averageNumberOfCarsPerHour = 0;
        if(hour == 19 && day >=4 && day <= 6) {
            averageNumberOfCarsPerHour = Concert;
        }
        else if((day == 5 || day == 6) && hour >6 && hour <19 ) {
            averageNumberOfCarsPerHour = weekendArrivals;
        }
        else if(day > 3 && day <7 && (hour > 22 || hour <6)) {
            averageNumberOfCarsPerHour = atNightconcert;
        }
        else if(hour >= 18 && hour<20 && day == 3 ) {
            averageNumberOfCarsPerHour = shoppingNight;
        }
        else if(day >= 0 && day <=3 && hour > 18 && hour <6){
            averageNumberOfCarsPerHour = atNight;
        }
        else{
            averageNumberOfCarsPerHour = weekDayArrivals;
        }








        // Calculate the number of cars that arrive this minute.
        double standardDeviation = averageNumberOfCarsPerHour * 0.1;
        double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
        int numberOfCarsPerMinute = (int)Math.round(numberOfCarsPerHour / 60);


        // Add the cars to the back of the queue.
        for (int i = 0; i < numberOfCarsPerMinute; i++) {
            double randomD = random.nextDouble();
            System.out.println("RandomD : " + randomD);
            if (randomD <= 0.15){
                Car reservedCar = new ReservationCar();
                specialEntranceCarQueue.addCar(reservedCar);
                paymentMachine.pay(reservedCar);
            } else if(randomD >= 0.16 && randomD <=0.33){
                System.out.println("Adding parkpass car!");
                entranceCarQueue.addCar(new ParkPassCar());
            } else {
                entranceCarQueue.addCar(new AdHocCar());
            }
        }

        // Remove car from the front of the queue and assign to a parking space.

        int normalCars = 0;
        int specialCars = 0;
        boolean normalCarsDone = false;
        boolean specialCarsDone = false;
        for (int i = 0; i < enterSpeed; i++) {
            if(!( normalCars < enterSpeed ))
                normalCarsDone = true;
            if(!( specialCars < enterSpeed ))
                specialCarsDone = true;

            if((random.nextBoolean() || !normalCarsDone )&& (entranceCarQueue.peek() != null)){
                Car normalCar = entranceCarQueue.peek();
                // Find a space for this car.
                if(this.parkCarAtRandomLocation(normalCar)){
                    entranceCarQueue.removeCar();
                    normalCars++;
                }
            } else if((specialEntranceCarQueue.peek() != null)) {
                Car specialCar = specialEntranceCarQueue.peek();
                if(this.parkCarAtReservedLocation(specialCar)){
                    specialEntranceCarQueue.removeCar();
                    specialCars++;
                }
            }

            if(normalCarsDone && specialCarsDone) {
                break;
            }
        }

        // Perform car park tick.
        for (int floor = 0; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = getCarAt(location);
                    if (car != null) {
                        car.tick();
                    }
                }
            }
        }

        // Add leaving cars to the exit queue.
        Car car;
        while ((car = getAndRemoveFirstLeavingCar()) != null) {
            if(car instanceof AdHocCar){
                car.setIsPaying(true);
                paymentCarQueue.addCar(car);
            } else if (car instanceof ParkPassCar){
                specialExitCarQueue.addCar(car);
            } else if (car instanceof ReservationCar){
                specialExitCarQueue.addCar(car);
            }
        }

        // Let cars pay.
        for (int i = 0; i < paymentSpeed && paymentCarQueue.peek() != null; i++) {
            car = paymentCarQueue.removeCar();
            paymentMachine.pay(car); //TODO: Do something with the bool.
            removeCarAt(car.getLocation());
            exitCarQueue.addCar(car);
        }



            // Let cars leave.
            for (int i = 0; i < exitSpeed; i++) {
                // Bye!
                if (exitCarQueue.peek() != null)
                    exitCarQueue.removeCar();
                if ((car = specialExitCarQueue.peek()) != null)
                    if (car instanceof ParkPassCar)
                        paymentMachine.pay(car);
                specialExitCarQueue.removeCar();
            }


        // Update the views
        this.updateViews();

        // Pause.
        try {
            Thread.sleep(tickPause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void registerView(AbstractView viewToAdd) {
        this.simulatorViews.add(viewToAdd);
    }


    public boolean parkCarAtRandomLocation(Car car){
        Location freeLocation = getRandomFreeLocation();
        if (freeLocation != null) {
            int stayMinutes = getstayMinutes();
            car.setMinutesLeft(stayMinutes);
            System.out.println("parking car : " + car);
            return setCarAt (freeLocation, car);
        }
        return false;
    }

    public boolean parkCarAtReservedLocation(Car car){
        Location freeLocation = getReservedFreeLocation();
        if (freeLocation != null) {
            int stayMinutes = getstayMinutes();
            car.setMinutesLeft(stayMinutes);
            System.out.println("parking car : " + car);
            return setCarAt (freeLocation, car);
        }
        return false;
    }

    public void updateViews(){
        for(AbstractView view : simulatorViews){
            view.updateView();
        }
    }

    public  String getDay() {
        String dayString ="";
        switch (day){
            case 0: dayString = "Monday";
                break;
            case 1: dayString = "Tuesday";
                break;
            case 2: dayString = "Wednesday";
                break;
            case 3: dayString = "Thursday";
                break;
            case 4: dayString = "Friday";
                break;
            case 5: dayString = "Saturday";
                break;
            case 6: dayString = "Sunday";
                break;
        }

     return dayString;
    }

    public String getHour() {
        if(hour <= 9) {
            return "0" + hour; }

        else {
            return "" + hour;
        }
    }

    public String getMinute() {
        if(minute < 10) {
            return "0" + minute; }

        else {
            return "" + minute;
        }
    }


    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void countAllCars(){
        totalNumberOfCars = 0;
        totalNumberOfTicketCars = 0;
        totalNumberOfParkingPassCars = 0;
        totalNumberOfReservationCars = 0;

        for(int floor = 0; floor < this.numberOfFloors; floor++){
            for(int row = 0; row < this.numberOfRows; row++)     {
                for(int place = 0; place < this.numberOfPlaces; place++)  {
                    Car car = this.cars[floor][row][place];
                    if(car != null){
                        totalNumberOfCars++;
                        if(car instanceof ParkPassCar){
                            totalNumberOfParkingPassCars++;
                        } else if(car instanceof ReservationCar) {
                            totalNumberOfReservationCars++;
                        } else {
                            totalNumberOfTicketCars++;
                        }
                    }
                }
            }
        }
    }

    public Car getCarAt(Location location) {
        if (!locationIsValid(location)) {
            return null;
        }
        return cars[location.getFloor()][location.getRow()][location.getPlace()];
    }

    public boolean setCarAt(Location location, Car car) {
        if (!locationIsValid(location)) {
            return false;
        }
        Car oldCar = getCarAt(location);
        if (oldCar == null) {
            cars[location.getFloor()][location.getRow()][location.getPlace()] = car;
            car.setLocation(location);
            return true;
        }
        return false;
    }

    public Car removeCarAt(Location location) {
        if (!locationIsValid(location)) {
            return null;
        }
        Car car = getCarAt(location);
        if (car == null) {
            return null;
        }
        cars[location.getFloor()][location.getRow()][location.getPlace()] = null;
        car.setLocation(null);
        return car;
    }

    public Location getRandomFreeLocation() {
        Random randomGenerator = new Random();
        int randomFloor = randomGenerator.nextInt(getNumberOfFloors());
        int randomRow = randomGenerator.nextInt(getNumberOfRows());
        int randomPlace = randomGenerator.nextInt(getNumberOfPlaces());
        for (int floor = randomFloor; floor < getNumberOfFloors(); floor++) {
            for (int row = randomRow; row < getNumberOfRows() - 1; row++) {
                for (int place = randomPlace; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    if (getCarAt(location) == null) {
                        return location;
                    }
                }
            }
        }
        return null;
    }

    public Location getReservedFreeLocation() {
        Random randomGenerator = new Random();
        int randomFloor = randomGenerator.nextInt(getNumberOfFloors());
        int randomPlace = randomGenerator.nextInt(getNumberOfPlaces());
        for (int floor = randomFloor; floor < getNumberOfFloors(); floor++) {
            for (int row = getNumberOfRows() - 1; row<getNumberOfRows(); row++) {
                for (int place = randomPlace; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    if (getCarAt(location) == null){
                        return location;
                    }
                }
            }
        }
        return null;
    }

    public Car getAndRemoveFirstLeavingCar() {
        for (int floor = 0; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = getCarAt(location);
                    if (car != null && car.getMinutesLeft() <= 0 && !car.getIsPaying()) {
                        cars[location.getFloor()][location.getRow()][location.getPlace()] = null;
                        return car;
                    }
                }
            }
        }
        return null;
    }

    public float getTotalRevenue(){
        return this.paymentMachine.getTotalRevenue();
    }

    public float getTicketCarRevenue() {
        return this.paymentMachine.getNormalCarRevenue();
    }

    public float getParkpassCarRevenue() {
        return this.paymentMachine.getParkpassCarRevenue();
    }

    public float getReservationCarRevenue() {
        return this.paymentMachine.getReservationCarRevenue();
    }

    public int getEntranceCarQueueAmount() {
        return entranceCarQueue.getQueueSize();
    }

    public int getExitCarQueueAmount() {
        return exitCarQueue.getQueueSize();
    }

    public int getTotalNumberOfCars() {
        return totalNumberOfCars;
    }

    public int getTotalNumberOfTicketCars() {
        return totalNumberOfTicketCars;
    }

    public int getTotalNumberOfParkingPassCars() {
        return totalNumberOfParkingPassCars;
    }

    public int getTotalNumberOfReservationCars() {
        return totalNumberOfReservationCars;
    }

    public int getParkingPassCarsEntranceCarQueueAmount() {
        int number = 0;
        for(Car car : specialEntranceCarQueue.getQueue())
            if(car instanceof ParkPassCar)
                number++;
        return number;
    }

    public int getParkingpassCarsExitQueueAmount() {
        int number = 0;
        for(Car car : specialExitCarQueue.getQueue())
            if(car instanceof ParkPassCar)
                number++;
        return number;
    }
    public int getReservationCarsEntranceQueueAmount() {
        int number = 0;
        for(Car car : specialEntranceCarQueue.getQueue())
            if(car instanceof ReservationCar)
                number++;
        return number;
    }

    public int getReservationCarsExitCarQueue() {
        int number = 0;
        for(Car car : specialExitCarQueue.getQueue())
            if(car instanceof ReservationCar)
                number++;
        return number;
    }



    private boolean locationIsValid(Location location) {
        int floor = location.getFloor();
        int row = location.getRow();
        int place = location.getPlace();
        if (floor < 0 || floor >= numberOfFloors || row < 0 || row > numberOfRows || place < 0 || place > numberOfPlaces) {
            return false;
        }
        return true;
    }

}