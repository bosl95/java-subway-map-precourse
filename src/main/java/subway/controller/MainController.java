package subway.controller;

import subway.domain.DummyData;
import subway.view.MainOutputView;

public class MainController {
    private static boolean end;

    public MainController() {
        DummyData.load();
        end = true;
    }

    public void run() {
        while (isRunning()) {
            MainOutputView.printMainMenu();
            inputMainMenu();
        }
    }

    public static void printAll() {

    }

    private void inputMainMenu() {
        mainOutputView.selectMainMenu();
        inputView.selectMainMenu();
    }

    private boolean isRunning() {
        return end;
    }

    public static void printAll() {

    }

    public static void quite() {
        end = false;
    }
}
