package ru.skillbox.module09_1.task01;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SizeContent {
    private static final String LN = System.lineSeparator();

    public static void main(String[] args) {
        String path = "module09/src/main/resources";
        try {
            Files.walk(Paths.get(path))
                    .filter(file -> file.toFile().isFile())
                    .map(Path::toFile)
                    .peek(f -> System.out.println(f.getName() + " - " + sizeConverter(f.length())))
                    .map(File::length)
                    .reduce((l1, l2) -> l1 + l2)
                    .ifPresent(l -> System.out.println("Размер целевой директории: " + sizeConverter(l)));
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    private static String sizeConverter(long size) {
        if (size < 1024) return size + " Б";
        int exp = (int) (Math.log(size) / (Math.log(1024)));
        char unitsPrefix = "КМГТПЭ".charAt(exp - 1);
        return String.format("%.2f %sБ", size / Math.pow(1024, exp), unitsPrefix);
    }
}
