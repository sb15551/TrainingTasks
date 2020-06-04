package ru.skillbox.module05_5.task01;

import java.util.*;

public class BeautifulNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер автомобиля в формате А123ВС163");
        String beautyNumber = scanner.nextLine().toUpperCase().trim();
        ArrayList<String> numbersCar = generateNumbersCar();
        boolean result;

        long start = System.nanoTime();
        result = numbersCar.contains(beautyNumber);
        long finish = System.nanoTime() - start;
        System.out.println("Поиск перебором: " + (result ? "номер найден" : "номер не найден") + ", поиск занял " + finish + "нс");

        start = System.nanoTime();
        result = Collections.binarySearch(numbersCar, beautyNumber) > 0;
        finish = System.nanoTime() - start;
        System.out.println("Бинарный поиск: " + (result ? "номер найден" : "номер не найден") + ", поиск занял " + finish + "нс");

        HashSet<String> hashSet = new HashSet<>(numbersCar);
        start = System.nanoTime();
        result = hashSet.contains(beautyNumber);
        finish = System.nanoTime() - start;
        System.out.println("Поиск в HashSet: " + (result ? "номер найден" : "номер не найден") + ", поиск занял " + finish + "нс");

        TreeSet<String> treeSet = new TreeSet<>(numbersCar);
        start = System.nanoTime();
        result = treeSet.contains(beautyNumber);
        finish = System.nanoTime() - start;
        System.out.println("Поиск в TreeSet: " + (result ? "номер найден" : "номер не найден") + ", поиск занял " + finish + "нс");
    }

    /**
     * Генерирует список красивых автомобильных номеров, где все цифры одинаковые.
     * @return ArrayList со списком красивых номеров.
     */
    public static ArrayList<String> generateNumbersCar() {
        ArrayList<String> numbersCar = new ArrayList<>();
        ArrayList<String> series = generateSeries();
        StringBuilder number = new StringBuilder();
        for (int num = 1; num < 9; num++) {
            for (String letter : series) {
                for (int region = 1; region < 200; region++) {
                    number.append(letter.substring(0, 1));
                    number.append(num * 111);
                    number.append(letter.substring(1));
                    number.append(addZero(String.valueOf(region)));
                    numbersCar.add(String.valueOf(number));
                    number.setLength(0);
                }
            }
        }
        Collections.sort(numbersCar);
        return numbersCar;
    }

    /**
     * Генерирует серии (буквенную часть) автомобильных номеров в алфавитном порядке.
     * @return Отсортированный ArrayList с сериями автомобильных номеров.
     */
    public static ArrayList<String> generateSeries() {
        char[] alphabet = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        ArrayList<String> series = new ArrayList<>();
        StringBuilder letters = new StringBuilder();
        for (char letter1 : alphabet) {
            for (char letter2 : alphabet){
                for (char letter3 : alphabet) {
                    letters.append(letter1);
                    letters.append(letter2);
                    letters.append(letter3);
                    series.add(String.valueOf(letters));
                    letters.setLength(0);
                }
            }
        }
        return series;
    }

    /**
     * Добавляет '0' если он требуется в части номера где указан код региона.
     * @param regionCode Код региона.
     * @return Возвращает код региона с '0' если он требуется.
     */
    public static String addZero(String regionCode) {
        if (regionCode.length() == 1) {
            StringBuilder newNumber = new StringBuilder();
            newNumber.append("0");
            newNumber.append(regionCode);
            return String.valueOf(newNumber);
        }
        return regionCode;
    }
}
