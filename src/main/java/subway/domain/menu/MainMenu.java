package subway.domain.menu;

import subway.controller.*;


import java.util.Arrays;
import java.util.Objects;

public enum MainMenu {
    STATION("1", new StationController()),
    LINE("2", new LineController()),
    SECTION("3", new SectionController()),
    PRINT_ALL("4", MainController::printAll),
    QUITE("Q", MainController::quite);

    private String button;
    private Controller controller;

    MainMenu(String inputButton, Controller controller) {
        button = inputButton;
        this.controller = controller;
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

    public Controller getController() {
        return this.controller;
    }
}
