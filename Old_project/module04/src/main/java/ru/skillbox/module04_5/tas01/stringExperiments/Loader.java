package ru.skillbox.module04_5.tas01.stringExperiments;

public class Loader {
    public static void main(String[] args)     {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String[] phrase = text.split(",\\s+(а\\s+)?");
        int sum = 0;

        for (int i = 0; i < phrase.length; i++) {
            sum += Integer.parseInt(phrase[i].replaceAll("[^\\d]", ""));
        }
        System.out.println("Всего друзья заработали " + sum + " рублей");
    }
}