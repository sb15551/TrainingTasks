package ru.skillbox.module04_4.task01;

public class Main {
    public static void main(String[] args) {
        for (char i = 'A'; i <= 'z'; i++) {
            if (!(i > 'Z' && i < 'a')) System.out.println(i + " - " + ((int) i));
        }
    }
}
