package ru.skillbox.module09_5.task01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ParseMSKMetro.create();
        Gson gson = new GsonBuilder().create();
        try {
            String json = Files.readString(Paths.get(ParseMSKMetro.saveFile));
            JsonCreate jsonCreate = gson.fromJson(json, JsonCreate.class);
            jsonCreate.getStations().forEach((k, v) -> System.out.printf("На %s линии %d станций\n", k, v.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
