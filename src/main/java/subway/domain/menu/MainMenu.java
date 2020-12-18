package subway.domain.menu;

import subway.controller.*;
import subway.controller.Line.LineController;
import subway.controller.Station.StationController;
import subway.controller.section.SectionController;
import subway.utils.exception.InvalidMenuInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum MainMenu {
    STATION("1", "1. 역 관리\n", new StationController()),
    LINE("2", "2. 노선 관리\n", new LineController()),
    SECTION("3", "3. 구간 관리\n", new SectionController()),
    PRINT_ALL("4", "4. 지하철 노선도 출력\n", MainController::printAll),
    QUITE("Q", "Q. 종료\n", null);

    private String button;
    private String menu;
    private Controller controller;

    MainMenu(String button, String menu, Controller controller) {
        this.button = button;
        this.menu = menu;
        this.controller = controller;
    }

    public static List<String> list() {
        return Arrays.stream(MainMenu.values())
                .map(mainMenu -> mainMenu.menu)
                .collect(Collectors.toList());
    }

    public static MainMenu fineMenu(String name) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> Objects.equals(menu.button, name))
                .findAny()
                .orElseThrow(() -> new InvalidMenuInputException());
    }

    public boolean isRunning() {
        return !Objects.equals(MainMenu.QUITE, this);
    }

    public static MainMenu setRunningState() {
        return MainMenu.STATION;    // just for running state
    }

    public Controller getController() {
        return this.controller;
    }

    public void start() {
        if (isRunning()) {
            this.controller.run();
        }
    }
}
