package subway.utils.exception;

import subway.view.ErrorOutputView;

public class InvalidLineLengthException extends RuntimeException {
    public InvalidLineLengthException() {
        ErrorOutputView.invalidLineLength();
    }
}
