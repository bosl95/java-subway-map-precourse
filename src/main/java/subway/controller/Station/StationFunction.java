package subway.controller.Station;

import subway.domain.StationRepository;
import subway.utils.exception.AlreadyRegisterStationException;
import subway.view.InputView;
import subway.view.StationOutputView;

public class StationFunction {
        public void registerStation(StationOutputView stationOutputView) {
        try {
            stationOutputView.inputRegisterStation();
            String station = InputView.inputStation();
            StationRepository.registerStation(station);
            stationOutputView.successRegister();
        } catch (NullPointerException | AlreadyRegisterStationException e) {
            return;
        }
    }

    public void deleteStation() {
        System.out.println("역 삭제하기\n");
    }

    public void printStations(StationOutputView stationOutputView) {
        stationOutputView.printStations(StationRepository.stations());
    }
}
