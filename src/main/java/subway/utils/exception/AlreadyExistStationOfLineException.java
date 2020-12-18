package subway.utils.exception;

import subway.view.ErrorOutputView;

public class AlreadyExistStationOfLineException extends RuntimeException {
    public AlreadyExistStationOfLineException() {
        ErrorOutputView.alreadyExistStationOfLine();
    }
}
