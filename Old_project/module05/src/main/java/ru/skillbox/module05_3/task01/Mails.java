package ru.skillbox.module05_3.task01;

import java.util.Scanner;
import java.util.TreeSet;

public class Mails {
    private static Mails mails = new Mails();
    private TreeSet<String> emails = new TreeSet<>();

    public static void main(String[] args) {
        String[] fullCommand = getCommands(); // Вводим команду с клавиатуры
        int len = fullCommand.length;
        String command = fullCommand[0].toUpperCase().trim();

        while (!command.equals("Q")) {
            if (command.equals("ADD") && len == 2) {
                String value = fullCommand[1];
                mails.add(value);
            } else if (command.equals("LIST") && len == 1) {
                if (mails.list().size() != 0) {
                    for (String mail : mails.list()){
                        System.out.println(mail);
                    }
                } else System.out.println("Список пуст!");
            } else {
                System.out.println("Такой команды не существует!!! Введите add <*****@****.***> или list");
            }
            fullCommand = getCommands(); // Вводим команду с клавиатуры
            len = fullCommand.length;
            command = fullCommand[0].toUpperCase().trim();
        }
    }

    /**
     * Просит ввести команду с клавиатуры.
     * @return возвращает введенную строку.
     */
    public static String[] getCommands() {
        StringBuilder value = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду: ");
        String[] fullcommand = scanner.nextLine().split("\\s+");
        String[] temp = (fullcommand.length == 1) ? new String[1] : new String[2];
        if (fullcommand.length == 1) {
            temp[0] = fullcommand[0];
        } else {
            for (int i = 1; i < fullcommand.length; i++) {
                temp[0] = fullcommand[0];
                value.append(fullcommand[i]);
                value.append(" ");
                temp[1] = String.valueOf(value).trim();
            }
        }
        return temp;
    }

    /**
     * Добавляем e-mail в список.
     * @return Возвращает true если оперция прошла успешно.
     */
    public boolean add(String value) {
        if (validEmail(value)) {
            emails.add(value);
            System.out.println("Added!");
            return true;
        } else {
            System.out.println("Введите e-mail в формате *****@****.***");
            return false;
        }
    }

    /**
     * @return Возвращает список e-mail'ов
     */
    public TreeSet<String> list() {
        return emails;
    }

    /**
     * Проверяет правлильно ли введен e-mail
     * @param email
     * @return
     */
    public static boolean validEmail(String email) {
        return (email.matches(".+@.+\\..+"));
    }
}
