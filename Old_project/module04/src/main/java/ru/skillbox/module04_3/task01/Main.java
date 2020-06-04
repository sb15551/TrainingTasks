package ru.skillbox.module04_3.task01;

import java.util.Scanner;

public class Main {
    private static final int CAPACITY_TRUCK = 12;
    private static final int CAPACITY_CONTAINER = 27;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во ящиков!");
        int boxes = scanner.nextInt();
        int containers = 0;
        int trucks = 0;

        if (boxes != 0) {
            containers = boxes % CAPACITY_CONTAINER == 0 ? boxes / CAPACITY_CONTAINER : boxes / CAPACITY_CONTAINER + 1;
            trucks = containers % CAPACITY_TRUCK == 0 ? containers / CAPACITY_TRUCK : containers / CAPACITY_TRUCK + 1;
        }

        System.out.println("Trucks: " + trucks);
        System.out.println("Containers: " + containers);
        System.out.println("Boxes: " + boxes);
        System.out.println();

        int countContainer = 1;
        int numberContainer = 1;
        int countBox = 1;
        int countTruck = 1;

        for (int i = 1; i <= boxes; i++) {
            if (countContainer > CAPACITY_TRUCK && countBox > CAPACITY_CONTAINER || countTruck == 1) {
                System.out.println("Truck " + countTruck + ":");
                countTruck++;
                countContainer = 1;
            }
            if (countBox > CAPACITY_CONTAINER || numberContainer == 1) {
                System.out.println("    Container " + numberContainer + ":");
                countContainer++;
                numberContainer++;
                countBox = 1;
            }
            System.out.println("        Box " + i);
            countBox++;
        }
    }
}
