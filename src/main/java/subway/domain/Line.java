package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private List<String> stations = new LinkedList<>();

    public Line(String name, List<String> dummyStations) {
        this.name = name;
        stations.addAll(dummyStations);
    }

    public static Line from(String name, List<String> stations) {
        return new Line(name, stations);
    }

    public String getName() {
        return name;
    }

    public List<String> informStations() {
        return Collections.unmodifiableList(stations);
    }

    public boolean contains(String name) {
        return stations.contains(name);
    }
}
