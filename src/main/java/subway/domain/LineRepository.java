package subway.domain;

import subway.utils.exception.NotExistLineException;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new LinkedList<>();

    public static Line valueOf(String name, List<String> stations) {
        return new Line(name, stations);
    }

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
}
