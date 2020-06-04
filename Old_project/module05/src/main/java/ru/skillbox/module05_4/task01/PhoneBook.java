package ru.skillbox.module05_4.task01;

import java.util.*;

public class PhoneBook {
    private TreeMap<String, String> phoneBook = new TreeMap<String, String>();
    private static final String LN = System.lineSeparator();

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        String command = getCommand().trim();

        while (!command.equalsIgnoreCase("q")) {

            if (command.equalsIgnoreCase("list")) {
                printPhoneBook(book.phoneBook);
            } else if (isName(command)) {                           // Определяем имя это или нет

                if (book.phoneBook.containsValue(command)) {        // Выясняем имеется ли такое имя в книге
                    System.out.println("Такое имя уже существует." + LN);
                    for (String key : book.phoneBook.keySet()) {    // Если такое имя встречается, выводим всех с таким именем
                        if (book.phoneBook.get(key).equalsIgnoreCase(command)) {
                            System.out.println(command + " -> " + key);
                        }
                    }
                } else {                                            // Если нет такого имени, то сохраняем и запрашиваем номер телефона
                    book.phoneBook.put(getNumberPhone(), command);
                    System.out.println("Added!" + LN);
                }

            } else if (isNumberPhone(command)) {                    // Определяем номер телефона это или нет

                if (book.phoneBook.containsKey(command)) {          // Выясняем имеется ли такой номер в книге
                    System.out.println("Такой номер уже сущесвует." + LN);
                    System.out.println(book.phoneBook.get(command) + " - " + command);      // Если такой номер встречается, то выводим его
                } else {                                            // Если нет такого номера, то сохраняем и запрашиваем для него имя
                    book.phoneBook.put(command, getName());
                    System.out.println("Added!" + LN);
                }

            } else {
                System.out.println("Введите корректное значение!" + LN);
            }
            command = getCommand().trim();
        }
    }

    /**
     * Получаем команду для работы с программой.
     * @return Возвращает введенную команду. Если был введен номер телефона, то возвращает его в формате +79991234567.
     */
    private static String getCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя или номер телефона");
        String command = scanner.nextLine();
        if (isNumberPhone(command)) {
            command = command.replaceAll("([^0-9])|\\s+", "");
            command = command.replaceAll("^[^+7]", "+7");
            return command;
        }
        return command;
    }

    /**
     * Вводим имя. Вызывается если getCommand() вернул валидный номер телефона.
     * @return Возвращает имя или ФИО полностью.
     */
    private static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(LN + "Введите имя абонента!");
        String name = scanner.nextLine();
        if (isName(name)) {
            return name;
        } else {
            System.out.println(LN + "НЕ ВЕРНО!!!!  Введите корректное имя абонента!");
            return getNumberPhone();
        }
    }

    /**
     * Вводим номер телефона. Вызывается если getCommand() вернул валидное имя.
     * @return Возвращает номер телефона в формате +79991234567.
     */
    private static String getNumberPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(LN + "Введите номер телефона в любом формате!");
        String number = scanner.nextLine();
        if (isNumberPhone(number)) {
            number = number.replaceAll("([^0-9])|\\s+", "");
            number = number.replaceAll("^[^+7]", "+7");
            return number;
        } else {
            System.out.println("НЕ ВЕРНО!!!!  Введите номер телефона в любом формате!" + LN);
            return getNumberPhone();
        }
    }

    /**
     * Выводит на экран телефнную книгу.
     * @param book Телефонная книга.
     */
    public static void printPhoneBook(Map<String, String> book) {
        for (Map.Entry value : sortedMapByValues(book)) {
            System.out.println(value.getValue() + " -> " + value.getKey());
        }
    }

    /**
     * Сортирует телефонную книгу в алфавитном порядке с учетом регистра.
     * @param map Телефонная книга.
     * @param <K> Ключ - номер телефона.
     * @param <V> Значение - имя, чей номер телефона.
     * @return Телефонная книга в алфавитном порядке.
     */
    private static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> sortedMapByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    /**
     * Проверяет является ли передаваемая строка именем.
     * @param name Имя или ФИО полностью.
     * @return True если в имени нет лишних символов(цифр, знаков препинания и т.д.).
     */
    private static boolean isName(String name) {
        return name.matches("[A-Za-zА-Яа-я\\s+?]+");
    }

    /**
     * Проверяет является ли передаваемая строка номером телефона.
     * @param number Номер телефона.
     * @return True если это номер телефона.
     */
    private static boolean isNumberPhone(String number) {
        return number.matches("\\+?[1-9](\\s+)?([^0-9]|\\s+)?\\d{3,4}([^0-9]|\\s+)?(\\s+)?\\d{3}([^0-9]|\\s+)?\\d{2}([^0-9]|\\s+)?\\d{2}");
    }
}
