package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.LineOutputView;

import java.util.List;

public class LineController implements Controller {
    private static final LineRepository lineRepository = new LineRepository();
    private static final LineOutputView lineOutputView = new LineOutputView();


    @Override
    public void run() {
        System.out.println("line controller");
    }

    public static List<Line> informSubwayMap() {
        return lineRepository.lines();
    }
}
