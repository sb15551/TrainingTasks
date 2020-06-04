package ru.skillbox.module05_2.task01;

import java.util.ArrayList;
import java.util.Scanner;

public class Planner {
    private static Planner planner = new Planner();
    private ArrayList<String> cases = new ArrayList<>();

    public static void main(String[] args) {
        String fullCommand[] = getCommands(); // Вводим команду с клавиатуры
        String command = extractCommand(fullCommand).toUpperCase().trim();
        String value = extractValue(fullCommand);

        while (!command.equals("Q")) {
            if (command.matches("^ADD(\\s+\\d+)?") && value != null) {    // Доавляем задание если введено add или add с индексом

                String[] adding = command.split("\\s+");
                if (adding.length == 1) planner.add(value);
                if (adding.length == 2) planner.add(Integer.parseInt(adding[1]), value);

            } else if (command.matches("^DELETE(\\s+\\d+)") && value != null) {     // Удаляем задание если введено delete с индексом

                String[] deleting = command.split("\\s+");
                planner.delete(Integer.parseInt(deleting[1]));

            } else if (command.matches("^EDIT(\\s+\\d+)") && value != null) {    // Редактируем задание если введено edit с индексом

                String[] editing = command.split("\\s+");
                planner.edit(Integer.parseInt(editing[1]), value);

            } else if (command.matches("^LIST\\s*")) {    // Выводим весь планировщик если введено list

                if (planner.list().size() != 0) {
                    for (int i = 0; i < planner.list().size(); i++) {
                        System.out.println(i + " - " + planner.list().get(i));
                    }
                } else System.out.println("Планировщик пуст!");

            } else {
                System.out.println("Такой команды не существует!!! Введите add, add <index>, list, delete или edit");
            }
            fullCommand = getCommands(); // Вводим команду с клавиатуры
            command = extractCommand(fullCommand).toUpperCase().trim();
            value = extractValue(fullCommand);
        }
        System.out.println("До свидания!");
    }

    /**
     * Просит ввести команду с клавиатуры. Разбивает ее на массив строк.
     * @return Возвращает массив строк.
     */
    public static String[] getCommands() { //tyt
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду: ");
        String fullCommand = scanner.nextLine(); // Вводим команду с клавиатуры
        if (validCommand(fullCommand)) {
            String[] fullCommandArray = fullCommand.split("\\s+");
            return fullCommandArray;
        } else {
            System.out.println("Такой команды не существует!!! Введите add, add <index>, list, delete или edit");
            return getCommands();
        }
    }

    /**
     * Извлекаем значение для команды.
     * @param fullCommandArray
     * @return
     */
    private static String extractValue(String[] fullCommandArray) {
        StringBuilder value = new StringBuilder();
        if (fullCommandArray.length == 1) return null;
        if (fullCommandArray[1].matches("\\d+")) {
            for (int i = 2; i < fullCommandArray.length; i++) {
                value.append(fullCommandArray[i]);
                value.append(" ");
            }
            return String.valueOf(value);
        } else {
            for (int i = 1; i < fullCommandArray.length; i++) {
                value.append(fullCommandArray[i]);
                value.append(" ");
            }
            return String.valueOf(value);
        }
    }

    /**
     * Извлекаем команду и индекс, если он есть.
     * @param fullCommandArray
     * @return
     */
    public static String extractCommand(String[] fullCommandArray) {
        StringBuilder command = new StringBuilder();
        if (fullCommandArray.length == 1) return fullCommandArray[0];
        if (fullCommandArray[1].matches("\\d+")) {
            command.append(fullCommandArray[0]);
            command.append(" ");
            command.append(fullCommandArray[1]);
            return String.valueOf(command);
        } else return fullCommandArray[0];
    }

    /**
     * Проверяем корректно ли введена команда.
     * @param command
     * @return
     */
    public static boolean validCommand(String command) {
        return command.matches("(^[A-Za-z]+)(\\s+\\d+)?(\\s+[A-Za-zА-Яа-я0-9\\s+]+)?");
    }

    /**
     * Добавляем задание в планировщик.
     * @return Возвращает true если оперция прошла успешно.
     */
    public boolean add(String value) {
        this.cases.add(value);
        return true;
    }

    /**
     * Добавляет задание в планировщик по индексу.
     * @param index Индекс или порядковый номер задания.
     * @return Возвращает true если оперция прошла успешно.
     */
    public boolean add(int index, String value) {
        if (index <= cases.size()) {
            this.cases.add(index, value);
            return true;
        } else {
            System.out.println("ТАКОГО ИНДЕКСА НЕ СУЩЕСТВУЕТ!!!!!");
            return false;
        }
    }

    /**
     * Выводит весь планировщик.
     * @return Список заданий.
     */
    public ArrayList<String> list() {
        return this.cases;
    }

    /**
     * Удаляет задание по индексу.
     * @param index Индекс или порядковый номер задания.
     * @return Возвращает true если оперция прошла успешно.
     */
    private boolean delete(int index) {
        if (index < cases.size()) {
            cases.remove(index);
            return true;
        } else {
            System.out.println("ТАКОГО ИНДЕКСА НЕ СУЩЕСТВУЕТ!!!!!");
            return false;
        }
    }

    /**
     * Редактирует задание по индексу.
     * @param index Индекс или порядковый номер задания.
     * @return Возвращает true если оперция прошла успешно.
     */
    private boolean edit(int index, String value) {
        if (index < cases.size()) {
            planner.add(index, value);
            cases.remove(index + 1);
            return true;
        } else {
            System.out.println("ТАКОГО ИНДЕКСА НЕ СУЩЕСТВУЕТ!!!!!");
            return false;
        }
    }
}
