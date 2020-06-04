package ru.skillbox.module06_1_2.task01;

public class CardAccount extends PaymentAccount {
    public CardAccount() {
        super();
    }

    public CardAccount(float money) {
        super(money);
    }

    /**
     * Метод для снятия стредств со счета.
     * При снятии средств расчитывается комиссия, удерживается со счета и зачисляется на счет банка.
     * @param money Средства которые требуется снять со счета.
     */
    @Override
    public void withDrawMoney(float money) {
        float comission = round(money * 0.01f);
        if (super.getBalance() >= money + comission) {
            System.out.println("Коммиссия банка 1% составила " + comission + " у.е.");
            super.withDrawMoney(money + comission);
        } else {
            System.out.println("Не достаточно средств!");
            System.out.println("Остаток по счету: " + super.getBalance() + " у.е");
        }
    }
}
