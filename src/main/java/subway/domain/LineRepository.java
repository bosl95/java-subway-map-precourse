package subway.domain;

import subway.utils.exception.NotExistLineException;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new LinkedList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        if (!LineRepository.hasLine(name)) {
            throw new NotExistLineException();
        }
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean hasStationInAnyLine(String name) {
        return lines.stream()
                .anyMatch(line -> line.contains(name));
    }

    public static boolean hasLine(String name) {
        return lines.stream()
                .anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static boolean hasStationOfLine(String stationName, String lineName) {
        return findLine(lineName)
                .get()
                .contains(stationName);
    }

    public static int lineLength(String name) {
        return findLine(name)
                .get()
                .getLength();
    }

    public static void addLine(String lineName, String station, String order) {
        findLine(lineName)
                .get()
                .add(order, station);
    }

    private static Optional<Line> findLine(String lineName) {
        return lines.stream()
                .filter(line -> Objects.equals(line.getName(), lineName))
                .findAny();
    }
}
