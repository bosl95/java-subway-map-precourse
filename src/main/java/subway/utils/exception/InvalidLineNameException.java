package subway.utils.exception;

import subway.view.ErrorOutputView;

public class InvalidLineNameException extends RuntimeException {
    public InvalidLineNameException() {
        ErrorOutputView.invalidLineName();
    }
}
