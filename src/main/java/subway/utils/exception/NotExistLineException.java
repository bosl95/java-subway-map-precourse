package subway.utils.exception;

import subway.view.ErrorOutputView;

public class NotExistLineException extends RuntimeException {
    public NotExistLineException() {
        ErrorOutputView.notExistLine();
    }
}
