import java.util.Objects;

public class Connections implements Comparable<Connections> {
    private String line;
    private String station;

    public Connections(String line, String station) {
        this.line = line;
        this.station = station;
    }

    public String getLine() {
        return line;
    }

    public String getStation() {
        return station;
    }


    @Override
    public int compareTo(Connections o) {
        return this.line.compareTo(o.getLine());
    }

    @Override
    public String toString() {
        return "Connections{" +
                "line='" + line + '\'' +
                ", station='" + station + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connections that = (Connections) o;
        return Objects.equals(line, that.line) &&
                Objects.equals(station, that.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, station);
    }
}
