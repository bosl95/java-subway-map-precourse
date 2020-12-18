package subway.utils.exception;

import subway.view.ErrorOutputView;

public class InvalidOrderLengthException extends RuntimeException {
    public InvalidOrderLengthException() {
        ErrorOutputView.invalidOrderLength();
    }
}
