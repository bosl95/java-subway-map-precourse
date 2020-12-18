package subway.controller.Station;

import subway.controller.Controller;
import subway.domain.menu.StationMenu;
import subway.view.InputView;
import subway.view.StationOutputView;

public class StationController implements Controller {
    private static StationFunction stationFunction;
    protected static StationOutputView stationOutputView;
    private StationMenu stationMenu;

    public StationController() {
        stationOutputView = new StationOutputView();
        stationFunction = new StationFunction();
    }

    @Override
    public void run() {
        stationOutputView.printStationMenu(StationMenu.list());
        stationMenu = StationMenu.fineMenu(inputStationMenu());
        stationMenu.run();
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
        stationFunction.registerStation(stationOutputView);
    }

    public static void delete() {
        stationFunction.deleteStation();
    }

    public static void print() {
        stationFunction.printStations(stationOutputView);
    }
}