package ru.skillbox.module06_4.task01;

import java.util.ArrayList;

public class Main {
    private static Company company = new Company("Roga_i_KopbIta"); // Create company
    private static int countOperator = 0;
    private static int countManager = 0;
    private static int countTopManager = 0;

    public static void main(String[] args) {
        addedOperator(180);             // Создаем и нанимаем 180 операторов
        addedManagers(80);              // Создаем и нанимаем 80 манагеров
        addedTopManagers(10);           // Создаем и нанимаем 10 ТОПов
        System.out.println("Income company " + company.getIncome());

        System.out.println("---------------- 15 самых высоких зарплат ----------------");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }

        System.out.println("---------------- 30 самых низких зарплат ----------------");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }

        fireOperators(50);          // Увольняем 50% операторов
        fireManagers(50);           // Увольняем 50% манагеров
        fireTopManagers(50);        // Увольняем 50% ТОПов
        System.out.println("Income company " + company.getIncome());

        System.out.println("---------------- 15 самых высоких зарплат после увольнения ----------------");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }

        System.out.println("---------------- 30 самых низких зарплат после увольнения ----------------");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
    }

    /**
     * Увольняем операторов.
     * @param percent Сколько нужно уволить человек в процентах.
     */
    public static void fireOperators(int percent) {
        ArrayList<Employee> employees = company.getEmployees();
        int fire = countOperator - (countOperator * percent / 100);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Operator) {
                if (countOperator > fire) {
                    company.fire(employees.get(i));
                    countOperator--;
                    i--;
                }
            }
        }
    }

    /**
     * Увольняем менеджеров.
     * @param percent Сколько нужно уволить человек в процентах.
     */
    public static void fireManagers(int percent) {
        ArrayList<Employee> employees = company.getEmployees();
        int fire = countManager - (countManager * percent / 100);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Manager) {
                if (countManager > fire) {
                    company.fire(employees.get(i));
                    countManager--;
                    i--;
                }
            }
        }
    }

    /**
     * Увольняем Топ менеджеров.
     * @param percent Сколько нужно уволить человек в процентах.
     */
    public static void fireTopManagers(int percent) {
        ArrayList<Employee> employees = company.getEmployees();
        int fire = countTopManager - (countTopManager * percent / 100);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof TopManager) {
                if (countTopManager > fire) {
                    company.fire(employees.get(i));
                    countTopManager--;
                    i--;
                }
            }
        }
    }

    /**
     * Создаем и нанием операторов.
     * @param count Количество создаваемых едениц.
     */
    public static void addedOperator(int count) {
        for (int i = 0; i < count; i++) {
            company.hire(new Operator());
        }
        countOperator += count;
    }

    /**
     * Создаем и нанимаем Топ менеджеров.
     * @param count Количество создаваемых едениц.
     */
    public static void addedTopManagers(int count){
        for (int i = 0; i < count; i++) {
            company.hire(new TopManager(company));
        }
        countTopManager += count;
    }

    /**
     * Создаем и нанимаем менеджеров.
     * @param count Количество создаваемых едениц.
     */
    public static void addedManagers(int count){
        ArrayList<Employee> managers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            managers.add(new Manager());
        }
        company.hireAll(managers);
        countManager += count;
    }
}
