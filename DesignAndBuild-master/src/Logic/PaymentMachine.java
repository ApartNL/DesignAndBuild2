package Logic;

public class PaymentMachine {

    public static final float DEFAULT_PARKPASS_DISCOUNT = 0.9f;
    public static final float DEFAULT_RESERVATION_DISCOUNT = 0.8f;

    public static final float DEFAULT_NORMAL_CAR_PRICE = 100;
    public static final float DEFAULT_PARKPASS_CAR_PRICE = (PaymentMachine.DEFAULT_NORMAL_CAR_PRICE* PaymentMachine.DEFAULT_PARKPASS_DISCOUNT);
    public static final float DEFAULT_RESERVATION_CAR_PRICE = (PaymentMachine.DEFAULT_NORMAL_CAR_PRICE* PaymentMachine.DEFAULT_RESERVATION_DISCOUNT);

    private float normalCarPrice;
    private float parkpassCarPrice;
    private float reservationCarPrice;

    private float totalRevenue;
    private float normalCarRevenue;
    private float parkpassCarRevenue;
    private float reservationCarRevenue;

    private int normalCars;
    private int parkpassCars;
    private int reservationCars;

    public PaymentMachine() {
        this(PaymentMachine.DEFAULT_NORMAL_CAR_PRICE, PaymentMachine.DEFAULT_PARKPASS_CAR_PRICE, PaymentMachine.DEFAULT_RESERVATION_DISCOUNT);
    }

    public PaymentMachine(float normalCarPrice, float parkpassCarPrice, float reservationCarPrice) {
        this.normalCarPrice = normalCarPrice;
        this.parkpassCarPrice = parkpassCarPrice;
        this.reservationCarPrice = reservationCarPrice;

        this.normalCars = 0;
        this.parkpassCars = 0;
        this.reservationCars = 0;
        this.totalRevenue = 0;
        this.normalCarRevenue = 0;
        this.parkpassCarRevenue = 0;
        this.reservationCarRevenue = 0;
    }

    public boolean pay(Car car){
        if(car instanceof AdHocCar){
            normalCars++;
            normalCarRevenue += this.normalCarPrice;
            totalRevenue += this.normalCarPrice;
        } else if(car instanceof ParkPassCar) {
            parkpassCars++;
            parkpassCarRevenue += this.parkpassCarPrice;
            totalRevenue += this.parkpassCarPrice;
        } else if(car instanceof ReservationCar){
            reservationCars++;
            reservationCarRevenue += reservationCarPrice;
            totalRevenue += this.reservationCarPrice;
        } else {
           return false;
        }
        return true;
    }

    public int getNormalCars() {
        return normalCars;
    }

    public int getParkpassCars() {
        return parkpassCars;
    }

    public int getReservationCars() {
        return reservationCars;
    }

    public float getTotalRevenue() {
        return totalRevenue;
    }

    public float getNormalCarRevenue() {
        return normalCarRevenue;
    }

    public float getParkpassCarRevenue() {
        return parkpassCarRevenue;
    }

    public float getReservationCarRevenue() {
        return reservationCarRevenue;
    }
}
