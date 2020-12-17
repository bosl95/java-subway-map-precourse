package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private List<String> stations = new LinkedList<>();

    public Line(String name, List<String> stations) {
        this.name = name;
        stations.addAll(stations);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
