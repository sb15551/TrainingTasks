package ru.skillbox.module06_3.task01;

public class Individual extends Client {

    public Individual(String name, int age, double balance) {
        super(name, age, balance);
    }

    /**
     * Метод для зачисления средств на счет.
     * При зачислении расчитывается комиссия и удерживается с суммы которая вносится.
     * Комиссия 1% если > 1000 у.е.
     * Комиссия 0.5% если <= 1000 у.е.
     * @param money Средства которые требуется внести на счет.
     */
    @Override
    public void depositMoney(double money) {
        double comission = round(money * 0.01);
        if (money > 1000) {
            System.out.println("Коммиссия банка 1% составила " + comission + " у.е.");
            super.depositMoney(money + comission);
        }
        if (money <= 1000) {
            comission /= 2;
            System.out.println("Коммиссия банка 0.5% составила " + comission + " у.е.");
            super.depositMoney(money + comission);
        }
    }
}
