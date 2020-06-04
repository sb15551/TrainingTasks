package ru.skillbox.module04_4.task03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fullName = getFullName(); // вводим ФИО
        String[] names = fullName.split(" "); // разбиваем ФИО на группы

        String surname = "";
        String firstName = "";
        String secondName = "";

        for (int i = 0; i < names.length; i++) {
            if (i == 0) surname = names[i];
            if (i == 1) firstName = names[i];
            if (i == 2) secondName = names[i];
            if (i == 3) secondName += " " + names[i];
        }

        if (!surname.equals("")) System.out.println("Surname: " + surname);
        if (!firstName.equals("")) System.out.println("First name: " + firstName);
        if (!secondName.equals("")) System.out.println("Second name: " + secondName.trim());
    }

    /**
     * Метод для ввода ФИО.
     * @return Получаем полностью валидное ФИО.
     */
    public static String getFullName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО полностью:  ");
        String fullName = scanner.nextLine(); // вводим ФИО
        fullName = allToOnePattern(fullName); // приводим к одному виду
        String[] names = fullName.split(" "); // разбиваем ФИО на группы
        boolean validName = false;
        for (int i = 0; i < names.length; i++) {
           if (validFullName(names[i])) {
               validName = true;
           } else {
               System.out.println("Введите ФИО корректно!!!");
               return getFullName();
           }
        }
        return fullName;
    }

    /**
     * Проверяем нет ли в слове цифр и других не нужных знаков
     * @param str Фамилия или имя или отчество
     * @return true если нет ни чего лишнего
     */
    public static boolean validFullName(String str) {
        return str.matches("^[А-ЯЁ][а-яё]+");
    }

    /**
     * Приводим введеную строку к одному виду.
     * Первая буква слова в верхнем регистре, остальные в нижнем.
     * @param fullName ФИО полностью, которое ввели с клавиатуры.
     * @return ФИО полностью по заданному шаблону
     */
    public static String allToOnePattern(String fullName) {
        fullName = fullName.toLowerCase();
        String newFullName = "";
        String[] names = fullName.split(" ");
        for (int i = 0; i < names.length; i++) {
            String name = "";
            if (!names[i].equals("")) {
                name = names[i].substring(0, 1).toUpperCase() + names[i].substring(1, names[i].length()) + " ";
                newFullName += name;
            }
        }
        return newFullName.trim();
    }
}
