package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.LineOutputView;

import java.util.List;

public class LineController {
    private static final LineRepository lineRepository = new LineRepository();
    private static final LineOutputView lineOutputView = new LineOutputView();

    public static void run() {

    }

    public static List<Line> informSubwayMap() {
        return lineRepository.lines();
    }
}
