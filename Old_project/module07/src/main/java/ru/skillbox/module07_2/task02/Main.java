package ru.skillbox.module07_2.task02;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        Date currentDate = new Date();
        Date departureDate = new Date(currentDate.getTime() + 2 * 3600 * 1000);

        System.out.println("-------------------------- Самолеты вылетающие в ближайшие 2 часа --------------------------");

        airport.getTerminals().stream().flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> flight.getDate().after(currentDate))
                .filter(flight -> flight.getDate().before(departureDate))
                .forEach(System.out::println);
    }
}
