package ru.skillbox.module06_4.task01;

public class Operator implements Employee {

    private int fixedSalary = (int) (Math.random() * 20000) + 30000;

    @Override
    public int getMonthSalary() {
        return fixedSalary;
    }
}
