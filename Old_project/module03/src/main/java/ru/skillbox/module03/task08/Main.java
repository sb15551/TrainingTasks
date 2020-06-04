package ru.skillbox.module03.task08;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        for (Aircraft aircraft : airport.getAllAircrafts()) {
            System.out.println("Самолет: " + aircraft);
        }
        System.out.println("Кол-во самолетов в аэропорту: " + airport.getAllAircrafts().size());
    }
}
