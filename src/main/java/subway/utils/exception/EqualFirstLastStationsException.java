package subway.utils.exception;

import subway.view.ErrorOutputView;

public class EqualFirstLastStationsException extends RuntimeException {
    public EqualFirstLastStationsException() {
        ErrorOutputView.equalFirstLastStations();
    }
}
