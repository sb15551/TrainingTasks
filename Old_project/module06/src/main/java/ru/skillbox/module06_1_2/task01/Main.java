package ru.skillbox.module06_1_2.task01;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------- Deposit account -----------------------------");
        DepositAccount depositAccount = new DepositAccount(1234);
        System.out.println("Deposit account N" + depositAccount.getNumber() + " created! " + "Date of creation " + depositAccount.getDateCreateAccount());
        System.out.println("Balance " + depositAccount.getBalance() + " y.e.");
        System.out.println();
        depositAccount.withDrawMoney((float) 150.40);
        System.out.println();
        depositAccount.depositMoney((float) 475.89);
        System.out.println();
        System.out.println();

        System.out.println("----------------------------- Card account -----------------------------");
        CardAccount cardAccount = new CardAccount(462.25f);
        System.out.println("Card account N" + cardAccount.getNumber() + " created! " + "Date of creation " + cardAccount.getDateCreateAccount());
        System.out.println("Balance " + cardAccount.getBalance() + " y.e.");
        System.out.println();
        cardAccount.withDrawMoney((float) 150.40);
        System.out.println();
        cardAccount.depositMoney((float) 475.89);
    }
}
