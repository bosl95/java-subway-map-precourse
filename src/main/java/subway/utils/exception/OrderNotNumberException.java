package subway.utils.exception;

import subway.view.ErrorOutputView;

public class OrderNotNumberException extends RuntimeException {
    public OrderNotNumberException() {
        ErrorOutputView.orderNotNumber();
    }
}
