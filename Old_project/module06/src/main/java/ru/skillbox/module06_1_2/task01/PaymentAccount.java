package ru.skillbox.module06_1_2.task01;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class PaymentAccount {
    /**
     * Номер расчетного счета.
     */
    private String number;

    /**
     * Баланс расчетного счета.
     */
    private float balance;

    /**
     * Дата создания расчетного счета.
     */
    private LocalDate dateCreateAccount;

    public PaymentAccount() {
        number = generateNumber();
        dateCreateAccount = LocalDate.now();
        balance = 0;
    }

    public PaymentAccount(float money) {
        number = generateNumber();
        dateCreateAccount = LocalDate.now();
        balance = money;
    }

    /**
     * Метод для снятия стредств со счета.
     * @param money Средства которые требуется снять со счета.
     */
    public void withDrawMoney(float money) {
        if (balance >= round(money)) {
            balance -= round(money);
            System.out.println("Со счета №" + number + " снято " + money + " у.е");
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
    public void depositMoney(float money) {
        balance += round(money);
        System.out.println("На счет №" + number + " зачислено " + round(money) + " у.е");
        System.out.println("Остаток по счету: " + round(balance) + " у.е");
    }

    /**
     * Узнать остаток средств на счете.
     */
    public void balanceAccount() {
        System.out.println("Остаток по счету №" + number + ": " + round(balance) + "у.е");
    }

    /**
     * Округление числа float после запятой до двух знаков.
     * @param money Число коорое нужно округлить.
     * @return Получаем округленное число float.
     */
    public static float round(float money) {
        money = money * 100;
        int i = (int) money;
        return (float) i/100;
    }

    /**
     * Получить номер расчетного счета.
     * @return
     */
    public String getNumber() {
        return number;
    }

    /**
     * Получить балансе расчетного счета.
     * @return
     */
    public float getBalance() {
        return round(balance);
    }

    /**
     * Установить баланс расчетного счета.
     * @param balance
     */
    public void setBalance(float balance) {
        this.balance = round(balance);
    }

    /**
     * Получить дату создания расчетного счета.
     * @return
     */
    public LocalDate getDateCreateAccount() {
        return dateCreateAccount;
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
