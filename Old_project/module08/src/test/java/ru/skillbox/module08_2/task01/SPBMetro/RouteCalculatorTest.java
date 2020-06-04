package ru.skillbox.module08_2.task01.SPBMetro;

import junit.framework.TestCase;
import ru.skillbox.module08_2.task01.SPBMetro.core.Line;
import ru.skillbox.module08_2.task01.SPBMetro.core.Station;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    ArrayList<Line> lines = new ArrayList<>();
    List<Station> stations = new ArrayList<>();
    StationIndex stationIndex;
    RouteCalculator routeCalculator;
    List<Station> connectionsStations;


    @Override
    protected void setUp() throws Exception {
        stationIndex = new StationIndex();
        for (int i = 1; i <= 3 ; i++) {
            lines.add(new Line(i, "Line_" + i));
        }

        for (int i = 1, line = 1; line <= 3; i++) {
            Station temp = new Station("Station " + line + "_" + i, lines.get(line - 1));
            stations.add(temp);
            lines.get(line - 1).addStation(temp);
            stationIndex.addStation(temp);
            if (i == 4) {
                line++;
                i = 0;
            }
        }

        lines.forEach(line -> stationIndex.addLine(line));

        stationIndex.addConnection(getConnections("Station 1_3", "Station 2_2"));
        stationIndex.addConnection(getConnections("Station 2_3", "Station 3_2"));

        routeCalculator = new RouteCalculator(stationIndex);
    }

    public List<Station> getConnections(String ... stationConnections) {
        connectionsStations = new ArrayList<>();
        connectionsStations.clear();
        for (Station station : stations) {
            for (String item : stationConnections)
                if (station.getName().equals(item))
                    connectionsStations.add(station);
        }
        return connectionsStations;
    }

    public List<Station> getList(String ... expectedStations) {
        ArrayList<Station> result = new ArrayList<>();
        for (Station station : stations) {
            for (String item : expectedStations) {
                if (station.getName().equals(item)) result.add(station);
            }
        }
        return result;
    }

    public Station getStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName))
                return station;
        }
        return null;
    }

    public void testGetShortestRoute() {
        List<Station> actual = routeCalculator.getShortestRoute(
                getStation("Station 1_1"),
                getStation("Station 1_4")
        );
        List<Station> expected = getList(
                "Station 1_1",
                "Station 1_2",
                "Station 1_3",
                "Station 1_4"
                );
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(
                getStation("Station 1_1"),
                getStation("Station 2_4")
        );
        List<Station> expected = getList(
                "Station 1_1",
                "Station 1_2",
                "Station 1_3",
                "Station 2_2",
                "Station 2_3",
                "Station 2_4"
        );
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithTwoConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(
                getStation("Station 1_1"),
                getStation("Station 3_4")
        );
        List<Station> expected = getList(
                "Station 1_1",
                "Station 1_2",
                "Station 1_3",
                "Station 2_2",
                "Station 2_3",
                "Station 3_2",
                "Station 3_3",
                "Station 3_4"
        );
        assertEquals(expected, actual);
    }

    public void testCalculateDuration() {
        List<Station> way = routeCalculator.getShortestRoute(
                getStation("Station 1_1"),
                getStation("Station 1_4")
        );
        double actual = RouteCalculator.calculateDuration(way);
        double expected = 7.5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationWithOneConnection() {
        List<Station> way = routeCalculator.getShortestRoute(
                getStation("Station 1_1"),
                getStation("Station 2_4")
        );
        double actual = RouteCalculator.calculateDuration(way);
        double expected = 13.5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationWithTwoConnection() {
        List<Station> way = routeCalculator.getShortestRoute(
                getStation("Station 1_1"),
                getStation("Station 3_4")
        );
        double actual = RouteCalculator.calculateDuration(way);
        double expected = 19.5;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
