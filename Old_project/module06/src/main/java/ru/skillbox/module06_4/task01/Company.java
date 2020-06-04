package ru.skillbox.module06_4.task01;

import java.util.*;

public class Company {
    /**
     * Название компании.
     */
    private String nameCompany;

    /**
     * Сотрудники работающие в компании.
     */
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    /**
     * Ежемесячный доход компании.
     */
    private int income;

    /**
     * Конструктор создающий компанию.
     * @param nameCompany
     */
    public Company(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    /**
     * Найм одного сотрудника.
     */
    public void hire(Employee employee) {
        if (employee instanceof Manager) {
            employees.add(employee);
            income += employee.getEarnedForCompany();
        } else {
            employees.add(employee);
        }
    }

    /**
     * Найм списка сотрудников.
     */
    public void hireAll(List<Employee> employees) {
        this.employees.addAll(employees);
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                this.hire(employee);
            }
        }
    }

    /**
     * Увольнение сотрудника.
     */
    public void fire(Employee employee) {
        employees.remove(employee);
        if (employee instanceof Manager) {
            income -= (int) (1 / 0.05) * (employee.getMonthSalary() - 50000);
        }
    }

    /**
     * Получение значения дохода компании.
     */
    public int getIncome() {
        return income;
    }

    /**
     * @param count Кол-во сотрудников которое требуется получить.
     * @return Получаем список сотрудников отсортированных по убыванию заработной платы.
     */
    public List<Employee> getTopSalaryStaff(int count) {
        return this.getSortSalaryStaff(count, Comparator.reverseOrder());
    }

    /**
     * @param count Кол-во сотрудников которое требуется получить.
     * @return Получаем список сотрудников отсортированных по возрастанию заработной платы.
     */
    public List<Employee> getLowestSalaryStaff(int count) {
        return this.getSortSalaryStaff(count, Comparator.naturalOrder());
    }

    private List<Employee> getSortSalaryStaff(int count, Comparator comparator) {
        ArrayList<Employee> sortSalary = new ArrayList<>();
        Collections.sort(employees, comparator);
        for (int i = 0; i < count; i++) {
            sortSalary.add(employees.get(i));
        }
        return sortSalary;
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> tempEmployees = new ArrayList<>();
        tempEmployees.addAll(employees);
        return tempEmployees;
    }
}
