package ru.skillbox.module04_5.task04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String number = getNumberPhone();
        System.out.println(number);
    }

    public static String getNumberPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона в любом формате");
        String number = scanner.nextLine();
        if (isNumberPhone(number)) {
            number = number.replaceAll("([^0-9])|\\s+", "");
            number = number.replaceAll("^[^7]", "7");
        } else {
            System.out.println("Не верно!!!");
            return getNumberPhone();
        }
        return number;
    }

    public static boolean isNumberPhone(String number) {
        return number.matches("\\+?[1-9](\\s+)?([^0-9]|\\s+)?\\d{3,4}([^0-9]|\\s+)?(\\s+)?\\d{3}([^0-9]|\\s+)?\\d{2}([^0-9]|\\s+)?\\d{2}");
    }
}
