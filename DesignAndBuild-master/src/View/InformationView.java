package View;

import Model.Simulator;

import javax.swing.*;
import java.awt.*;

public class InformationView extends AbstractView {



    private static final String LABEL_TOTAL_AMOUNT_OF_CARS      = "Total cars :";
    private static final String LABEL_CARS_WITH_PARKING_PASS    = "Parking pass cars :";
    private static final String LABEL_CARS_WITH_TICKETS         = "Cars with tickets :";
    private static final String LABEL_CARS_WITH_RESERVATIONS    = "Cars with a reservation: ";
    private static final String LABEL_AMOUNT_OF_CARS_IN_ENTRANCE_QUEUE  = "Entrance queue :";
    private static final String LABEL_AMOUNT_OF_CARS_IN_EXIT_QUEUE      = "Exit queue :";
    private static final String LABEL_AMOUNT_OF_PARKPASS_CARS_IN_ENTRANCE_QUEUE  = "Parking pass entrance queue :";
    private static final String LABEL_AMOUNT_OF_PARKPASS_CARS_IN_EXIT_QUEUE      = "Parking pass exit queue :";
    private static final String LABEL_AMOUNT_OF_RESERVATION_CARS_IN_ENTRANCE_QUEUE  = "Reservation entrance queue :";
    private static final String LABEL_AMOUNT_OF_RESERVATION_CARS_IN_EXIT_QUEUE      = "Reservation exit queue :";
    private static final String LABEL_TOTAL_AMOUNT_OF_REVENUE                       = "Total revenue :";
    private static final String LABEL_AMOUNT_OF_REVENUE_TICKET_CARS                 = "Ticket car revenue :";
    private static final String LABEL_AMOUNT_OF_REVENUE_PARKPASS_CARS               = "Parkpass car revenue :";
    private static final String LABEL_AMOUNT_OF_REVENUE_RESERVATION_CARS            = "Reservation car revenue :";
    private static final String LABEL_TIME                                          = "Time :";
    private static final String LABEL_LEGENDA_PARKPASS                              = "ParkPassHolders:";
    private static final String LABEL_LEGENDA_TICKET                                = "TicketHolders";
    private static final String LABEL_LEGENDA_RESERVATION                           = "Reservations";
    private static final String LABEL_LEGENDA_RESORVED_SPOT                         = "Reserved Spots";
    private static final String LABEL_LEGENDA_EMPTY_SPOT                            = "Empty Spots";
    private static final String LABEL_LEGEND                                      = "Legend:";
    private static final String LABEL_EMPTY                                       = " ";

    private JLabel label_totalAmountOfCars;
    private JLabel label_carsWithParkingPass;
    private JLabel label_carsWithTickets;
    private JLabel label_carsWithReservations;
    private JLabel label_amountOfCarsInEntranceQueue;
    private JLabel label_amountOfCarsInExitQueue;
    private JLabel label_amountOfReservationCarsInEntranceQueue;
    private JLabel label_amountOfReservationCarsInExitQueue;
    private JLabel label_amountOfParkpassCarsInEntranceQueue;
    private JLabel label_amountOfParkpassCarsInExitQueue;
    private JLabel label_totalAmountOfRevenue;
    private JLabel label_amountOfTicketCarRevenue;
    private JLabel label_amountOfParkpassCarRevenue;
    private JLabel label_amountOfReservationCarRevenue;
    private JLabel label_time;
    private JLabel label_ticket;
    private JLabel label_passholder;
    private JLabel label_reservation;
    private JLabel label_reservationspot;
    private JLabel label_emptyspot;
    private JLabel label_legend;
    private JLabel label_empty;

    private JLabel totalAmountOfCars;
    private JLabel carsWithParkingPass;
    private JLabel carsWithTickets;
    private JLabel carsWithReservations;
    private JLabel amountOfCarsInEntranceQueue;
    private JLabel amountOfCarsInExitQueue;
    private JLabel amountOfReservationCarsInEntranceQueue;
    private JLabel amountOfReservationCarsInExitQueue;
    private JLabel amountOfParkpassCarsInEntranceQueue;
    private JLabel amountOfParkpassCarsInExitQueue;
    private JLabel totalAmountOfRevenue;
    private JLabel amountOfTicketCarRevenue;
    private JLabel amountOfParkpassCarRevenue;
    private JLabel amountOfReservationCarRevenue;
    private JLabel time;
    private JLabel ticket;
    private JLabel passholder;
    private JLabel reservation;
    private JLabel reservationspot;
    private JLabel emptyspot;
    private JLabel legend;
    private JLabel empty;


