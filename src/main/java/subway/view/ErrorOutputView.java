package subway.view;

public class ErrorOutputView extends OutputView{
    private static String ERROR_SYMBOL = "[ERROR] ";
    private static String INVALID_MENU_INPUT = "선택할 수 없는 기능입니다.\n";

    public static void invalidMenuInput() {
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(ERROR_SYMBOL);
        stringBuilder.append(INVALID_MENU_INPUT);
        print();
    }
}
