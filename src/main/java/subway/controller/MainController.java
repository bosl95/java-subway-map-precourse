package subway.controller;

import subway.domain.menu.MainMenu;
import subway.view.InputView;
import subway.view.MainOutputView;

public class MainController {
    MainOutputView mainOutputView;
    InputView inputView;
    MainMenu mainMenu;

    public MainController() {
        mainOutputView = new MainOutputView();
        inputView = new InputView();
    }

    public static void quite() {
        MainOutputView.quiteProgram();
    }

    public void run() {
        do {
            MainOutputView.printMainMenu();
            mainMenu = MainMenu.fineMenu(inputMainMenu());
            mainMenu.run();
        } while (mainMenu.isRunning());
    }

    public static void printAll() {

    }

    private String inputMainMenu() {
        try {
            mainOutputView.selectMainMenu();
            String menu = inputView.selectMainMenu();
            return menu;
        } catch (NullPointerException e) {
            return inputMainMenu();
        }
    }
}