    public InformationView(Simulator sim) {
        super(sim);



        this.label_totalAmountOfCars = new JLabel(InformationView.LABEL_TOTAL_AMOUNT_OF_CARS);
        this.label_carsWithParkingPass = new JLabel(InformationView.LABEL_CARS_WITH_PARKING_PASS);
        this.label_carsWithTickets = new JLabel(InformationView.LABEL_CARS_WITH_TICKETS);
        this.label_carsWithReservations = new JLabel(InformationView.LABEL_CARS_WITH_RESERVATIONS);
        this.label_amountOfCarsInEntranceQueue = new JLabel(InformationView.LABEL_AMOUNT_OF_CARS_IN_ENTRANCE_QUEUE);
        this.label_amountOfCarsInExitQueue = new JLabel(InformationView.LABEL_AMOUNT_OF_CARS_IN_EXIT_QUEUE);
        this.label_amountOfReservationCarsInEntranceQueue = new JLabel(InformationView.LABEL_AMOUNT_OF_RESERVATION_CARS_IN_ENTRANCE_QUEUE);
        this.label_amountOfReservationCarsInExitQueue = new JLabel(InformationView.LABEL_AMOUNT_OF_RESERVATION_CARS_IN_EXIT_QUEUE);
        this.label_amountOfParkpassCarsInEntranceQueue = new JLabel(InformationView.LABEL_AMOUNT_OF_PARKPASS_CARS_IN_ENTRANCE_QUEUE);
        this.label_amountOfParkpassCarsInExitQueue = new JLabel(InformationView.LABEL_AMOUNT_OF_PARKPASS_CARS_IN_EXIT_QUEUE);
        this.label_totalAmountOfRevenue = new JLabel(InformationView.LABEL_TOTAL_AMOUNT_OF_REVENUE);
        this.label_amountOfTicketCarRevenue = new JLabel(InformationView.LABEL_AMOUNT_OF_REVENUE_TICKET_CARS);
        this.label_amountOfParkpassCarRevenue = new JLabel(InformationView.LABEL_AMOUNT_OF_REVENUE_PARKPASS_CARS);
        this.label_amountOfReservationCarRevenue = new JLabel(InformationView.LABEL_AMOUNT_OF_REVENUE_RESERVATION_CARS);
        this.label_time = new JLabel(InformationView.LABEL_TIME);
        this.label_ticket = new JLabel(InformationView.LABEL_LEGENDA_TICKET);
        this.label_passholder = new JLabel(InformationView.LABEL_LEGENDA_PARKPASS);
        this.label_reservation = new JLabel(InformationView.LABEL_LEGENDA_RESERVATION);
        this.label_reservationspot = new JLabel(InformationView.LABEL_LEGENDA_RESORVED_SPOT);
        this.label_emptyspot = new JLabel(InformationView.LABEL_LEGENDA_EMPTY_SPOT);
        this.label_legend = new JLabel(InformationView.LABEL_LEGEND);
        this.label_empty = new JLabel(InformationView.LABEL_EMPTY);

        this.totalAmountOfCars              = new JLabel("0");
        this.carsWithParkingPass            = new JLabel("0");
        this.carsWithTickets                = new JLabel("0");
        this.carsWithReservations           = new JLabel("0");
        this.amountOfCarsInEntranceQueue    = new JLabel("0");
        this.amountOfCarsInExitQueue        = new JLabel("0");
        this.amountOfReservationCarsInEntranceQueue    = new JLabel("0");
        this.amountOfReservationCarsInExitQueue        = new JLabel("0");
        this.amountOfParkpassCarsInEntranceQueue    = new JLabel("0");
        this.amountOfParkpassCarsInExitQueue        = new JLabel("0");

        this.totalAmountOfRevenue       = new JLabel("0");
        this.amountOfTicketCarRevenue = new JLabel("0");
        this.amountOfParkpassCarRevenue = new JLabel("0");
        this.amountOfReservationCarRevenue = new JLabel("0");
        this.time = new JLabel("0");
        this.legend = new JLabel();

        this.ticket = new JLabel();
        this.ticket.setBackground(Color.red);
        this.ticket.setOpaque(true);

        this.reservation = new JLabel();
        this.reservation.setBackground(Color.orange);
        this.reservation.setOpaque(true);

        this.passholder = new JLabel();
        this.passholder.setBackground(Color.blue);
        this.passholder.setOpaque(true);

        this.emptyspot = new JLabel();
        this.emptyspot.setBackground(Color.white);
        this.emptyspot.setOpaque(true);

        this.reservationspot = new JLabel();
        this.reservationspot.setBackground(Color.black);
        this.reservationspot.setOpaque(true);

        this.empty = new JLabel();

        this.setLayout(new GridLayout(22,2));



        this.add(label_legend);
        this.add(legend);
        this.add(label_ticket);
        this.add(ticket);
        this.add(label_passholder);
        this.add(passholder);
        this.add(label_reservation);
        this.add(reservation);
        this.add(label_reservationspot);
        this.add(reservationspot);
        this.add(label_emptyspot);
        this.add(emptyspot);

        this.add(label_empty);
        this.add(empty);


        this.add(label_time);
        this.add(time);
        this.add(label_totalAmountOfCars);
        this.add(totalAmountOfCars);
        this.add(label_carsWithParkingPass);
        this.add(carsWithParkingPass);
        this.add(label_carsWithTickets);
        this.add(carsWithTickets);
        this.add(label_carsWithReservations);
        this.add(carsWithReservations);
        this.add(label_amountOfCarsInEntranceQueue);
        this.add(amountOfCarsInEntranceQueue);
        this.add(label_amountOfCarsInExitQueue);
        this.add(amountOfCarsInExitQueue);
        this.add(label_amountOfParkpassCarsInEntranceQueue);
        this.add(amountOfParkpassCarsInEntranceQueue);
        this.add(label_amountOfParkpassCarsInExitQueue);
        this.add(amountOfParkpassCarsInExitQueue);
        this.add(label_amountOfReservationCarsInEntranceQueue);
        this.add(amountOfReservationCarsInEntranceQueue);
        this.add(label_amountOfReservationCarsInExitQueue);
        this.add(amountOfReservationCarsInExitQueue);
        this.add(label_totalAmountOfRevenue);
        this.add(totalAmountOfRevenue);
        this.add(label_amountOfTicketCarRevenue);
        this.add(amountOfTicketCarRevenue);
        this.add(label_amountOfParkpassCarRevenue);
        this.add(amountOfParkpassCarRevenue);
        this.add(label_amountOfReservationCarRevenue);
        this.add(amountOfReservationCarRevenue);


    }

