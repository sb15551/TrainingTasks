package ru.skillbox.module04_4.task02.stringExperiments;

public class Loader {
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String[] phrase = text.split(",");
        int[] income = new int[phrase.length];

        for (int i = 0; i < phrase.length; i++) {
            String[] words = phrase[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                if (isDigit(words[j])) {
                    income[i] = Integer.parseInt(words[j]);
                }
            }
        }
        System.out.println("Доход Васи и Маши составляет " + (income[0] + income[2]) + " рублей");
    }

    public static boolean isDigit(String str) {
        boolean result = false;
        for (int i = 0; i < str.length(); i++) {
            result = Character.isDigit(str.charAt(i));
        }
        return result;
    }
}