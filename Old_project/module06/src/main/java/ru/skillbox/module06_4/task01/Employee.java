package ru.skillbox.module06_4.task01;

public interface Employee extends Comparable<Employee> {
    int getMonthSalary();
    default int getEarnedForCompany(){
        return 0;
    }

    @Override
    default int compareTo(Employee e) {
        return this.getMonthSalary() - e.getMonthSalary();
    }
}
