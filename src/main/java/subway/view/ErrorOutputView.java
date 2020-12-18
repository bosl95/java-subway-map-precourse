package subway.view;

public class ErrorOutputView extends OutputView {
    private static String ERROR_SYMBOL = "\n[ERROR] ";
    private static String INVALID_MENU_INPUT = "선택할 수 없는 기능입니다.\n";
    private static String INVALID_STATION_MENU_INPUT = "잘못된 역 이름입니다.\n";
    private static String REGISTERED_STATION = "이미 등록된 역 이름입니다.\n";
    private static String NOT_EXIST_STATION = "등록되지 않은 역입니다.\n";
    private static String STATION_IN_LINE = "역이 노선에 등록되어있습니다.\n";

    public static void invalidMenuInput() {
        errorSymbol();
        stringBuilder.append(INVALID_MENU_INPUT);
        print();
    }

    public static void invalidStationName() {
        errorSymbol();
        stringBuilder.append(INVALID_STATION_MENU_INPUT);
        print();
    }

    private static void errorSymbol() {
        stringBuilder.append(ERROR_SYMBOL);
    }

    public static void alreadyRegisterStation() {
        errorSymbol();
        stringBuilder.append(REGISTERED_STATION);
        print();
    }

    public static void notExistStation() {
        errorSymbol();
        stringBuilder.append(NOT_EXIST_STATION);
        print();
    }

    public static void stationInAnyLine() {
        errorSymbol();
        stringBuilder.append(STATION_IN_LINE);
        print();
    }
}
