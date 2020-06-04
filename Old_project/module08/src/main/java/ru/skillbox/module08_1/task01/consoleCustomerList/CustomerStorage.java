package ru.skillbox.module08_1.task01.consoleCustomerList;

import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Введите команду в формате " + "\"add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722\"");
        }
        String name = components[0] + " " + components[1];
        if (validName(name) && isNumberPhone(components[3]) && validEmail(components[2])) {
            components[3] = components[3].replaceAll("([^\\d])|\\s+", "")
                                         .replaceAll("^[\\d]", "+7");
            storage.put(name, new Customer(name, components[3], components[2]));
        }
    }

    public void listCustomers()
    {
        if (storage.size() == 0) throw new IllegalArgumentException("Лист пустой!");
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        if (storage.size() == 0) throw new IllegalArgumentException("Лист пустой! Удалять нечего!");
        if (validName(name)) storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }

    public static boolean isNumberPhone(String number) {
        if (number.matches("\\+?[1-9](\\s+)?([^0-9]|\\s+)?\\d{3,4}([^0-9]|\\s+)?(\\s+)?\\d{3}([^0-9]|\\s+)?\\d{2}([^0-9]|\\s+)?\\d{2}")) {
            return true;
        } else {
            throw new IllegalArgumentException("Введите корректный номер телефона");
        }
    }

    public static boolean validEmail(String email) {
        if (email.matches(".+@.+\\..+")) {
            return true;
        } else {
            throw new IllegalArgumentException("Введите корректный email");
        }
    }

    public static boolean validName(String name) {
        if (name.matches("[A-Za-zА-Яа-я]+\\s+[A-Za-zА-Яа-я]+")) {
            return true;
        } else {
            throw new IllegalArgumentException("Введите корректные имя и фамилию");
        }
    }
}