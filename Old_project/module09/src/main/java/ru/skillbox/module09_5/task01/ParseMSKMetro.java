package ru.skillbox.module09_5.task01;

import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.*;

public class ParseMSKMetro {
    private static String url = "https://ru.wikipedia.org/wiki/Список_станций_Московского_метрополитена";
    public static String saveFile = "module09/src/main/resources/mapMSKMetro.json";

    private static List<Line> lines = new ArrayList<>();
    private static List<List<Connections>> connections = new ArrayList<>();
    private static Map<String, List<String>> stations = new TreeMap<>();
    private static Elements elements;

    public static void create() {
        try {
            initStationsAndLines();
            initConnections();
            Collections.sort(lines, Comparator.naturalOrder());
            Collections.sort(connections, new Comparator<List<Connections>>() {
                @Override
                public int compare(List<Connections> o1, List<Connections> o2) {
                    return o1.size() - o2.size();
                }
            });

            JsonCreate jsonObjects = new JsonCreate(lines, stations, connections);

            String json = new GsonBuilder()
                    .setPrettyPrinting()
                    .disableHtmlEscaping()
                    .create()
                    .toJson(jsonObjects);

            FileWriter write = new FileWriter(saveFile, false);
            write.write(json);
            write.flush();
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Парсит таблицу на странице википедии "Список станций Московского метрополитена".
     * @return Возвращает строки этой таблицы типа Elements.
     * @throws IOException
     */
    private static Elements getTable() throws IOException {
        Document doc = Jsoup.connect(url).get();
        List<Element> monorailList = new ArrayList<>();
        List<Element> centralRingList = new ArrayList<>();

        Element table = doc.select("table.standard").first();   // Парсим основную таблицу со станциями
        Elements rows = table.select("tr");
        rows.remove(0);

        Element monorail = doc.select("table.standard").get(1);     // Парсим монорельс
        monorail.select("tr").forEach(row -> monorailList.add(row));
        monorailList.remove(1);
        monorailList.remove(0);
        rows.addAll(monorailList);

        Element centralRing = doc.select("table.standard").get(2);      // Парсим Московское центральное кольцо
        centralRing.select("tr").forEach(row -> centralRingList.add(row));
        centralRingList.remove(1);
        centralRingList.remove(0);
        rows.addAll(centralRingList);
        return rows;
    }

    /**
     * Парсит строки таблицы на странице википедии,
     * и добавляет линии и станции в переменные lines и stations.
     * @throws IOException
     */
    private static void initStationsAndLines() throws IOException {
        elements = getTable();
        List<String> lineEquals = new ArrayList<>();
        List<String> stationsInLines = new ArrayList<>();

        for (Element row : elements) {
            String station = row.select("td").get(1).select("a").get(0).text();
            Element line = row.select("td").get(0);

            String lineNumber = line.select("span").get(0).text();
            String lineName = line.select("span").attr("title");
            String lineColor = line.attr("style");
            String lineColorCode = lineColor.replaceAll(".+#|\\)\\);", "");

            if (!row.attr("class").equals("shadow")) {

                if (!lineEquals.contains(lineNumber)) {

                    if (!stationsInLines.isEmpty()) {
                        stations.put(lineEquals.get(lineEquals.size() - 1), new ArrayList<>(stationsInLines));
                        stationsInLines.clear();
                    }

                    int R = Integer.parseInt(lineColorCode.substring(0, 2), 16);
                    int G = Integer.parseInt(lineColorCode.substring(2, 4), 16);
                    int B = Integer.parseInt(lineColorCode.substring(4), 16);
                    lines.add(new Line(lineNumber, lineName, Line.getNameColor(new Color(R, G, B))));
                    lineEquals.add(lineNumber);
                    stationsInLines.add(station);
                } else {
                    stationsInLines.add(station);
                }

            }
            stations.put(lineEquals.get(lineEquals.size() - 1), new ArrayList<>(stationsInLines));
        }
    }

    /**
     * Инициализируем переходы.
     */
    private static void initConnections() {
        List<Connections> connect = new ArrayList<>();
        for (Element row : elements) {
            if (!row.attr("class").equals("shadow")) {
                String station = row.select("td").get(1).select("a").get(0).text();
                Element line = row.select("td").get(0);
                String lineNumber = line.select("span").get(0).text();
                Element connectStation = row.select("td").get(3);

                if (!connectStation.select("span").isEmpty()) {
                    connect.clear();
                    String lineNumberTemp = new String();
                    String lineStationTemp = new String();

                    connect.add(new Connections(lineNumber, station));

                    for (Element span : connectStation.select("span")) {
                        if (span.attr("class").equals("sortkey")) {
                            lineNumberTemp = span.text();
                        }

                        if (!span.attr("title").isEmpty()) {
                            lineStationTemp = span.attr("title").replaceAll(
                                    "Переход на станцию |Кросс-платформенная пересадка на станцию ", "");
                            if (!lineNumberTemp.equals("011А")) {
                                connect.add(new Connections(lineNumberTemp, getStationConnect(lineNumberTemp, lineStationTemp)));
                            }
                        }
                    }
                    Collections.sort(connect);
                    if (!connections.contains(connect)) {
                        connections.add(new ArrayList<>(connect));
                    }
                }
            }
        }
    }

    /**
     * В названии перехода убираем все лишнее и оставляем только нименование станции.
     * @param line
     * @param station
     * @return
     */
    private static String getStationConnect(String line, String station) {
        String[] arrTemp = station.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrTemp.length; i++) {
            stringBuilder.append(arrTemp[i]);
            for (String key : stations.keySet()) {
                if (key.equals(line)) {
                    if (stations.get(key).contains(stringBuilder.toString())) {
                        return stringBuilder.toString();
                    }
                    stringBuilder.append(" ");
                }
            }
        }
        return "null";
    }
}
