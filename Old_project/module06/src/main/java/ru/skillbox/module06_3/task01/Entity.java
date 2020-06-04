package ru.skillbox.module06_3.task01;

public class Entity extends Client {

    public Entity(String name, int age, double balance) {
        super(name, age, balance);
    }

    /**
     * Метод для снятия средств.
     * При снятии средств расчитывается комиссия и удерживается со счета.
     * @param money Средства которые требуется снять со счета.
     */
    @Override
    public void withDrawMoney(double money) {
        double comission = round(money * 0.01);
        System.out.println("Коммиссия банка 1% составила " + comission + " у.е.");
        super.withDrawMoney(money + comission);
    }

}
