package ru.skillbox.module09_2.task01;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;

public class CopyFolder {
    private static File src = new File("08_ExceptionsDebuggingAndTesting");
    private static File dst = new File("module09/src/main/resources/dest/");

    public static void main(String[] args) {
        try {
            if (dst.exists()) FileUtils.deleteDirectory(dst);
            FileUtils.copyDirectory(src, dst);      // Копирование с помощью FileUtils

            if (dst.exists()) FileUtils.deleteDirectory(dst);
            copyDirectory(src, dst);                // Копирование с помощью рекурсии
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    private static void copyDirectory(File src, File dst) throws IOException {
        System.out.printf("Копируем каталог: %s", src);
        dst.mkdir();
        File nextSrcFile;
        String nextSrcFilename, nextDstFilename;
        for (String filename : src.list()) {
            nextSrcFilename = src.getPath()
                    + File.separator + filename;
            nextDstFilename = dst.getPath()
                    + File.separator + filename;
            nextSrcFile = new File(nextSrcFilename);
            if (nextSrcFile.isDirectory()) {
                copyDirectory(new File(nextSrcFilename), new File(nextDstFilename));
            } else {
                copyFile(new File(nextSrcFilename), new File(nextDstFilename));
            }
        }
    }

    private static void copyFile(File src, File dst) throws IOException {
        System.out.printf("Копируем файл: %s", src);
        Files.copy(src.toPath(), dst.toPath());
    }
}
