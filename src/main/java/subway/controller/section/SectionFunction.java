package subway.controller.section;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.utils.exception.AlreadyExistStationOfLineException;
import subway.utils.exception.InvalidOrderLengthException;
import subway.utils.exception.NotExistLineException;
import subway.utils.exception.NotExistStationException;
import subway.view.InputView;
import subway.view.SectionOutputView;

public class SectionFunction {
    public void registerSection(SectionOutputView sectionOutputView) {
        try {
            sectionOutputView.inputRegisterLineOfSection();
            String line = inputRegisterLineOfSection();
            sectionOutputView.inputRegisterStationOfSection();
            String station = inputRegisterStationOfSection(line);
            sectionOutputView.inputRegisterOrderOfSection();
            String order = inputRegisterOrderOfSection(line);
            LineRepository.addLine(line, station, order);
            sectionOutputView.successRegisterSection();
        } catch (NullPointerException | NotExistLineException | NotExistStationException | AlreadyExistStationOfLineException e) {
            return;
        }
    }

    private String inputRegisterLineOfSection() {
        String line = InputView.inputLine();
        if (!LineRepository.hasLine(line)) {
            throw new NotExistLineException();
        }
        return line;
    }

    private String inputRegisterStationOfSection(String line) {
        String station = InputView.inputStation();
        if (!StationRepository.alreadyRegister(station)) {
            throw new NotExistStationException();
        }

        if (LineRepository.hasStationOfLine(station, line)) {
            throw new AlreadyExistStationOfLineException();
        }
        return station;
    }

    private String inputRegisterOrderOfSection(String line) {
        try {
            String order = InputView.inputOrder();
            invalidOrderLength(order, line);
            return order;
        } catch (NullPointerException | InvalidOrderLengthException e) {
            throw new NullPointerException();
        }
    }

    private void invalidOrderLength(String order, String line) {
        int length = LineRepository.lineLength(line);
        int orderInt = Integer.parseInt(order);
        if (orderInt < 1 || orderInt > length) {
            throw new InvalidOrderLengthException();
        }
    }
}
