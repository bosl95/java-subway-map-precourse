package subway.domain.menu;

import subway.controller.LineController;

enum LineMenu {
    REGISTER("1", LineController::registerStation);


    private String button;
    Runnable runnable;

    LineMenu(String button, Runnable registerStation) {
        this.button = button;
        this.runnable = registerStation;
    }

    void run() {

    }
}
