package ru.skillbox.module05_1.task01;

public class Main {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать где, сидит фазан";
        String[] colors = text.split(",?\\s+");

        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }
        colors = reverseArray(colors);
        System.out.println(System.lineSeparator() + "Вывод строки наоборот" + System.lineSeparator());
        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }
    }

    /**
     * Переворачивает массив, последний элемент стал первым, первый - последним и т.д.
     * @param array Массив который нужно перевернуть.
     * @return Перевернутый массив.
     */
    public static String[] reverseArray(String[] array) {
        int len = array.length;
        String[] temp = new String[len];
        for (int i = 0; i < len; i++) {
            temp[i] = array[len - i - 1];
        }
        return temp;
    }
}