    @Override
    public void updateView() {
        this.sim.countAllCars();


        this.totalAmountOfCars.setText(sim.getTotalNumberOfCars() + " cars");
        this.carsWithParkingPass.setText(sim.getTotalNumberOfParkingPassCars() + " cars");
        this.carsWithTickets.setText(sim.getTotalNumberOfTicketCars() + " cars");
        this.carsWithReservations.setText(sim.getTotalNumberOfReservationCars() + " cars");
        this.amountOfCarsInEntranceQueue.setText(sim.getEntranceCarQueueAmount() + " cars");
        this.amountOfCarsInExitQueue.setText(sim.getExitCarQueueAmount() + " cars");
        this.amountOfParkpassCarsInEntranceQueue.setText(sim.getParkingPassCarsEntranceCarQueueAmount() + " cars");
        this.amountOfParkpassCarsInExitQueue.setText(sim.getParkingpassCarsExitQueueAmount() + " cars");
        this.amountOfReservationCarsInEntranceQueue.setText(sim.getReservationCarsEntranceQueueAmount() + " cars");
        this.amountOfReservationCarsInExitQueue.setText(sim.getReservationCarsExitCarQueue() + " cars");
        this.totalAmountOfRevenue.setText("€ " + sim.getTotalRevenue());
        this.amountOfTicketCarRevenue.setText("€ " + sim.getTicketCarRevenue());
        this.amountOfParkpassCarRevenue.setText("€ " + sim.getParkpassCarRevenue());
        this.amountOfReservationCarRevenue.setText("€ " + sim.getReservationCarRevenue());
        this.time.setText(sim.getDay() + " " + sim.getHour() + ":" + sim.getMinute());
    }
}
