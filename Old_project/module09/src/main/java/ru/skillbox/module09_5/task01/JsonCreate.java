package ru.skillbox.module09_5.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JsonCreate {
    private Map<String, List<String>> stations = new TreeMap<>();
    private List<List<Connections>> connections = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();

    public JsonCreate(List<Line> lines, Map<String, List<String>> stations, List<List<Connections>> connections) {
        this.lines = lines;
        this.stations = stations;
        this.connections = connections;
    }

    public Map<String, List<String>> getStations() {
        return stations;
    }

}
