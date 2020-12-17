package subway.domain;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new LinkedList<>();

    public static Line valueOf(String name, List<String> stations) {
        return new Line(name, stations);
    }

    public static void addAll(List<Line> dummyLines) {
        lines.addAll(dummyLines);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
