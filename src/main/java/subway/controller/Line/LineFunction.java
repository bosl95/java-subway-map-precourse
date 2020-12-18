package subway.controller.Line;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.utils.exception.AlreadyRegisterStationException;
import subway.utils.exception.EqualFirstLastStationsException;
import subway.view.InputView;
import subway.view.LineOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LineFunction {
    public void registerLine(LineOutputView lineOutputView) {
        try {
            lineOutputView.inputRegisterLine();
            String line = inputLine();
            List<String> stations = inputFistLastStations(lineOutputView);
            LineRepository.addLine(Line.from(line, stations));
            lineOutputView.successRegister();
        } catch (NullPointerException | EqualFirstLastStationsException | AlreadyRegisterStationException e) {
            return;
        }
    }

    private String inputLine() {
        String line = InputView.inputLine();
        if (LineRepository.hasLine(line)) {
            throw new AlreadyRegisterStationException();
        }
        return line;
    }

    private List<String> inputFistLastStations(LineOutputView lineOutputView) {
        lineOutputView.inputFirstStations();
        String firstStation = InputView.inputStation();
        lineOutputView.inputLastStations();
        String lastStation = InputView.inputStation();
        if (Objects.equals(firstStation, lastStation)) {
            throw new EqualFirstLastStationsException();
        }
        return Arrays.asList(firstStation, lastStation);
    }
}
