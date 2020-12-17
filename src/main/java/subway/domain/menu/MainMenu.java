package subway.domain.menu;

import subway.controller.LineController;
import subway.controller.MainController;
import subway.controller.SectionController;
import subway.controller.StationController;

public enum MainMenu {
    STATION("1", () -> new StationController()),
    LINE("2", () -> new LineController()),
    SECTION("3", () -> new SectionController()),
    PRINT_ALL("4", MainController::printAll),
    QUITE("Q", MainController::quite);

    private String button;
    private Runnable runnable;

    MainMenu(String button, Runnable runnable) {
        this.button = button;
        this.runnable = runnable;
    }
}
