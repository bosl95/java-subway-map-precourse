package subway.controller;

import subway.domain.DummyData;

public class MainController {
    private static boolean end;

    public MainController() {
        DummyData.load();
        end = false;
    }

    public void run() {
        while (isRunning()) {

        }
    }

    private boolean isRunning() {
        return end;
    }

    public static void printAll() {

    }

    public static void quite() {
        end = true;
    }
}
