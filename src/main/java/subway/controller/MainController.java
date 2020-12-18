package subway.controller;

import subway.domain.menu.MainMenu;
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
            mainMenu = MainMenu.fineMenu(inputMainMenu());
            menuStart();
        } while (mainMenu.isRunning());
    }

    public static void quite() {
        MainOutputView.quiteProgram();
    }

    public static void printAll() {
        MainOutputView.printSubwayMap(LineController.informSubwayMap());
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

    private void menuStart() {
        Controller controller = mainMenu.getController();
        controller.run();
    }
}
