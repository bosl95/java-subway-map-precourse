package subway.utils.exception;

import subway.view.ErrorOutputView;

public class NotExistStationOfLineException extends RuntimeException {
    public NotExistStationOfLineException() {
        ErrorOutputView.notExistStationOfLine();
    }
}
