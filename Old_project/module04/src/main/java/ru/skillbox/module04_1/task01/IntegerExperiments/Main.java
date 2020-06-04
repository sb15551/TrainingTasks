package ru.skillbox.module04_1.task01.IntegerExperiments;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;

        Main test = new Main();
        System.out.println(test.sumDigits(123456));
    }

    public Integer sumDigits(Integer number) {
        Integer sum = 0;
        for (int i = 0; i < number.toString().length(); i++) {
            sum += Character.getNumericValue(number.toString().charAt(i));
        }
        return sum;
    }
}
