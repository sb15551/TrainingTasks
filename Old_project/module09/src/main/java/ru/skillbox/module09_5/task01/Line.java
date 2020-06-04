package ru.skillbox.module09_5.task01;

import java.awt.*;

public class Line implements Comparable<Line> {
    private String number;
    private String name;
    private String color;

    public Line(String number, String name, String color) {
        this.number = number;
        this.name = name;
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public static String getNameColor(Color color) {
        if (approximatelyEqual(color, 239, 22, 30)) return "Red";       // 1
        if (approximatelyEqual(color, 45, 190, 44)) return "Green";     // 2
        if (approximatelyEqual(color, 0, 120, 190)) return "Dark blue"; // 3
        if (approximatelyEqual(color, 0, 191, 255)) return "Blue"; // 4
        if (approximatelyEqual(color, 141, 91, 45)) return "Brown";      // 5
        if (approximatelyEqual(color, 237, 145, 33)) return "Orange";         // 6
        if (approximatelyEqual(color, 128, 0, 128)) return "Violet";          // 7
        if (approximatelyEqual(color, 255, 215, 2)) return "Yellow";          // 8 8A
        if (approximatelyEqual(color, 153, 153, 153)) return "Grey";        // 9
        if (approximatelyEqual(color, 153, 204, 0)) return "Light green";          // 10
        if (approximatelyEqual(color, 130, 192, 192)) return "Turquoise";        // 11
        if (approximatelyEqual(color, 161, 179, 212)) return "Blue gray";        // 12
        if (approximatelyEqual(color, 222, 100, 161)) return "Pink";
        return null;
    }

    private static boolean approximatelyEqual(Color color, int r, int g, int b) {
        int delta = 10;
        if (color.getRed() >= r - delta && color.getRed() <= r + delta &&
                color.getGreen() >= g - delta && color.getGreen() <= g + delta &&
                color.getBlue() >= b - delta && color.getBlue() <= b + delta)
            return true;
        return false;
    }

    @Override
    public int compareTo(Line o) {
        return this.number.compareTo(o.getNumber());
    }
}
