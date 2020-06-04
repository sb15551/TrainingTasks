package ru.skillbox.module06_3.task01;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Client {
    /**
     * Имя клиента.
     */
    private String name;
    /**
     * Возраст клиента.
     */
    private int age;
    /**
     * Номер расчетного счета.
     */
    private long payment;
    /**
     * Баланс расчетного счета.
     */
    private double balance;

    public Client(String name, int age, double balance) {
        this.name = name;
        this.age = age;
        payment = Long.parseLong(generateNumber());
        this.balance = balance;
    }

    /**
     * Метод для снятия средств.
     * @param money Средства которые требуется снять со счета.
     */
    public void withDrawMoney(double money) {
        if (balance > money) {
            balance -= round(money);
            System.out.println("Со счета №" + payment + " снято " + round(money) + " у.е");
            System.out.println("Остаток по счету: " + round(balance) + " у.е");
        } else {
            System.out.println("Не достаточно средств!");
            System.out.println("Остаток по счету: " + round(balance) + " у.е");
        }
    }

    /**
     * Метод для зачисления средств на счет.
     * @param money Средства которые требуется внести на счет.
     */
    public void depositMoney(double money) {
        balance += round(money);
        System.out.println("На счет №" + payment + " зачислено " + round(money) + " у.е");
        System.out.println("Остаток по счету: " + round(balance) + " у.е");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPayment() {
        return payment;
    }

    public double getBalance() {
        return round(balance);
    }

    /**
     * Округление числа float после запятой до двух знаков.
     * @param money Число коорое нужно округлить.
     * @return Получаем округленное число float.
     */
    public static double round(double money) {
        money = money * 100;
        int i = (int) money;
        return (double) i/100;
    }

    /**
     * Генерирует и возвращает уникальный номер расчетного счета.
     * @return
     */
    private String generateNumber() {
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        int random = (int) (Math.random() * 1000);
        return date + random;
    }

}
