package subway.controller;

import subway.domain.menu.MainMenu;
import subway.utils.exception.InvalidMenuInputException;
import subway.view.InputView;
import subway.view.MainOutputView;

public class MainController implements Controller {
    MainOutputView mainOutputView;
    InputView inputView;
    MainMenu mainMenu;

    public MainController() {
        mainOutputView = new MainOutputView();
        inputView = new InputView();
    }

    @Override
    public void run() {
        do {
            MainOutputView.printMainMenu(MainMenu.list());
            selectMenu();
        } while (mainMenu.isRunning());
    }

    private void selectMenu() {
        try {
            mainMenu = MainMenu.fineMenu(inputMainMenu());
            menuStart();
        } catch (InvalidMenuInputException e) {
            mainMenu = MainMenu.setRunningState();
        }
    }

    private String inputMainMenu() {
        try {
            mainOutputView.selectMainMenu();
            String menu = inputView.selectMenu();
            return menu;
        } catch (NullPointerException e) {
            return inputMainMenu();
        }
    }

    private void menuStart() {
        Controller controller = mainMenu.getController();
        controller.run();
    }

    public static void printAll() {
        MainOutputView.printSubwayMap(LineController.informSubwayMap());
    }
}
