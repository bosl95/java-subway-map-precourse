package subway.domain.menu;

import subway.controller.LineController;
import subway.controller.MainController;
import subway.controller.SectionController;
import subway.controller.StationController;

import java.util.Arrays;
import java.util.Objects;

public enum MainMenu {
    STATION("1", StationController::run),
    LINE("2", LineController::run),
    SECTION("3", SectionController::run),
    PRINT_ALL("4", MainController::printAll),
    QUITE("Q", MainController::quite);

    private String button;
    private Runnable function;

    MainMenu(String inputButton, Runnable runnable) {
        button = inputButton;
        function = runnable;
    }

    public boolean isRunning() {
        try {
            return !Objects.equals(MainMenu.QUITE.button, this.button);
        } catch (NullPointerException e) {
            return true;
        }
    }

    public static MainMenu fineMenu(String name) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> Objects.equals(menu.button, name))
                .findAny()
                .get();
    }

    public void run() {
        function.run();
    }
}
