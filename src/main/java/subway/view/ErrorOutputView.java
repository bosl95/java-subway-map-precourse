package subway.view;

public class ErrorOutputView extends OutputView {
    private static String ERROR_SYMBOL = "\n[ERROR] ";
    private static String INVALID_MENU_INPUT = "선택할 수 없는 기능입니다.\n";
    private static String INVALID_STATION_INPUT = "잘못된 역 이름입니다.\n";
    private static String INVALID_LINE_INPUT = "잘못된 노선 이름입니다.\n";
    private static String REGISTERED_STATION = "이미 등록된 역 이름입니다.\n";
    private static String NOT_EXIST_STATION = "등록되지 않은 역입니다.\n";
    private static String STATION_IN_LINE = "역이 노선에 등록되어있습니다.\n";
    private static String EQUAL_FIRST_LAST_STATIONS = "상행 종점역과 하행 종점역이 일치합니다.\n";
    private static String REGISTERED_LINE = "이미 등록된 노선 이름입니다.\n";
    private static String NOT_EXIST_LINE = "등록되지 않은 노선입니다.\n";
    private static String ORDER_NOT_NUMBER = "순서는 숫자만 입력 가능합니다.\n";
    private static String STATION_IN_SELECT_LINE = "해당 노선에 역이 존재합니다.\n";
    private static String INVALID_ORDER_LENGTH = "순서의 범위를 벗어났습니다.\n";
    
    public static void invalidMenuInput() {
        printError(INVALID_MENU_INPUT);
    }

    public static void invalidStationName() {
        printError(INVALID_STATION_INPUT);
    }

    private static void errorSymbol() {
        stringBuilder.append(ERROR_SYMBOL);
    }

    public static void alreadyRegisterStation() {
        printError(REGISTERED_STATION);
    }

    public static void notExistStation() {
        printError(NOT_EXIST_STATION);
    }

    public static void stationInAnyLine() {
        printError(STATION_IN_LINE);
    }

    public static void invalidLineName() {
        printError(INVALID_LINE_INPUT);
    }

    public static void equalFirstLastStations() {
        printError(EQUAL_FIRST_LAST_STATIONS);
    }

    public static void alreadyRegisterLine() {
        printError(REGISTERED_LINE);
    }

    public static void notExistLine() {
        printError(NOT_EXIST_LINE);
    }

    public static void orderNotNumber() {
        printError(ORDER_NOT_NUMBER);
    }

    public static void alreadyExistStationOfLine() {
        printError(STATION_IN_SELECT_LINE);
    }

    public static void invalidOrderLength() {
        printError(INVALID_ORDER_LENGTH);
    }

    private static void printError(String error) {
        errorSymbol();
        stringBuilder.append(error);
        print();
    }
}
