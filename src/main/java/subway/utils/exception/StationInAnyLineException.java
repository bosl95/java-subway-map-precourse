package subway.utils.exception;

import subway.view.ErrorOutputView;

public class StationInAnyLineException extends RuntimeException {
    public StationInAnyLineException() {
        ErrorOutputView.stationInAnyLine();
    }
}
