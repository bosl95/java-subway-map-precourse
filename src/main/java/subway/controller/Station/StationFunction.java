package subway.controller.Station;

import subway.domain.StationRepository;
import subway.utils.exception.AlreadyRegisterStationException;
import subway.utils.exception.InvalidStationNameException;
import subway.utils.exception.NotExistStationException;
import subway.utils.exception.StationInAnyLineException;
import subway.view.InputView;
import subway.view.StationOutputView;

public class StationFunction {
    public void registerStation(StationOutputView stationOutputView) {
        try {
            stationOutputView.inputRegisterStation();
            String station = InputView.inputStation();
            StationRepository.registerStation(station);
            stationOutputView.successRegister();
        } catch (InvalidStationNameException | AlreadyRegisterStationException e) {
            return;
        }
    }

    public void deleteStation(StationOutputView stationOutputView) {
        try {
            stationOutputView.inputDeleteStation();
            String station = InputView.inputStation();
            StationRepository.deleteStation(station);
        } catch (NotExistStationException | StationInAnyLineException e) {
            return;
        }
    }

    public void printStations(StationOutputView stationOutputView) {
        stationOutputView.printStations(StationRepository.stations());
    }
}
