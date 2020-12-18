package subway.utils.exception;

import subway.view.ErrorOutputView;

public class AlreadyRegisterLineException extends RuntimeException {
    public AlreadyRegisterLineException() {
        ErrorOutputView.alreadyRegisterLine();
    }
}
