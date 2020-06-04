package ru.skillbox.module06_1_2.task01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DepositAccount extends PaymentAccount {
    /**
     * Дата зачисления средств на счет.
     */
    private LocalDate dateDeposit;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy EEEE");

    public DepositAccount() {
        super();
        dateDeposit = super.getDateCreateAccount();
    }
    public DepositAccount(float money) {
        super(money);
        dateDeposit = super.getDateCreateAccount();
    }

    /**
     * Метод для снятия стредств со счета.
     * Cнять средства в течение месяца после последнего внесения не получится.
     * @param money Средства которые требуется снять со счета.
     */
    @Override
    public void withDrawMoney(float money) {
        if (super.getBalance() >= money) {
            if (LocalDate.now().isAfter(dateDeposit.plusDays(30))) {
                super.withDrawMoney(money);
            } else {
                System.out.println("Вы не можете снять средства со счета N" + super.getNumber() + ", так как с последнего внесения средств не прошел 1 месяц");
                System.out.println("Последний раз Вы вносили средства " + dateFormat.format(dateDeposit));
            }
        } else {
            System.out.println("Не достаточно средств!");
            System.out.println("Остаток по счету: " + super.getBalance() + " у.е");
        }
    }

    /**
     * Метод для зачисления средств на счет.
     * Запоминает дату зачисления.
     * @param money Средства которые требуется внести на счет.
     */
    @Override
    public void depositMoney(float money) {
            dateDeposit = LocalDate.now();
            super.depositMoney(money);
    }
}
