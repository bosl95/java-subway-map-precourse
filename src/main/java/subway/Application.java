package subway;

import subway.controller.MainController;
import subway.domain.DummyData;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DummyData.load();
        MainController mainController = new MainController();
        mainController.run();
    }
}
