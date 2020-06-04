package ru.skillbox.module04_5.task02;

public class Main {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus non velit vitae odio consectetur venenatis. Curabitur commodo massa vel libero faucibus, eget mattis urna cursus. Donec scelerisque imperdiet ullamcorper. Nam luctus nulla ut tincidunt malesuada. Aenean eget tellus lectus. Morbi nec rutrum leo. Nullam vel magna eu ipsum mollis consectetur.\n" +
                "\n" +
                "Suspendisse sit amet urna nec odio varius convallis. Curabitur a dignissim elit. Pellentesque lacinia posuere eros quis pellentesque. Sed sollicitudin fringilla purus, et porta ante eleifend eget. Nam vel risus feugiat, fringilla diam convallis, rhoncus ante. Mauris quis sagittis nulla. Suspendisse imperdiet aliquet arcu tincidunt gravida. Vestibulum mollis urna ipsum, sit amet posuere justo mattis et. Proin porta elit et ligula facilisis, in tincidunt nulla luctus. Nulla vel est purus. Etiam efficitur ipsum arcu. Pellentesque molestie, tortor eget ornare ultrices, velit magna bibendum turpis, in euismod enim felis a augue. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ante.";
        String[] words = text.split("([^A-z])?\\s+|\\n+|[^A-z]$");

        for (int i = 0; i < words.length; i++) {
            System.out.println(i + 1 + " - " + words[i]);
        }
    }
}
