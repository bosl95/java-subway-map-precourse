package subway.controller;

import subway.domain.menu.StationMenu;
import subway.view.InputView;
import subway.view.StationOutputView;

public class StationController implements Controller {
    StationOutputView stationOutputView;
    StationMenu stationMenu;

    public StationController() {
        stationOutputView = new StationOutputView();
    }

    @Override
    public void run() {
        do {
            stationOutputView.printStationMenu(StationMenu.list());
            stationMenu = StationMenu.fineMenu(inputStationMenu());
            stationMenu.run();
        } while (stationMenu.isRunning());
    }

    private String inputStationMenu() {
        try {
            stationOutputView.selectMenu();
            String menu = InputView.selectMenu();
            return menu;
        } catch (NullPointerException e) {
            return inputStationMenu();
        }
    }

    public static void register() {
        System.out.println("역 등록하기\n");
    }

    public static void delete() {
        System.out.println("역 삭제하기\n");
    }

    public static void print() {
        System.out.println("역 조회하기\n");
    }
}
