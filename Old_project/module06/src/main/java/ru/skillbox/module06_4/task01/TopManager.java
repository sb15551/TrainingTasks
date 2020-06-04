package ru.skillbox.module06_4.task01;

public class TopManager implements Employee {

    private int fixedSalary = (int) (Math.random() * 70000) + 70000;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > 10000000) {
            return (int)(fixedSalary + (fixedSalary * 1.5));
        }
        return fixedSalary;
    }
}
