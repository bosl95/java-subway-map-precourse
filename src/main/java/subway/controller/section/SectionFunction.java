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
        } catch (InvalidLineNameException | InvalidStationNameException | NotExistLineException     // 구간 메뉴의 노선 이름 입력 예외 발생
                | NotExistStationException | AlreadyExistStationOfLineException                     // 구간 메뉴의 역 이름 입력 예외 발생
                | OrderNotNumberException | InvalidOrderLengthException e) {                        // 구간 메뉴의 순서 입력 예외 발생
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
        String order = InputView.inputOrder();
        invalidOrderLength(order, line);
        return order;
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
            String line = inputLineOfSection();
            isValidLineLength(line);
            sectionOutputView.inputDeleteStationOfSection();
            String station = inputDeleteStationOfSection(line);
            LineRepository.deleteStationOfLine(line, station);
            sectionOutputView.successDeleteSection();
        } catch (InvalidLineNameException | NotExistLineException | InvalidLineLengthException |                // 삭제할 구간의 노선 입력 예외 발생
                InvalidStationNameException | NotExistStationException | NotExistStationOfLineException e) {    // 삭제할 구간의 역 이름 입력 예외 발생
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
}
