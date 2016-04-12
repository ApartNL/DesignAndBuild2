package View;

/**
 * Created by xavier on 11-4-2016.
 */
import Model.Simulator;
// import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

public class Taart extends AbstractView {

    private int ticketCars;
    private int parkPassCars;
    private int reservationCars;
    private int totalAmountOfCars;
    private double onePercent;

    public Taart (Simulator sim) {
        super(sim);
        this.ticketCars = 0;
        this.parkPassCars = 0;
        this.reservationCars = 0;

    }

    @Override public void updateView() {
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

    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Total Car Overview");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Ticket cars", 13),
                        new PieChart.Data("Parking pass cars", 25),
                        new PieChart.Data("Reservation cars", 10));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Total Car Overview");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
}