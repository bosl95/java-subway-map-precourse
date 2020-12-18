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
            mainMenu.start();
        } catch (InvalidMenuInputException e) {
            mainMenu = MainMenu.setRunningState();
        }
    }

    private String inputMainMenu() {
        try {
            mainOutputView.selectMenu();
            String menu = inputView.selectMenu();
            return menu;
        } catch (NullPointerException e) {
            return inputMainMenu();
        }
    }

    public static void printAll() {
        MainOutputView.printSubwayMap(LineController.informSubwayMap());
    }
}
