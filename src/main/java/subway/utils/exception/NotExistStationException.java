package subway.utils.exception;

import subway.view.ErrorOutputView;

public class NotExistStationException extends RuntimeException {
    public NotExistStationException() {
        ErrorOutputView.notExistStation();
    }
}
