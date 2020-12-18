package subway.utils.exception;

import subway.view.ErrorOutputView;

public class InvalidStationNameException extends RuntimeException {
    public InvalidStationNameException() {
        ErrorOutputView.invalidStationName();
    }
}
