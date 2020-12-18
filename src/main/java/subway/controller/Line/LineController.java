package subway.controller.Line;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.menu.LineMenu;
import subway.view.InputView;
import subway.view.LineOutputView;

import java.util.List;

public class LineController implements Controller {
    private static final LineRepository lineRepository = new LineRepository();
    private static LineOutputView lineOutputView;
    private static LineFunction lineFunction;
    private LineMenu lineMenu;

    public LineController() {
        lineOutputView = new LineOutputView();
        lineFunction = new LineFunction();
    }

    @Override
    public void run() {
        lineOutputView.printLineMenu(LineMenu.list());
        lineMenu = LineMenu.findMenu(inputLineMenu());
        lineMenu.run();
    }

    private String inputLineMenu() {
        try {
            lineOutputView.selectMenu();
            String menu = InputView.selectMenu();
            return menu;
        } catch (NullPointerException e) {
            return inputLineMenu();
        }
    }

    public static List<Line> informSubwayMap() {
        return lineRepository.lines();
    }

    public static void register() {
        lineFunction.registerLine(lineOutputView);
    }

    public static void delete() {
        lineFunction.deleteLine(lineOutputView);
    }

    public static void print() {
        System.out.println("노선 조회");
    }
}
