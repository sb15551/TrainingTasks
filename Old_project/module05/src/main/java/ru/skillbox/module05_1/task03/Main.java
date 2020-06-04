package ru.skillbox.module05_1.task03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printCross(createCross());
    }

    /**
     * Создаем крестик.
     * @return
     */
    public static int[][] createCross() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность крестика: ");
        int dimension = scanner.nextInt();
        int[][] cross = new int[dimension][dimension];
        return cross;
    }

    /**
     * Печатаем крестик.
     * @param cross
     */
    public static void printCross(int[][] cross) {
        for (int i = 0; i < cross.length; i++) {
            for (int j = 0; j < cross.length; j++) {
                System.out.print((i - j == 0 || i + j == cross.length - 1) ? "X" : " ");
            }
            System.out.println();
        }
    }
}
