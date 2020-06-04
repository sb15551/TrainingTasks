package ru.skillbox.module06_3.task01;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------- Физическое лицо -------------------------");
        Client vasya = new PhysicalPerson("Vasya", 25, 200);

        System.out.println();
        System.out.println("Balance: " + vasya.getBalance() + " y.e.");

        System.out.println();
        vasya.withDrawMoney(46.8);

        System.out.println();
        vasya.depositMoney(765.12);

        System.out.println();
        System.out.println("Balance: " + vasya.getBalance() + " y.e.");

        System.out.println("------------------------- Юридическое лицо -------------------------");
        Client kolya = new Entity("Kolya", 30, 1500);

        System.out.println();
        System.out.println("Balance: " + kolya.getBalance() + " y.e.");

        System.out.println();
        kolya.withDrawMoney(48.56);

        System.out.println();
        kolya.depositMoney(12.13);

        System.out.println();
        System.out.println("Balance: " + kolya.getBalance() + " y.e.");

        System.out.println("------------------------- Индивидуальный предприниматель -------------------------");
        Client sasha = new Individual("Sasha", 18, 100);

        System.out.println();
        System.out.println("Balance: " + sasha.getBalance() + " y.e.");

        System.out.println();
        sasha.withDrawMoney(10.5);

        System.out.println();
        sasha.depositMoney(500);

        System.out.println();
        sasha.depositMoney(1500);

        System.out.println();
        System.out.println("Balance: " + sasha.getBalance() + " y.e.");
    }
}
