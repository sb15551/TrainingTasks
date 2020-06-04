package ru.skillbox.module06_4.task01;

public class Manager implements Employee {

    private int fixedSalary = 50000;
    private int earned = (int) (Math.random() * 1000000);

    @Override
    public int getMonthSalary() {
        return (int) (fixedSalary + (earned * 0.05));
    }

    @Override
    public int getEarnedForCompany() {
        return earned;
    }
}
