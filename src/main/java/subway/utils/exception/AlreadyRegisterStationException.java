package subway.utils.exception;

import subway.view.ErrorOutputView;

public class AlreadyRegisterStationException extends RuntimeException {
    public AlreadyRegisterStationException() {
        ErrorOutputView.alreadyRegisterStation();
    }
}
