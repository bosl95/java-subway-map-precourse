package subway.controller.section;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.utils.exception.*;
import subway.view.InputView;
import subway.view.SectionOutputView;

public class SectionFunction {
    private static int MIN_LINE_LENGTH = 2;

    public void registerSection(SectionOutputView sectionOutputView) {
        try {
            sectionOutputView.inputRegisterLineOfSection();
            String line = inputLineOfSection();
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

    private String inputLineOfSection() {
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

    public void deleteSection(SectionOutputView sectionOutputView) {
        try {
            sectionOutputView.inputDeleteLineOfSection();
            String line = inputDeleteLineOfSection();
            isValidLineLength(line);
            sectionOutputView.inputDeleteStationOfSection();
            String station = inputDeleteStationOfSection(line);
            LineRepository.deleteStationOfLine(line, station);
            sectionOutputView.successDeleteSection();
        } catch (NullPointerException | InvalidLineLengthException | NotExistStationException | NotExistStationOfLineException e) {
            return;
        }
    }

    private void isValidLineLength(String line) {
        if (LineRepository.lineLength(line) <= MIN_LINE_LENGTH) {
            throw new InvalidLineLengthException();
        }
    }

    private String inputDeleteStationOfSection(String line) {
        String station = InputView.inputStation();
        if (!StationRepository.alreadyRegister(station)) {
            throw new NotExistStationException();
        }

        if (!LineRepository.hasStationOfLine(station, line)) {
            throw new NotExistStationOfLineException();
        }
        return station;
    }

    private String inputDeleteLineOfSection() {
        try {
            String line = inputLineOfSection();
            return line;
        } catch (InvalidLineNameException | NotExistLineException e) {
            throw new NullPointerException();
        }
    }
}
